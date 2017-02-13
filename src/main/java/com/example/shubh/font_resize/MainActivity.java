package com.example.shubh.font_resize;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton one, two, three, four, animate, theme;
    private TextView heading, body;
    private Animation slideUp;
    private Animation rotate1, rotate2;
    private Animation slideLeft1, slideLeft2, slideLeft3, slideLeft4, slideLeft5;
    private Animation slideRight1, slideRight2, slideRight3, slideRight4, slideRight5;
    MainActivity main;
    Boolean flag = true, flag1 = true;
    SeekBar seekBar1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hey there!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        one = (ImageButton)findViewById(R.id.one);
        one.setVisibility(View.GONE);
        two = (ImageButton)findViewById(R.id.two);
        two.setVisibility(View.GONE);
        three = (ImageButton)findViewById(R.id.three);
        three.setVisibility(View.GONE);
        four = (ImageButton)findViewById(R.id.four);
        four.setVisibility(View.GONE);
        animate = (ImageButton)findViewById(R.id.animate);
        animate.setVisibility(View.VISIBLE);
        theme = (ImageButton)findViewById(R.id.theme);
        theme.setVisibility(View.GONE);

        heading = (TextView)findViewById(R.id.heading);
        body = (TextView)findViewById(R.id.body);

        slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);

        rotate1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_1);
        rotate2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_2);

        slideLeft1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left_1);
        slideLeft2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left_2);
        slideLeft3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left_3);
        slideLeft4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left_4);
        slideLeft5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left_5);

        slideRight1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right_1);
        slideRight2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right_2);
        slideRight3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right_3);
        slideRight4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right_4);
        slideRight5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right_5);

        slideButtonsUp();

        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((one.getVisibility() == View.VISIBLE) || (two.getVisibility() == View.VISIBLE) ||
                        (three.getVisibility() == View.VISIBLE) || (four.getVisibility() == View.VISIBLE) ||
                        (theme.getVisibility() == View.VISIBLE))
                {
                    //animate.startAnimation(rotate2);
                    slideRight();
                }
                else
                {
                    //animate.startAnimation(rotate1);
                    slideLeft();
                }
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heading.setTextSize(30);
                body.setTextSize(15);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heading.setTextSize(35);
                body.setTextSize(20);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heading.setTextSize(40);
                body.setTextSize(25);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heading.setTextSize(45);
                body.setTextSize(30);
            }
        });

        theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == true)
                {
                    one.setImageResource(R.drawable.night_text_one);
                    two.setImageResource(R.drawable.night_text_two);
                    three.setImageResource(R.drawable.night_text_three);
                    four.setImageResource(R.drawable.night_text_four);
                    theme.setImageResource(R.drawable.daymode);
                    setTheme(R.style.WhiteTheme);
                    flag = false;
                }
                else
                {
                    one.setImageResource(R.drawable.text_one);
                    two.setImageResource(R.drawable.text_two);
                    three.setImageResource(R.drawable.text_three);
                    four.setImageResource(R.drawable.text_four);
                    theme.setImageResource(R.drawable.darkmode);
                    setTheme(R.style.BlackTheme);
                    flag = true;
                }
            }
        });

        imageView = (ImageView)findViewById(R.id.resize);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(flag1 == true)
                {
                    seekBar1.setVisibility(View.VISIBLE);
                    flag1 = false;
                }
                else
                {
                    flag1 = true;
                    seekBar1.setVisibility(View.GONE);
                }
            }
        });

        seekBar1=(SeekBar)findViewById(R.id.seekBar1);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if(progress>0&&progress<=1)
                {
                    heading.setTextSize(20);
                    body.setTextSize(10);
                }
                if(progress>1&&progress<=2)
                {
                    heading.setTextSize(21);
                    body.setTextSize(11);
                }
                if(progress>2&&progress<=3)
                {
                    heading.setTextSize(22);
                    body.setTextSize(12);
                }
                if(progress>3&&progress<=4)
                {
                    heading.setTextSize(23);
                    body.setTextSize(13);
                }
                if(progress>4&&progress<=5)
                {
                    heading.setTextSize(24);
                    body.setTextSize(14);
                }
                if(progress>5&&progress<=6)
                {
                    heading.setTextSize(25);
                    body.setTextSize(15);
                }
                if(progress>6&&progress<=7)
                {
                    heading.setTextSize(26);
                    body.setTextSize(16);
                }
                if(progress>7&&progress<=8)
                {
                    heading.setTextSize(27);
                    body.setTextSize(17);
                }
                if(progress>8&&progress<=9)
                {
                    heading.setTextSize(28);
                    body.setTextSize(18);
                }
                if(progress>9&&progress<=10)
                {
                    heading.setTextSize(29);
                    body.setTextSize(19);
                }
                if(progress>10&&progress<=11)
                {
                    heading.setTextSize(30);
                    body.setTextSize(20);
                }
                if(progress>11&&progress<=12)
                {
                    heading.setTextSize(31);
                    body.setTextSize(21);
                }
                if(progress>12&&progress<=13)
                {
                    heading.setTextSize(32);
                    body.setTextSize(22);
                }
                if(progress>13&&progress<=14)
                {
                    heading.setTextSize(33);
                    body.setTextSize(23);
                }
                if(progress>14&&progress<=15)
                {
                    heading.setTextSize(34);
                    body.setTextSize(24);
                }
                if(progress>15&&progress<=16)
                {
                    heading.setTextSize(35);
                    body.setTextSize(25);
                }
                if(progress>16&&progress<=17)
                {
                    heading.setTextSize(36);
                    body.setTextSize(26);
                }
                if(progress>17&&progress<=18)
                {
                    heading.setTextSize(37);
                    body.setTextSize(27);
                }
                if(progress>18&&progress<=19)
                {
                    heading.setTextSize(38);
                    body.setTextSize(28);
                }
                if(progress>19&&progress<=20)
                {
                    heading.setTextSize(39);
                    body.setTextSize(29);
                }
                if(progress>20&&progress<=21)
                {
                    heading.setTextSize(40);
                    body.setTextSize(30);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void slideButtonsUp() {

        if(animate != null) {
            animate.clearAnimation();
            animate.startAnimation(slideUp);

            animate.setVisibility(View.VISIBLE);
        }
    }

    private void slideLeft() {

        one.clearAnimation();
        one.startAnimation(slideLeft1);
        two.clearAnimation();
        two.startAnimation(slideLeft2);
        three.clearAnimation();
        three.startAnimation(slideLeft3);
        four.clearAnimation();
        four.startAnimation(slideLeft4);
        theme.clearAnimation();
        theme.startAnimation(slideLeft5);

        one.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        four.setVisibility(View.VISIBLE);
        theme.setVisibility(View.VISIBLE);
    }

    private void slideRight() {

        one.clearAnimation();
        one.startAnimation(slideRight1);
        two.clearAnimation();
        two.startAnimation(slideRight2);
        three.clearAnimation();
        three.startAnimation(slideRight3);
        four.clearAnimation();
        four.startAnimation(slideRight4);
        theme.clearAnimation();
        theme.startAnimation(slideRight5);

        one.setVisibility(View.INVISIBLE);
        two.setVisibility(View.INVISIBLE);
        three.setVisibility(View.INVISIBLE);
        four.setVisibility(View.INVISIBLE);
        theme.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        if(progress>0&&progress<=25)
        {
            heading.setTextSize(35);
            body.setTextSize(20);
        }
        if(progress>26&&progress<=50)
        {
            heading.setTextSize(35);
            body.setTextSize(20);
        }
        if(progress>51&&progress<=75)
        {
            heading.setTextSize(40);
            body.setTextSize(25);
        }
        if(progress>76&&progress<=100)
        {
            heading.setTextSize(45);
            body.setTextSize(30);
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar)
    {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar)
    {
        seekBar1.setSecondaryProgress(seekBar.getProgress());
    }*/
}

