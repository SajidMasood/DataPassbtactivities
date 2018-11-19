package com.sajidabdali.datapassbtactivities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private Button btn_back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();

        textView = (TextView) findViewById(R.id.edt_text);
        btn_back = (Button) findViewById(R.id.button);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData","From Second Activity");
                // sending result matching....
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });





        // TODO: 11/19/2018 gettiing data in a string ...
        if (extras != null){
            String message = extras.getString("Message");
            textView.setText(message);

            int myInt = extras.getInt("Value");
            textView.setText(String.valueOf(myInt));
        }
    }



}
