package com.example.nickolas.navigatetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private EditTextCanClean myWidget;
    private Button display;
    private Button next;
    private Button previous;
    private Button Ok;

    private int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWidget = (EditTextCanClean)findViewById(R.id.et_account);


        display = (Button)findViewById(R.id.displayWidget);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myWidget.displayWidget();
            }
        });

        next = (Button)findViewById(R.id.nextButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myWidget.next();
            }
        });

        previous = (Button)findViewById(R.id.PreviousButton);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myWidget.previous();
            }
        });

        Ok =(Button)findViewById(R.id.OKButton);
        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myWidget.ok();
            }
        });
    }
}
