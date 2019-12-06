package com.example.for_king;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button b = (Button) findViewById(R.id.b_start);

        View.OnClickListener listener = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e = (EditText) findViewById(R.id.et_name);
                Editable nameEd = e.getText();
                String name = nameEd.toString();
                if(!name.equals("")){
                    Intent i = new Intent(StartActivity.this, GameActivity.class);
                    i.putExtra("name", name);
                    startActivity(i);

                }
            }
        });

        b.setOnClickListener(listener);

    }
}
