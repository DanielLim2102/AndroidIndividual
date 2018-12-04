package com.example.danie.daniel2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danie on 25/11/2018.
 */

public class HomeFragment extends Fragment {

    View v;
    private RecyclerView myrv;
//    private Content ctitle;
    List<Content> c1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_home,container,false);


        myrv= (RecyclerView)v.findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter recycleadapter = new RecyclerViewAdapter(getContext(),c1);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false));
        myrv.setAdapter(recycleadapter);


        return v;


    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EditText editText = (EditText)v.findViewById(R.id.search);
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
////                filter(s.toString());
//
//            }
//        });

       // String title, String category, String description,String serving,String difficulty,String prep ,int thumbnail
        c1 = new ArrayList<>();
        c1.add(new Content("American Pancake ","Breakfast","1 Cup All-purpose flour\n" +
                "\n" +
                "2 1/2 tsp Baking powder\n" +
                "1/2 tsp Salt\n" +
                "3/4 Tbsp White sugar\n" +
                "\n" +
                "3/4 Cups Milk\n" +
                "1 Small Egg\n" +
                "2 Tbsp Butter, melted\n" +
                "Toppings:\n" +
                "\n" +
                "Melted butter\n" +
                "Maple syrup or honey\n" +
                "Mixed berries (or any other mixed fruit of your choice)\n" +
                "Sugar, powdered","2","Easy","30 mins",R.drawable.pancakes));

        c1.add(new Content("Spaghetti & meatballs","Pasta","1 tsp rapeseed oil\n" +
                "\n" +
                "280g spaghetti\n" +
                "For the meatballs\n" +
                "200g green lentils\n" +
                "\n" +
                " (well drained weight from a 400g can)\n" +
                "250g lean minced pork (max 8% fat)\n" +
                "½ tsp finely chopped rosemary\n" +
                "\n" +
                "½ tsp Dijon mustard\n" +
                "1 garlic clove, crushed\n" +
                "For the sauce\n" +
                "1 tbsp rapeseed oil\n" +
                "\n" +
                "2 shallots, finely chopped\n" +
                "2 garlic cloves, finely chopped\n" +
                "500g cherry tomatoes, preferably on the vine, halved\n" +
                "2 tsp tomato purée\n" +
                "pinch of chilli flakes\n" +
                "2 tbsp chopped oregano,\n" +
                "\n" +
                " plus a few chopped leaves to garnish","4","Easy","35 mins",R.drawable.spaget));

        c1.add(new Content("Malmö meatball subs ","Meatball","1-2 tbsp sunflower oil, \n" +
                "\n" +
                "for frying\n" +
                "2 tbsp white wine vinegar\n" +
                "1 tbsp golden caster sugar\n" +
                "⅓ cucumber, thinly sliced\n" +
                "1 tbsp chopped dill (optional)\n" +
                "4 sub rolls, halved, or 1 long, thin baguette, cut into 5cm chunks\n" +
                "jar cranberry\n" +
                "\n" +
                " sauce\n" +
                "For the meatballs\n" +
                "300g pack pork mince\n" +
                "50g breadcrumb\n" +
                "1 tsp caraway or fennel seeds\n" +
                "1 egg,\n" +
                "\n" +
                "beaten\n" +
                "3 tbsp wholegrain mustard\n" +
                "1 tbsp clear honey\n" +
                "good grating nutmeg","3","Easy","45 mins",R.drawable.ball));

        c1.add(new Content("Bhaji burger ","Burger","For the burgers\n" +
                "400g lamb mince\n" +
                "2 tbsp tandoori paste\n" +
                "1 tsp cumin seeds\n" +
                "For the raita\n" +
                "½ cucumber\n" +
                "150g pot plain yogurt\n" +
                "½ small pack mint,\n" +
                "\n" +
                " leaves chopped\n" +
                "For the bhajis\n" +
                "100g plain flour\n" +
                "1 tbsp garam masala\n" +
                "\n" +
                "1 tsp bicarbonate of soda\n" +
                "\n" +
                "1 onion\n" +
                "\n" +
                ", halved and finely sliced\n" +
                "3 tbsp sunflower oil\n" +
                "\n" +
                "To serve\n" +
                "3 burger buns (we used brioche buns), toasted\n" +
                "a few lettuce\n" +
                "\n" +
                " leaves\n" +
                "red onion, thinly sliced\n" +
                "mango chutney","1","Normal","20 mins",R.drawable.burger));

        c1.add(new Content("Pizza Margherita","Pizza","For the pizza dough\n" +
                "350g strong white flour\n" +
                "\n" +
                "25g coarse semolina,\n" +
                "\n" +
                " plus extra for sprinkling\n" +
                "1½ tsp salt\n" +
                "7g pkt fast-action dried yeast\n" +
                "\n" +
                "1 tbsp olive oil,\n" +
                "\n" +
                " (not extra virgin) plus extra for drizzling\n" +
                "275ml tepid water\n" +
                "For the topping\n" +
                "400g can plum tomato\n" +
                "\n" +
                "2 plump garlic cloves, finely chopped\n" +
                "2 tbsp tomato purée\n" +
                "2 balls buffalo mozzarella, (about 140g each)\n" +
                "two small handfuls basil\n" +
                "\n" +
                " leaves, roughly torn parmesan shavings and rocket, to serve","5","Hard","75mins",R.drawable.pizza));

        c1.add(new Content("Lemon meringue pie","Pie","For the pastry\n" +
                "140g unsalted butter\n" +
                "100g icing sugar\n" +
                "2 large egg yolks, beaten\n" +
                "1 vanilla pod, seeds scraped out\n" +
                "zest 1 lemon\n" +
                "\n" +
                "2 tbsp cold milk\n" +
                "\n" +
                "250g plain flour\n" +
                "For the lemon filling\n" +
                "6 eggs\n" +
                "\n" +
                "140g caster sugar\n" +
                "4 unwaxed lemons, zest and juice\n" +
                "175ml double cream\n" +
                "For the meringue\n" +
                "300g caster sugar\n" +
                "25g liquid glucose\n" +
                "4 egg whites\n" +
                "limoncello, ice-cold, to serve, optional","8","Hard","80 mins",R.drawable.pie));

        c1.add(new Content("Omelette wedges","Omelette","3 spring onions\n" +
                "\n" +
                "200g new potatoes\n" +
                "\n" +
                "4 rashers smoked bacon\n" +
                "2 tbsp sunflower oil,\n" +
                "\n" +
                " plus 1 tsp\n" +
                "8 eggs\n" +
                "\n" +
                "1 tsp English mustard (ready-made rather than powder)\n" +
                "85g mature cheddar\n" +
                "2 tomatoes","4","Easy","30 mins",R.drawable.omelette));

        c1.add(new Content("Clam chowder","Soup","1½ kg clams or a mixture of clams and cockles\n" +
                "50g butter\n" +
                "\n" +
                "150g unsmoked bacon\n" +
                "\n" +
                " lardons, cubed pancetta or chopped streaky bacon,\n" +
                "1 onion\n" +
                "\n" +
                " finely chopped\n" +
                "sprig of thyme\n" +
                "\n" +
                "1 bay leaf\n" +
                "1 tbsp plain flour\n" +
                "150ml milk\n" +
                "\n" +
                "150ml double cream\n" +
                "2 medium potatoes – about 250 grams, cut into cubes\n" +
                "chopped parsley\n" +
                "\n" +
                " and crusty bread to serve","6","Normal","45 mins",R.drawable.cc));






    }
//    private void filter(String text){
//        ArrayList<Content> filteredlist = new ArrayList<>();
//
//        for (Content item : c1 ){
//            if (item.getTitle().toLowerCase().contains(text.toLowerCase())){
//                filteredlist.add(item);
//            }
//        }

//        ctitle.filterlist(filteredlist);

//    }




}
