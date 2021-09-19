package com.example.a6dialogandraiting;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private RatingBar ratingBar;
   private Button btn;
   private Button alert;
   private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        addListener();

    }
    public void addListener(){
        ratingBar = findViewById( R.id.ratingBar );
        btn =  findViewById( R.id.btn1 );
        alert = findViewById( R.id.btnAlert );
        textView = findViewById( R.id.textView );
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText( "Done" );
                btn.setBackgroundColor( Color.RED );
                Toast.makeText( MainActivity.this, "Show", Toast.LENGTH_SHORT ).show();
            }
        } );

        ratingBar.setOnRatingBarChangeListener( new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView.setText( "Meaning :" + String.valueOf( rating  ));
            }
        } );
        alert.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder( MainActivity.this );
                builder.setMessage( "You want a close the App" )
                        .setCancelable( false )
                        .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        } )
                        .setNegativeButton( "No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        } );
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle( "Close the App" );
                alertDialog.show();
            }
        } );

    }




}
















