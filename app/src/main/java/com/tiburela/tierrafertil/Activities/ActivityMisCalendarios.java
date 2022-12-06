package com.tiburela.tierrafertil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tiburela.tierrafertil.R;

public class ActivityMisCalendarios extends AppCompatActivity {

    CardView cardViewCalendar;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_calendarios);

        cardViewCalendar=findViewById(R.id.cardViewCalendar);
        cardViewCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                startActivity(new Intent(ActivityMisCalendarios.this,ActivityCalendario.class ));
                
            }
        });
        
    }
}