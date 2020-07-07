package net.smallacademy.songslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class contain extends AppCompatActivity {

    TextView textView,url,cdate,author,update;
    String playname,urlname,Credate,updatee,login1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contain);

        textView=findViewById(R.id.textView);
        url=findViewById(R.id.created);
        cdate=findViewById(R.id.createdfinal);
        author=findViewById(R.id.Authorsname1);
        update=findViewById(R.id.update);


        Intent i= getIntent();

        playname=i.getStringExtra("name");
        urlname=i.getStringExtra("git_url");
        Credate=i.getStringExtra("Date");
        updatee=i.getStringExtra("uDate");
        login1=i.getStringExtra("login");

        textView.setText(playname);
        url.setText(urlname);
        cdate.setText(Credate);
        update.setText(updatee);
        author.setText(login1);
    }
}
