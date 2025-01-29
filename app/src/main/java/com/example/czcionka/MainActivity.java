package com.example.czcionka;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        java.GreetingsChooser greetingsChooser = new java.GreetingsChooser();

        TextView greetingView = findViewById(R.id.greetingTextView);
        Button executeButton = findViewById(R.id.executeButton);
        executeButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        greetingView.setText(greetingsChooser.NextGreeting());
                    }
                }
        );

        EditText fontSizeView = findViewById(R.id.fontSizeTextView);
        SeekBar fontSizeSeekBar = findViewById(R.id.fontSizeSeekBar);
        fontSizeView.setText(Integer.toString(fontSizeSeekBar.getProgress()));//initial setting
        fontSizeSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        fontSizeView.setText(Integer.toString(i));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        //xxx
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        //xxx
                    }
                }
        );

    }
}