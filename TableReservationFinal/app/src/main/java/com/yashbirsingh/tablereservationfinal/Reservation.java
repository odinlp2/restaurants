package com.yashbirsingh.tablereservationfinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Reservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
    }

    public void toastMsg(View view){
        Toast.makeText(getApplicationContext(), "Shit I should have finished this last night", Toast.LENGTH_LONG).show();
    }
}
