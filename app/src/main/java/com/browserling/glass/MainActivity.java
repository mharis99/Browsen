package com.browserling.glass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.browserling.glass.browsen.Browsen;
import com.browserling.glass.browserling.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    protected Button btnShowBrowsenDefault;
    protected Button btnShowBrowsenCustom;
    protected Button btnShowBrowsenCustomTop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowBrowsenDefault = (Button) findViewById(R.id.btnShowBrowsenDefault);
        btnShowBrowsenCustom = (Button) findViewById(R.id.btnShowBrowsenCustom);
        btnShowBrowsenCustomTop = (Button) findViewById(R.id.btnShowBrowsenCustomTop);

        btnShowBrowsenDefault.setOnClickListener(this);
        btnShowBrowsenCustom.setOnClickListener(this);
        btnShowBrowsenCustomTop.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnShowBrowsenDefault:

                Browsen.with(this)
                        .setUrl("https://www.google.com")
                        .show();

                break;




            case R.id.btnShowBrowsenCustom:

                Browsen.with(this)
                        .setUrl("https://www.google.com")
                        .setTitle("Google in Browsen")
                        .setTextColor(R.color.def_text_color)
                        .setTopBarColor(R.color.colorPrimary)
                        .showTopBar(true)
                        .show();

                break;

            case R.id.btnShowBrowsenCustomTop:

                Browsen.with(this)
                        .setUrl("https://www.google.com")
                        .setTitle("Google in Browsen")
                        .showTopBar(false)
                        .show();

                break;


        }

    }
}
