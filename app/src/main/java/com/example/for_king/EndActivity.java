package com.example.for_king;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EndActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);


        Intent i = this.getIntent();
        Bundle bundle = i.getExtras();

        Game game = (Game) bundle.getSerializable(Game.class.getSimpleName());

        TextView tw_name = (TextView) findViewById(R.id.tw_end);
        tw_name.setText(game.getEnd());

    }
}
