package com.example.passguessing;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SinglePlayer extends AppCompatActivity {
    private Toolbar toolbar;
    CardView cardView,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7;
  /*  Animation fadein;
    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            cardView.startAnimation(fadein);
            }
    };
    Runnable runnable2=new Runnable() {
        @Override
        public void run() {
            cardView2.startAnimation(fadein);
        }
    };
    Runnable runnable3=new Runnable() {
        @Override
        public void run() {
            cardView3.startAnimation(fadein);
           }
    };
    Runnable runnable4=new Runnable() {
        @Override
        public void run() {
            cardView4.startAnimation(fadein);
        }
    };
    Runnable runnable5=new Runnable() {
        @Override
        public void run() {
            cardView5.startAnimation(fadein);
        }
    };
    Runnable runnable6=new Runnable() {
        @Override
        public void run() {
            cardView6.startAnimation(fadein);
        }
    };
    Runnable runnable7=new Runnable() {
        @Override
        public void run() {
            cardView7.startAnimation(fadein);
        }
    };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        toolbar=findViewById(R.id.toolBarHeader);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cardView=(CardView)findViewById(R.id.levelone);
        cardView2=(CardView)findViewById(R.id.leveltwo);
        cardView3=(CardView)findViewById(R.id.levelthree);
        cardView4=(CardView)findViewById(R.id.levelfour);
        cardView5=(CardView)findViewById(R.id.levelfive);
        cardView6=(CardView)findViewById(R.id.levelsix);
        cardView7=(CardView)findViewById(R.id.levelseven);/*
        cardView.setVisibility(View.INVISIBLE);
        cardView2.setVisibility(View.INVISIBLE);
        cardView3.setVisibility(View.INVISIBLE);
        cardView4.setVisibility(View.INVISIBLE);
        cardView5.setVisibility(View.INVISIBLE);
        cardView6.setVisibility(View.INVISIBLE);
        fadein= AnimationUtils.loadAnimation(this,R.anim.fadein);
        handler.postDelayed(runnable,1000);
        handler.postDelayed(runnable2,2000);
        handler.postDelayed(runnable3,3000);
        handler.postDelayed(runnable4,4000);
        handler.postDelayed(runnable5,5000);
        handler.postDelayed(runnable6,6000);
        handler.postDelayed(runnable7,7000);*/

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SinglePlayer.this, GameZone.class);
                intent.putExtra("tryamout","15");
                intent.putExtra("level","1");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SinglePlayer.this, GameZone.class);
                intent.putExtra("tryamout","12");
                intent.putExtra("level","2");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SinglePlayer.this, GameZone.class);
                intent.putExtra("tryamout","9");
                intent.putExtra("level","3");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SinglePlayer.this, GameZone.class);
                intent.putExtra("tryamout","6");
                intent.putExtra("level","4");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SinglePlayer.this, GameZone.class);
                intent.putExtra("tryamout","10");
                intent.putExtra("level","5");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SinglePlayer.this, GameZone.class);
                intent.putExtra("tryamout","14");
                intent.putExtra("level","6");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SinglePlayer.this, GameZone.class);
                intent.putExtra("tryamout","18");
                intent.putExtra("level","7");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
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
