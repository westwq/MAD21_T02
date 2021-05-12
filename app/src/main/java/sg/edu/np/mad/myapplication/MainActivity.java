package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txt = findViewById(R.id.input);
        txt.setText("hello t02");
        Log.d("debug", "create");

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setText("clicked");
            }
        });

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, MainActivity2.class);
                EditText txt = findViewById(R.id.input);
                String userInput = txt.getText().toString();
                in.putExtra("userInput", userInput);
                startActivity(in);
            }
        });

        //generating data
        ArrayList<User> data = new ArrayList<User>();
        for(int i=0; i<20; i++)
        {
            User u = new User();
            u.setAge(i+1);
            u.setName("Name " + i);

            data.add(u);
        }

        RecyclerView rv = findViewById(R.id.rv);
        UsersAdapter adapter = new UsersAdapter(this, data);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        //lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

    }

    public void btn3OnClick(View v){
        Button btn3 = (Button)v;
        btn3.setText("clicked3");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("debug", "start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("debug", "stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("debug", "destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("debug", "pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("debug", "resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("debug", "restart");
    }
}













