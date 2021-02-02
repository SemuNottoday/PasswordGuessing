package com.example.passguessing;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MultiPlayer extends AppCompatActivity {

    TextView playertwouserguess,playertwoTcorrect,playertwoTposition,playertwotrying,playertwoguessDisplay,playertwotryholder;
    TextView playeroneuserguess,playeroneTcorrect,playeroneTposition,playeronetrying,playeroneguessDisplay,playeronetryholder;
    RelativeLayout playeroneLayout,playertwoLayout;
    int playeronePassword[]={0,0,0,0};
    int playertwoPassword[]={0,0,0,0};
    int playeroneTry[]={0,0,0,0};
    int playertwoTry[]={0,0,0,0};
    Button playerOne,playerTwo;
    int waitstate=0,playeronetryamount=0,playertwotryamount=0;
    String correct1="",position1="";
    private Toolbar toolbar;
    LinearLayout blinkCard,blinkcard2;
    Animation blink,sclaleup,scaledown;
    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            if (playeroneLayout.getVisibility()==View.VISIBLE)
            {
                playeroneLayout.setVisibility(View.INVISIBLE);
                playertwoLayout.setVisibility(View.VISIBLE);
            }
            else
            {
                playertwoLayout.setVisibility(View.INVISIBLE);
                playeroneLayout.setVisibility(View.VISIBLE);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player);
        toolbar=findViewById(R.id.toolBarHeader);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final String playerOnePass=getIntent().getStringExtra("playerone");
        final String playerTwoPass=getIntent().getStringExtra("playertwo");
        String levelTeller=getIntent().getStringExtra("level");
        final int level=Integer.parseInt(levelTeller);

            int first = Integer.parseInt(playerOnePass.substring(0, 1));
            int second = Integer.parseInt(playerOnePass.substring(1, 2));
            int third = Integer.parseInt(playerOnePass.substring(2, 3));
            int fourth = Integer.parseInt(playerOnePass.substring(3));
            playeronePassword[0] = first;
            playeronePassword[1] = second;
            playeronePassword[2] = third;
            playeronePassword[3] = fourth;
            int first2 = Integer.parseInt(playerTwoPass.substring(0, 1));
            int second2 = Integer.parseInt(playerTwoPass.substring(1, 2));
            int third2 = Integer.parseInt(playerTwoPass.substring(2, 3));
            int fourth2 = Integer.parseInt(playerTwoPass.substring(3));
            playertwoPassword[0] = first2;
            playertwoPassword[1] = second2;
            playertwoPassword[2] = third2;
            playertwoPassword[3] = fourth2;
        playeroneLayout=(RelativeLayout)findViewById(R.id.playerOneLayout);
        playertwoLayout=(RelativeLayout)findViewById(R.id.playerTwoLayout);
        playerOne=(Button)findViewById(R.id.playeroneSend);
        playerTwo=(Button)findViewById(R.id.playertwoSend);
        blinkCard=(LinearLayout)findViewById(R.id.blinkingCardView);
        blinkcard2=(LinearLayout)findViewById(R.id.blinkingCardView2);
        blink= AnimationUtils.loadAnimation(MultiPlayer.this,R.anim.blink_anim);
        scaledown= AnimationUtils.loadAnimation(MultiPlayer.this,R.anim.zoomin);
        sclaleup= AnimationUtils.loadAnimation(MultiPlayer.this,R.anim.zoomout);

        blinkCard.startAnimation(blink);
        blinkcard2.startAnimation(blink);
        playerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playeroneuserguess = findViewById(R.id.playeroneinput);
                playeroneguessDisplay = findViewById(R.id.playeroneuserGuess);
                playeroneTcorrect = findViewById(R.id.playeronecorrect);
                playeroneTposition = findViewById(R.id.playeroneposition);
                playeronetryholder = findViewById(R.id.playeronetryholder);
                String playerOneGuess=playeroneuserguess.getText().toString();

                /*   changing the users input into integer array       */
                int ik=playerOneGuess.length();
                if (ik==4)
                {
                    int first=Integer.parseInt(playerOneGuess.substring(0,1));
                    int second=Integer.parseInt(playerOneGuess.substring(1,2));
                    int third=Integer.parseInt(playerOneGuess.substring(2,3));
                    int fourth=Integer.parseInt(playerOneGuess.substring(3));
                    playeroneTry[0]=first;
                    playeroneTry[1]=second;
                    playeroneTry[2]=third;
                    playeroneTry[3]=fourth;
                    int error=0;
                    if (level==1)
                    {
                        error=cheuckError(1,1,playeroneTry);
                    }
                    else if (level==2){
                        error=cheuckError(0,1,playeroneTry);
                    }
                    else if (level==3){
                        error=cheuckError(1,0,playeroneTry);
                    }
                    else if (level==4){
                        error=cheuckError(0,0,playeroneTry);
                    }
                    if (error!=1 && error!=2)
                    {
                        /*playeroneLayout.setVisibility(View.INVISIBLE);
                        playertwoLayout.setVisibility(View.VISIBLE);*/
                        handler.postDelayed(runnable,2000);
                        int corre = 0;
                        int posit = 0;
                        for (int i = 0; i < 4; i++) {
                            int corrCount=0;
                            /*  This for loop checks For Correct Guess, by comparing it with the Password generated*/
                            for (int j = 0; j < 4; j++) {
                                if (playeroneTry[j] == playertwoPassword[i] && corrCount==0) {
                                    corre += 1;
                                    corrCount=1;
                                }
                            }
                            /* This if statement Checks if the correct ones are in their exact position or not*/
                            if (playeroneTry[i] == playertwoPassword[i]) {
                                posit += 1;
                            }
                        }
                        /*  Displaying the variables into the users interface by appending them to the textView                  */
                        String forinterface = "";
                        for (int i = 0; i < 4; i++) {
                            forinterface = forinterface + playeroneTry[i];
                        }
                        playeroneguessDisplay.append(forinterface + "\n");
                        correct1 = "   " + corre;
                        position1 = "   " + posit;
                        playeroneTposition.append(position1 + "\n");
                        playeroneTcorrect.append(correct1 + "\n");
                        playeroneuserguess.setText("");
                        /* Until the position is not 4 (if the player is not cracking the password ), it will decrease the amount of trial by one */
                        if (posit != 4)
                        {
                            playeronetryamount=playeronetryamount+1;
                            playeronetryholder.setText("Try: " + playeronetryamount);
                            blinkCard.startAnimation(sclaleup);
                            blinkcard2.startAnimation(scaledown);

                        }
                        /*  But if the position is 4, This means the player cracked the password, so it will take him to Winner page by transfering some
                         * data. like the password, tryamount left, orginal tryamount*/
                        else
                        {
                            playeronetryamount=playeronetryamount+1;
                            if (playeronetryamount>playertwotryamount)
                            {
                                Toast.makeText(getApplicationContext(),"Wait untill player two try's its chance",Toast.LENGTH_LONG).show();
                                waitstate=3;
                            }
                            else
                            {
                                Intent intent1=new Intent(MultiPlayer.this,MultiWinner.class);
                                intent1.putExtra("playeronetryamount",playeronetryamount+"");
                                intent1.putExtra("playertwotryamount",playertwotryamount+"");
                                intent1.putExtra("playertwopassword",playerTwoPass);
                                intent1.putExtra("playeronepassword",playerOnePass);
                                intent1.putExtra("winner",1+"");
                                startActivity(intent1);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            }
                        }
                    }
                    else if (error==1)
                    {
                        Toast.makeText(getApplicationContext(),"Reputation is not allowed",Toast.LENGTH_LONG).show();
                    }
                    else if (error==2)
                    {
                        Toast.makeText(getApplicationContext(),"Zero is not allowed",Toast.LENGTH_LONG).show();
                    }

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"the password must be 4 digit",Toast.LENGTH_LONG).show();
                }
            }
        });
        playerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playertwouserguess = findViewById(R.id.playertwouserinput);
                playertwoguessDisplay=findViewById(R.id.playertwouserGuess);
                playertwoTcorrect = findViewById(R.id.playertwocorrect);
                playertwoTposition = findViewById(R.id.playertwoposition);
                playertwotryholder=findViewById(R.id.playertwotryholder);
                String playerTwoGuess=playertwouserguess.getText().toString();
                /*   changing the users input into integer array       */
                int ik=playerTwoGuess.length();
                if (ik==4)
                {
                    int first=Integer.parseInt(playerTwoGuess.substring(0,1));
                    int second=Integer.parseInt(playerTwoGuess.substring(1,2));
                    int third=Integer.parseInt(playerTwoGuess.substring(2,3));
                    int fourth=Integer.parseInt(playerTwoGuess.substring(3));
                    playertwoTry[0]=first;
                    playertwoTry[1]=second;
                    playertwoTry[2]=third;
                    playertwoTry[3]=fourth;
                    int error=0;
                    if (level==1)
                    {
                        error=cheuckError(1,1,playertwoTry);
                    }
                    else if (level==2){
                        error=cheuckError(0,1,playertwoTry);
                    }
                    else if (level==3){
                        error=cheuckError(1,0,playertwoTry);
                    }
                    else if (level==4){
                        error=cheuckError(0,0,playertwoTry);
                    }
                    if (error!=1 && error!=2)
                    {
                        /*playertwoLayout.setVisibility(View.INVISIBLE);
                        playeroneLayout.setVisibility(View.VISIBLE);*/
                        handler.postDelayed(runnable,2000);
                        int corre = 0;
                        int posit = 0;
                        for (int i = 0; i < 4; i++) {
                            int corrCount=0;
                            /*  This for loop checks For Correct Guess, by comparing it with the Password generated*/
                            for (int j = 0; j < 4; j++) {
                                if (playertwoTry[j] == playeronePassword[i] && corrCount==0) {
                                    corre += 1;
                                    corrCount=1;
                                }
                            }
                            /* This if statement Checks if the correct ones are in their exact position or not*/
                            if (playertwoTry[i] == playeronePassword[i]) {
                                posit += 1;
                            }
                        }
                        /*  Displaying the variables into the users interface by appending them to the textView                  */
                        String forinterface = "";
                        for (int i = 0; i < 4; i++) {
                            forinterface = forinterface + playertwoTry[i];
                        }
                        playertwoguessDisplay.append(forinterface + "\n");
                        correct1 = "   " + corre;
                        position1 = "   " + posit;
                        playertwoTposition.append(position1 + "\n");
                        playertwoTcorrect.append(correct1 + "\n");
                        playertwouserguess.setText("");
                        if (posit != 4 )
                        {
                            if (waitstate==3)
                            {
                                playertwotryamount=playertwotryamount+1;
                                Intent intent2=new Intent(MultiPlayer.this,MultiWinner.class);
                                intent2.putExtra("playeronetryamount",playeronetryamount+"");
                                intent2.putExtra("playertwotryamount",playertwotryamount+"");
                                intent2.putExtra("playertwopassword",playerTwoPass);
                                intent2.putExtra("playeronepassword",playerOnePass);
                                intent2.putExtra("winner",1+"");
                                startActivity(intent2);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            }
                            else
                            {
                                playertwotryamount=playertwotryamount+1;
                                playertwotryholder.setText("Try: " + playertwotryamount);
                                blinkcard2.startAnimation(sclaleup);
                                blinkCard.startAnimation(scaledown);
                            }
                        }
                        /*  But if the position is 4, This means the player cracked the password, so it will take him to Winner page by transfering some
                         * data. like the password, tryamount left, orginal tryamount*/
                        else
                        {
                            int wini=2;
                            playertwotryamount=playertwotryamount+1;
                            if (waitstate==3)
                            {
                                wini=3;
                            }
                                Intent intent2=new Intent(MultiPlayer.this,MultiWinner.class);
                                intent2.putExtra("playeronetryamount",playeronetryamount+"");
                                intent2.putExtra("playertwotryamount",playertwotryamount+"");
                                intent2.putExtra("playertwopassword",playerTwoPass);
                                intent2.putExtra("playeronepassword",playerOnePass);
                                intent2.putExtra("winner",wini+"");
                                startActivity(intent2);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }
                    }
                    else if (error==1)
                    {
                        Toast.makeText(getApplicationContext(),"Reputation is not allowed",Toast.LENGTH_LONG).show();
                    }
                    else if (error==2)
                    {
                        Toast.makeText(getApplicationContext(),"Zero is not allowed",Toast.LENGTH_LONG).show();
                    }

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"the password must be 4 digit",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
    public int cheuckError(int a, int b,int[] pass)
    {
        int error=0;
        /* For This Case Both reputation and zero are not allowed, So it cheucks for both conditions */
        if (a==1&&b==1)
        {
            /* Checking for any kind of reputation*/
            for (int i = 0; i < 3; i++)
            {
                for (int j = i+1; j < 4; j++)
                {
                    if (pass[i]==pass[j])
                    {
                        error=1;
                    }
                }
            }
            /* Checking for any zero in the users input */
            for (int i = 0; i < 4; i++)
            {
                if (pass[i]==0)
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
                    if (pass[i]==pass[j])
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
                if (pass[i]==0)
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
