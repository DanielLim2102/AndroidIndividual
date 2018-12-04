package com.example.danie.daniel2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Content_Activity extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvcategory,tvserving,tvdifficulty,tvprep;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_);

        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvdescription = (TextView) findViewById(R.id.txtdescription);
        tvcategory = (TextView) findViewById(R.id.txtcategory);
        tvserving = (TextView) findViewById(R.id.txtserving);
        tvdifficulty = (TextView) findViewById(R.id.txtdifficulty);
        tvprep = (TextView) findViewById(R.id.txtpt);

        img = (ImageView) findViewById(R.id.content_img_id);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Category= intent.getExtras().getString("Category");
        String Description = intent.getExtras().getString("Description");
        String Serving= intent.getExtras().getString("Serving");
        String Difficulty = intent.getExtras().getString("Difficulty");
        String Prep = intent.getExtras().getString("Prep");


        int image =intent.getExtras().getInt("Thumbnail");

        //Set values
        tvtitle.setText(Title);
        tvcategory.setText(Category);
        tvdescription.setText(Description);
        tvserving.setText(Serving);
        tvdifficulty.setText(Difficulty);
        tvprep.setText(Prep);

        img.setImageResource(image);


    }

}
