package com.example.danie.daniel2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaCodec;
import android.support.annotation.NonNull;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
    EditText etEmail,etUsername,etPassword,etConfirmPassword;
    Button btDone;
    ProgressBar progressBar;
    String Global ;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth=FirebaseAuth.getInstance();

       // databaseAccount= FirebaseDatabase.getInstance().getReference("account");

        etEmail = (EditText) findViewById(R.id.etEmail);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);

        btDone = (Button) findViewById(R.id.btDone);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);


        btDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int x= DoneClick();
                if(x==1){
//                    Toast.makeText(SignupActivity.this, "ss", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(SignupActivity.this, "Error", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (firebaseAuth.getCurrentUser() != null){
          //  Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            //handle already login user
        }else {
            Toast.makeText(this, "Not yet login", Toast.LENGTH_SHORT).show();
        }

    }

    private int  DoneClick() {
        int x;
        final String username = etUsername.getText().toString();
        final String email = etEmail.getText().toString();
        final String password = etPassword.getText().toString();

        if(email.isEmpty()) {
            etEmail.setError("Email is empty");
            etEmail.requestFocus();
            x=0;
            return x;
        }

        if(username.isEmpty()) {
            etUsername.setError("Username is empty");
            etUsername.requestFocus();
            x=0;
            return x;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password is empty");
           etPassword.requestFocus();
            x=0;
            return x;
        }
        if(password.length()<6) {
            etPassword.setError("must have 6 characters");
            etPassword.requestFocus();
            validatePassword(password);
            x=0;
            return x;
        }
        if(!etConfirmPassword.getText().toString().equals(etPassword.getText().toString())){
            etConfirmPassword.setError("Password incorrect ");
            etConfirmPassword.requestFocus();
            x=0;
            return x;

        }else {
            progressBar.setVisibility(View.VISIBLE);
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){


                        Login(email,password,username);

                        Toast.makeText(SignupActivity.this,"Signup Successfull",Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);


                        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                        firebaseAuth.signOut();

                    }
                    else
                        Toast.makeText(SignupActivity.this,"Signup Failed",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

                }

            });
            x=1;
            return x;
        }



    }




    public void Login(String email,String password,String username){
        final User user = new User(
                email,username
        );
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Global= firebaseAuth.getCurrentUser().getUid();
                    Toast.makeText(SignupActivity.this,"Uid:"+Global,Toast.LENGTH_LONG).show();
                    FirebaseDatabase.getInstance().getReference("Users").child(Global).setValue(user)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()){

                              Toast.makeText(SignupActivity.this,"Completed",Toast.LENGTH_LONG).show();

                            }
                            else {
                                Toast.makeText(SignupActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(SignupActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void validatePassword(String password){
        Pattern upperCase = Pattern.compile("[A-Z]");
        Pattern digitCase = Pattern.compile("[0-9]");

        if(!upperCase.matcher(password).find()){
            Toast.makeText(this,"UpperCase required",Toast.LENGTH_LONG).show();
        }
        if(!digitCase.matcher(password).find()){
            Toast.makeText(this,"Numbers required",Toast.LENGTH_LONG).show();
        }
    }
}



//                                    Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
//                                    startActivity(intent);

//                        Toast.makeText(SignupActivity.this, "Done"+Global, Toast.LENGTH_SHORT).show();
//                        User user = new User(
//                                email,username
//                        );

//                        FirebaseDatabase.getInstance().getReference("Users")
//                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                progressBar.setVisibility(View.GONE);
//                                if (task.isSuccessful()){
//
//
//                                    Toast.makeText(SignupActivity.this,"Completed",Toast.LENGTH_LONG).show();
////                                    Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
////                                    startActivity(intent);
//
//
//
//                                }else {
//                                    Toast.makeText(SignupActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//
//                                }
//
//                            }
//                        });