package com.example.anurag.spider_2;

import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.Random;


public class NewActivity extends AppCompatActivity{
    int c;
    boolean b;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c = 0;
        setContentView(R.layout.activity_main);
        Random random = new Random();
        int r = random.nextInt(2)+0;
        String[] animals = {"elephant","shark","hen"};
        final String animal= animals[r];
        final char[] anime = new char[animal.length() * 2 - 1];


        for( int i=0 ; i< anime.length  ; i++ ){

            if(i % 2 == 1){
                anime[i] = ' ';
            }else {
                anime[i] = '_';
            }
        }

        final EditText edittext =findViewById(R.id.edittext);

        String value = "";
        for(int i =0 ; i < anime.length ; ++i ){

            if(i % 2 == 1){
                value = value + " ";
            }else {
                value = value + anime[i];
            }
        }
        edittext.setText(value);

       edittext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               edittext.setSelection(0);
           }
       });

       final boolean tem;

        edittext.addTextChangedListener( new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(c > 3 ){
                    edittext.removeTextChangedListener(this);
                    edittext.setText("GAME OVER");
                   edittext.setClickable(false);
                    return;
                }

               final String save = edittext.getText().toString();

                for(int i=0 ; i< animal.length() ; i++){

                    if(save.charAt(0)==animal.charAt(i)){
                            b=true;
                         anime[2*i]=save.charAt(0);


                    }

                }
                if(b==false)
                {

                    c+=1;
                }





            }

            @Override
            public void afterTextChanged(Editable s) {

                if(c>3){
                    edittext.setText("GAME OVER");
                    return;
                }
                edittext.removeTextChangedListener(this);

                String value = "";
                for(int i =0 ; i < anime.length ; ++i ){
                    if(i % 2 == 1){
                        value = value + " ";
                    }else {
                        value = value + anime[i];
                    }
                 }
                edittext.setText(value.toUpperCase());

                edittext.addTextChangedListener(this);

            }
        });





    }


}
