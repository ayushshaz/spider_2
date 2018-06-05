package com.example.anurag.spider_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int n=0;
    String name;

    private String prev;
    private char raw[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Random random = new Random();
       int r= random.nextInt(2)+0;
       String[] s={"lion","tiger","monkey"};
       final String randomname =s[r];

       raw = new char[randomname.length()];

       for(int i = 0 ; i < randomname.length() ; ++i){
           raw[i] = ' ';
       }




       final EditText edittext =findViewById(R.id.edittext);

        edittext.setText("");


       edittext.addTextChangedListener( new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

               n = randomname.length();
               String current = edittext.getText().toString();

               for(int i = 0 ; i < randomname.length() ; ++i){
                   if(current.charAt(0) == randomname.charAt(i)){
                       raw[i] = current.charAt(0);
                   }
               }

           }

           @Override
           public void afterTextChanged(Editable s) {
               edittext.removeTextChangedListener(this);
               String val = "";
               for(int i = 0 ; i < randomname.length() ; ++i){
                   val = val + raw[i];
               }
                edittext.setText(val);
                edittext.addTextChangedListener(this);
           }
       });
    }
}
