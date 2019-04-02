package com.example.bacpacapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class LiqActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liq);
        String names[]={"aLiquor1","aLiquor2","aLiquor3","aLiquor4"};
        Button listOfDrinks[]=new Button[4];
        LinearLayout LL = (LinearLayout)findViewById(R.id.buttonlayout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Button cancelButton=findViewById(R.id.cancel);
        cancelButton.setText("Cancel");
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });

        for(int i=0;i<4;i++) { //should be a while loop
            listOfDrinks[i] = new Button(this);
            listOfDrinks[i].setText(names[i]);
            LL.addView(listOfDrinks[i], params);
        }
    }
    private void cancel() {
        Intent intent = new Intent(LiqActivity.this, DrinksActivity.class);
        startActivity(intent);
        finish();
    }
}
