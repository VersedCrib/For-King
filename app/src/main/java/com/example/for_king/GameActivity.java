package com.example.for_king;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class GameActivity extends Activity {
    int idRb = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Game game = new Game("","");
        Intent i = this.getIntent();;
        final String name = i.getStringExtra("name");
        //game.main(i.getStringExtra("name"));

        TextView tw_name = (TextView) findViewById(R.id.tw_name);
        TextView tw_gold = (TextView) findViewById(R.id.tw_gold);

        tw_name.setText("Name: " + name);
        tw_gold.setText("Gold: " + 100);

        TextView tw_inf =(TextView) findViewById(R.id.tw_inf_game);
        tw_inf.setText(game.text.situations[0][0].s);

        RadioButton rb1 = (RadioButton) findViewById(R.id.rb_1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.rb_2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.rb_3);

        rb1.setText(game.getRB(getId(R.id.rb_1)));
        rb2.setText(game.getRB(getId(R.id.rb_2)));
        rb3.setText(game.getRB(getId(R.id.rb_3)));

        Button b = (Button) findViewById(R.id.b_answer);

        View.OnClickListener listener = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(GameActivity.this, GameActivity1.class);
                Game game = new Game(name,Integer.toString(getId()-1));
                //game.setCondition(Integer.toString(getId(idRb) - 1));
                //game.setValue();

                i.putExtra(Game.class.getSimpleName(), game);
                if(game.nextGame){
                    //i.putExtra(Game.class.getCanonicalName(),game);
                    startActivity(i);
                } else {
                    //i.putExtra(Game.class.getCanonicalName(),game);
                    i = new Intent(GameActivity.this, EndActivity.class);
                    startActivity(i);
                }

            }
        });

        b.setOnClickListener(listener);

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

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
