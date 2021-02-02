package com.example.passguessing;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    TextView tip;
    ImageView image;
    CardView tipsCard;
    int[] tips ={R.string.tip1,R.string.tip2,R.string.tip3,R.string.tip4,R.string.tip5,R.string.tip6};
    int[] images={R.drawable.singleplayerscreen,R.drawable.winnerspage,R.drawable.drawercover};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolBarHeader);
        setSupportActionBar(toolbar);

        tip=(TextView)findViewById(R.id.gametips);
        image=(ImageView)findViewById(R.id.MainPageImage);
        tipsCard=(CardView)findViewById(R.id.tipsDisplay);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        final Random random=new Random();
        int tipindex=random.nextInt(5);
        int tipindex2=random.nextInt(3);
        tip.setText(tips[tipindex]);
        image.setImageResource(images[tipindex2]);
        tipsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.fadeout);
                tipsCard.startAnimation(animation);
                int tipindex2=random.nextInt(5);
                tip.setText(tips[tipindex2]);
                Animation animation1=AnimationUtils.loadAnimation(MainActivity.this,R.anim.fadein);
                tipsCard.startAnimation(animation1);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.aboutus:
                        menuItem.setChecked(true);
                        Intent intent=new Intent(MainActivity.this,AboutUs.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.single:
                        menuItem.setChecked(true);
                        Intent intent2=new Intent(MainActivity.this,SinglePlayer.class);
                        startActivity(intent2);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.multi:
                        menuItem.setChecked(true);
                        Intent intent4=new Intent(MainActivity.this,MultiPlayerSetting.class);
                        startActivity(intent4);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.rules:
                        menuItem.setChecked(true);
                        Intent intent3=new Intent(MainActivity.this,Rules.class);
                        startActivity(intent3);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.share:
                        menuItem.setChecked(true);
                        Intent myIntent = new Intent(Intent.ACTION_SEND);
                        myIntent.setType("text/plain");
                        String sharebody="Your Body Here";
                        String sharesub="Your Subject Here";
                        myIntent.putExtra(Intent.EXTRA_TEXT,sharebody);
                        myIntent.putExtra(Intent.EXTRA_SUBJECT,sharesub);
                        startActivity(Intent.createChooser(myIntent,"Share using"));
                        drawerLayout.closeDrawers();
                        break;

                }

                return false;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

        @Override
        public void onBackPressed(){
            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.app_name);
            builder.setIcon(R.drawable.icon);
            builder.setMessage("Do You Want to Exit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alert=builder.create();
            alert.show();
        }
}
