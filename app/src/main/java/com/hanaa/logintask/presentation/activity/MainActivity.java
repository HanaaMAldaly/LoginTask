package com.hanaa.logintask.presentation.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hanaa.logintask.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String NAME_KEY="name";
    @BindView(R.id.welcome_message)
    TextView textView;
    public static Intent getStartIntent(Context context,String name){
        Intent intent= new Intent(context,MainActivity.class);
        intent.putExtra(NAME_KEY,name);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String name=getIntent().getStringExtra(NAME_KEY);
        if(name!=null)
        textView.append(name);
    }
}
