package com.example.smartvoltmeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button MySql,Firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySql=(Button)findViewById(R.id.mysql);
        Firebase=(Button)findViewById(R.id.firebase);

        Firebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openFirebase();

            }
        });

        MySql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openSql();

                            }
        });
    }

    private void openSql()
    {
        Intent intent=new Intent(MainActivity.this,Firebase.class);
        startActivity(intent);
    }

    private void openFirebase()
    {
        Intent intent=new Intent(MainActivity.this,sql.class);
        startActivity(intent);
    }


}
