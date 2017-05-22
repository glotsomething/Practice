package com.example.minji.viewfilpper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button prev;
    Button next;
    ViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        prev = (Button) findViewById(R.id.prev);
        next = (Button) findViewById(R.id.next);

        prev.setOnClickListener(this);
        next.setOnClickListener(this);
    }
        @Override
        public void onClick(View v){
            //prev 버튼이 클릭되었을 때
            if(v == prev){
                flipper.showPrevious();

                //next 버튼이 클릭되었을 때
        }else if(v == next){
                flipper.showNext();
            }

    }
}
