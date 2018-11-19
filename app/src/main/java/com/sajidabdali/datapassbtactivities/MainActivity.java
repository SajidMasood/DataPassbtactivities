package com.sajidabdali.datapassbtactivities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_goto;

    // TODO: 11/19/2018 for back data...
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_goto = (Button) findViewById(R.id.btn_activity);
        btn_goto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Message","Hello from Firest Activity");
                intent.putExtra("SeccondMessage","Hello Again");
                intent.putExtra("Value",123);
                // pher ye na hoga...
                // startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);


                // when send and get data b/t activities.... then do that
            }
        });



    }

    // TODO: 11/19/2018 for data back to mainActivity.....

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            //
            if (resultCode == RESULT_OK){
                // store data in string... intent putExtra msg name from other activity...
                String result = data.getStringExtra("returnData");

                Toast.makeText(MainActivity.this,"Value :"+result,Toast.LENGTH_LONG).show();
            }
        }
    }


}
