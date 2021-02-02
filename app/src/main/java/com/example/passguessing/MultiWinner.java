package com.example.passguessing;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MultiWinner extends AppCompatActivity {

    private Toolbar toolbar;
    CardView one,two,btnone,btntwo;
    TextView nameplayerone,nameplayertwo,playeronetry,playeronepass,playertwopass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_winner);
        toolbar=findViewById(R.id.toolBarHeader);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String PLAYERONETRY=getIntent().getStringExtra("playeronetryamount");
        String PLAYERTWOTRY=getIntent().getStringExtra("playertwotryamount");
        String PLAYERTWOPASS=getIntent().getStringExtra("playertwopassword");
        String PLAYERONEPASS=getIntent().getStringExtra("playeronepassword");
        String WINNER=getIntent().getStringExtra("winner");
        int winner=Integer.parseInt(WINNER);

        nameplayerone=(TextView)findViewById(R.id.nameofPlayer);
        nameplayertwo=(TextView)findViewById(R.id.nameofPlayer2);
        playeronetry=(TextView)findViewById(R.id.TRYamount);
        playeronepass=(TextView)findViewById(R.id.password);
        playertwopass=(TextView)findViewById(R.id.password2);

        btnone=(CardView)findViewById(R.id.MultiWinnerHome);
        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MultiWinner.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        btntwo=(CardView)findViewById(R.id.MultiWinnerplayAgain);
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MultiWinner.this,MultiPlayerSetting.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        Animation animation= AnimationUtils.loadAnimation(MultiWinner.this,R.anim.blink_anim);
        one=(CardView)findViewById(R.id.winnercardview1);
        one.startAnimation(animation);
        two=(CardView)findViewById(R.id.winnercardview2);

        if (winner==1)
        {
            nameplayerone.setText("1st Place Player One");
            nameplayertwo.setText("2nd Place Player Two");
            playeronetry.setText("It Took You "+PLAYERONETRY+" Try");
            playeronepass.setText("The Password was "+PLAYERTWOPASS);
            playertwopass.setText("The Password was "+PLAYERONEPASS);
        }
        else if (winner==2)
        {
            nameplayerone.setText("1st Place Player Two");
            nameplayertwo.setText("2nd Place Player One");
            playeronetry.setText(""+PLAYERTWOPASS);
            playeronetry.setTextSize(26);
            playeronetry.setGravity(Gravity.CENTER_HORIZONTAL);
            playeronepass.setText("The Password was "+PLAYERTWOPASS);
            playertwopass.setText("The Password was "+PLAYERTWOPASS);
        }
        else
        {
            two.setVisibility(View.INVISIBLE);
            nameplayerone.setText("It is Draw ");
            nameplayerone.setTextSize(25);
            playeronetry.setText("Player one's password was :"+PLAYERONEPASS);
            playeronepass.setText("Player two's password was :"+PLAYERTWOPASS);
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
