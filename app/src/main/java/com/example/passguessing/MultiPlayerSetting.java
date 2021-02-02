package com.example.passguessing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class MultiPlayerSetting extends AppCompatActivity {
    String [] levelSelector={"Level One","Level Two","Level Three","Level Four"};
    ArrayAdapter<String> adapter;
    Spinner spinner;
    int guess[]={0,0,0,0};
    int playerOne[]={0,0,0,0};
    int playerTwo[]={0,0,0,0};
    CardView btnplay;
    int levelselceted=8;
    EditText ponepass,ptwopass;
    int parsing;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player_setting);
        toolbar=findViewById(R.id.toolBarHeader);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,levelSelector);
        spinner=(Spinner) findViewById(R.id.levelSelector);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  switch (position) {
                      case 0:
                          levelselceted = 1;
                          break;
                      case 1:
                          levelselceted = 2;
                          break;
                      case 2:
                          levelselceted = 3;
                          break;
                      case 3:
                          levelselceted = 4;
                          break;
                  }
              }

              @Override
              public void onNothingSelected(AdapterView<?> parent) {

              }
          });
        btnplay=(CardView)findViewById(R.id.multiPlay);
        ponepass=(EditText)findViewById(R.id.playeronepass);
        ptwopass=(EditText)findViewById(R.id.playertwopass);
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playeronepass=ponepass.getText().toString();
                String playertwopass=ptwopass.getText().toString();
                if (playeronepass.isEmpty() && playertwopass.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"please enter your password",Toast.LENGTH_LONG).show();
                }
                else if (playeronepass.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Player One enter your password",Toast.LENGTH_LONG).show();
                }
                else if (playertwopass.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Player Two enter your password",Toast.LENGTH_LONG).show();
                }
                else
                {
                    int ik=playeronepass.length();
                    int ij=playertwopass.length();
                    if (ik==4 && ij==4) {
                        int first = Integer.parseInt(playeronepass.substring(0, 1));
                        int second = Integer.parseInt(playeronepass.substring(1, 2));
                        int third = Integer.parseInt(playeronepass.substring(2, 3));
                        int fourth = Integer.parseInt(playeronepass.substring(3));
                        playerOne[0] = first;
                        playerOne[1] = second;
                        playerOne[2] = third;
                        playerOne[3] = fourth;
                        int first2 = Integer.parseInt(playertwopass.substring(0, 1));
                        int second2 = Integer.parseInt(playertwopass.substring(1, 2));
                        int third2 = Integer.parseInt(playertwopass.substring(2, 3));
                        int fourth2 = Integer.parseInt(playertwopass.substring(3));
                        playerTwo[0] = first2;
                        playerTwo[1] = second2;
                        playerTwo[2] = third2;
                        playerTwo[3] = fourth2;
                        if (levelselceted==1)
                        {
                            int error=cheuckError(1,1);
                            if (error!=1 && error!=2)
                            {
                                Intent intent=new Intent(MultiPlayerSetting.this,MultiPlayer.class);
                                intent.putExtra("playerone",playeronepass);
                                intent.putExtra("playertwo",playertwopass);
                                intent.putExtra("level",levelselceted+"");
                                startActivity(intent);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            }
                            else if (error==1)
                            {
                                Toast.makeText(getApplicationContext(),"Zero is not allowed at level one",Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Reputation is not allowed at level one",Toast.LENGTH_LONG).show();
                            }
                        }
                        else if (levelselceted==2)
                        {
                            int error=cheuckError(0,1);
                            if (error!=1 && error!=2)
                            {
                                Intent intent=new Intent(MultiPlayerSetting.this,MultiPlayer.class);
                                intent.putExtra("playerone",playeronepass);
                                intent.putExtra("playertwo",playertwopass);
                                intent.putExtra("level",levelselceted+"");
                                startActivity(intent);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            }
                            else if (error==1)
                            {
                                Toast.makeText(getApplicationContext(),"Zero is not allowed at level one",Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Reputation is not allowed at level one",Toast.LENGTH_LONG).show();
                            }
                        }
                        else if (levelselceted==3)
                        {
                            int error=cheuckError(1,0);
                            if (error!=1 && error!=2)
                            {
                                Intent intent=new Intent(MultiPlayerSetting.this,MultiPlayer.class);
                                intent.putExtra("playerone",playeronepass);
                                intent.putExtra("playertwo",playertwopass);
                                intent.putExtra("level",levelselceted+"");
                                startActivity(intent);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            }
                            else if (error==1)
                            {
                                Toast.makeText(getApplicationContext(),"Zero is not allowed at level one",Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Reputation is not allowed at level one",Toast.LENGTH_LONG).show();
                            }
                        }
                        else if (levelselceted==4)
                        {
                            int error=cheuckError(0,0);
                            if (error!=1 && error!=2)
                            {
                                Intent intent=new Intent(MultiPlayerSetting.this,MultiPlayer.class);
                                intent.putExtra("playerone",playeronepass);
                                intent.putExtra("playertwo",playertwopass);
                                intent.putExtra("level",levelselceted+"");
                                startActivity(intent);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            }
                            else if (error==1)
                            {
                                Toast.makeText(getApplicationContext(),"Zero is not allowed at level one",Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Reputation is not allowed at level one",Toast.LENGTH_LONG).show();
                            }
                        }

                    }
                    else if (ik!=4)
                    {
                        Toast.makeText(getApplicationContext(),"Player One : The password must be 4 digit",Toast.LENGTH_LONG).show();
                    }
                    else if (ij!=4)
                    {
                        Toast.makeText(getApplicationContext(),"Player Two : The password must be 4 digit",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    /* This function Cheucks error, errors differ in each level. So, it accepts two variables that can tell what level the player is
     *  =====the first one is int a = which is used to tell if zero can be included in the
     *  users input. if the value of a=0, this means users input can contain zero.
     *  else if a=1, this means zero is not allowed in the users input,if it does it will return error.
     *  =====the second one is int b= which is used to tell if reputation is allowed in the
     *  users input. if the value of b=0, this means the user can repeat numbers in his one trials.
     *  else if b=1, this means reputation is not allowed in the users input*/

    public int cheuckError(int a, int b)
    {
        int error=0;
        /* For This Case Both reputation and zero are not allowed, So it cheucks for both conditions */
        if (a==1 && b==1)
        {
            /* Checking for any kind of reputation*/
            for (int i = 0; i < 3; i++)
            {
                for (int j = i+1; j < 4; j++)
                {
                    if (playerOne[i]==playerOne[j] || playerTwo[i]==playerTwo[j])
                    {
                        error=1;
                    }
                }
            }
            /* Checking for any zero in the users input */
            for (int i = 0; i < 4; i++)
            {
                if (playerOne[i]==0 || playerTwo[i]==0)
                {
                    error=2;
                }
            }
        }
        /* For This Case Zero is allowed but reputation is not allowed, So it only checks for reputation*/
        else if (a==0&&b==1)
        {
            for (int i = 0; i < 3; i++)
            {
                for (int j = i+1; j < 4; j++)
                {
                    if (playerOne[i]==playerOne[j] || playerTwo[i]==playerTwo[j])
                    {
                        error=1;
                    }
                }
            }
        }
        /* For This Case Zero is not allowed but reputation is allowed, it only checks for Zero*/
        else if (a==1&&b==0)
        {
            for (int i = 0; i < 4; i++)
            {
                if (playerOne[i]==0 || playerTwo[i]==0)
                {
                    error=2;
                }
            }
        }
        /* For This Case Bothe are allowed, so the users input or guess will not have any techiniqual errors*/
        else if (a==1&&b==1)
        {
            error=0;
        }
        return error;
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
