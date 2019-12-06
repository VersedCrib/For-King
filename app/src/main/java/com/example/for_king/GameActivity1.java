package com.example.for_king;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class GameActivity1 extends Activity {
    int idRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Game game = new Game();
        //Intent i = new Intent(GameActivity1.this, EndActivity.class);
        //game.main(i.getStringExtra("name"));

        /*
        Intent i = this.getIntent();
        Bundle bundle = i.getExtras();

        Game game = (Game) bundle.getSerializable(Game.class.getSimpleName());


        RadioButton rb1 = (RadioButton) findViewById(R.id.rb_1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.rb_2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.rb_3);

        rb1.setText(game.getRB(getId(R.id.rb_1)));
        rb2.setText(game.getRB(getId(R.id.rb_2)));
        rb3.setText(game.getRB(getId(R.id.rb_3)));*/


        Button b = (Button) findViewById(R.id.b_answer);
        View.OnClickListener listener = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        b.setOnClickListener(listener);

    }

    public void onRadioButtonClicked(View view) {
        // если переключатель отмечен
        boolean checked = ((RadioButton) view).isChecked();

        // Получаем нажатый переключатель
        if(checked){
            idRb = view.getId();
        }
    }

    public int getId(){
        switch (idRb){
            case R.id.rb_1:
                return 1;
            //break;

            case R.id.rb_2:
                return 2;
            //break;

            case R.id.rb_3:
                return 3;
            //break;
        }
        return 0;
    }

    public int getId(int idRb){
        switch (idRb){
            case R.id.rb_1:
                return 1;
            //break;

            case R.id.rb_2:
                return 2;
            //break;

            case R.id.rb_3:
                return 3;
            //break;
        }
        return 0;
    }


}
