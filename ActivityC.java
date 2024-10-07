package com.example.androidactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class ActivityC extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
    }

    public void onFinishActivityC(View view)
    {
        // Set result as OK and finish Activity C
        setResult(RESULT_OK);
        finish();
    }
}
