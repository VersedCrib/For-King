package com.example.for_king;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class GameActivity1 extends Activity {
    int idRb;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Game game = new Game();
        //Intent i = new Intent(GameActivity1.this, EndActivity.class);
        //game.main(i.getStringExtra("name"));


        Intent i = this.getIntent();
        Bundle bundle = i.getExtras();

        setGame((Game) bundle.getSerializable(Game.class.getSimpleName()));
        game.setCondition(Integer.toString(0));

        TextView tw_inf =(TextView) findViewById(R.id.tw_inf_game);
        tw_inf.setText(game.getAnswer());
        tw_inf.setText(game.getAnswer());

        TextView tw_name = (TextView) findViewById(R.id.tw_name);
        TextView tw_gold = (TextView) findViewById(R.id.tw_gold);

        tw_name.setText("Name: " + game.gamers.name);
        tw_gold.setText("Gold: " + game.gamers.gold);


        RadioButton rb1 = (RadioButton) findViewById(R.id.rb_1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.rb_2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.rb_3);

        rb1.setText(game.getRB(getId(R.id.rb_1)));
        rb2.setText(game.getRB(getId(R.id.rb_2)));
        rb3.setText(game.getRB(getId(R.id.rb_3)));

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                idRb = checkedId;
            }
        });

        Button b = (Button) findViewById(R.id.b_answer);
        View.OnClickListener listener = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Game game = new Game(name,Integer.toString(getId()));
                //game.setCondition(Integer.toString(getId(idRb) - 1));
                //game.setValue();
                game.setCondition(Integer.toString(getId()));
                game.action();

                Intent i;
                if(game.nextGame){
                    i = new Intent(GameActivity1.this, GameActivity1.class);
                    i.putExtra(Game.class.getSimpleName(),game);
                    startActivity(i);
                } else {
                    //i.putExtra(Game.class.getCanonicalName(),game);
                    i = new Intent(GameActivity1.this, EndActivity.class);
                    startActivity(i);
                    //i.putExtra(Game.class.getCanonicalName(),game);
                }


            }
        });

        b.setOnClickListener(listener);

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
        return 1;
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
        return 1;
    }

    public void setGame(Game game){
        this.game = game;
    }

}
