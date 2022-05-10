package com.example.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TextView textViewname;
    EditText editText;
    Button button;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewname = findViewById(R.id.name);
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.edit_button);

        preferences = getSharedPreferences("preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("namn","");
        editor.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
        String name = preferences.getString("name","inget namn hittades");
        textViewname.setText(name);

    }
}
