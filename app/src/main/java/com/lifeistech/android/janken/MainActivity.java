package com.lifeistech.android.janken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView cpu, player;
    TextView result,score,hp;
    Random r = new Random();
    int win=0;
    int life=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cpu = (ImageView) findViewById(R.id.cpu);
        player = (ImageView) findViewById(R.id.player);
        result=(TextView)findViewById(R.id.result);
        score=(TextView)findViewById(R.id.score);
        hp=(TextView)findViewById(R.id.hp);



    }
    public void goo(View v){
        player.setImageResource(R.drawable.goo);

        int random=r.nextInt(3);
        if(random==0){
            cpu.setImageResource(R.drawable.goo);
            result.setText("引き分けです");
        }else if(random==1){
            cpu.setImageResource(R.drawable.choki);
            result.setText("あなたの勝ちです");
            win++;
        }else{
            cpu.setImageResource(R.drawable.pa);
            result.setText("あなたの負けです");
            life--;
        }
        point();
    }
    public void choki(View v){
        player.setImageResource(R.drawable.choki);

        int random=r.nextInt(3);
        if(random==0){
            cpu.setImageResource(R.drawable.choki);
            result.setText("引き分けです");
        }else if(random==1){
            cpu.setImageResource(R.drawable.pa);
            result.setText("あなたの勝ちです");
            win++;
        }else{
            cpu.setImageResource(R.drawable.goo);
            result.setText("あなたの負けです");
            life--;
        }
        point();
    }
    public void pa(View v){
        player.setImageResource(R.drawable.pa);

        int random=r.nextInt(3);
        if(random==0){
            cpu.setImageResource(R.drawable.pa);
            result.setText("引き分けです");
        }else if(random==1){
            cpu.setImageResource(R.drawable.goo);
            result.setText("あなたの勝ちです");
            win++;
        }else{
            cpu.setImageResource(R.drawable.choki);
            result.setText("あなたの負けです");
            life--;
        }
        point();
    }
    public void point(){
        score.setText("score : "+win);
        if(life==0){
            Toast.makeText(this,"Game over\nScore:"+win,Toast.LENGTH_LONG).show();
            life=5;
        }
        hp.setText("HP : "+life);
    }
}
