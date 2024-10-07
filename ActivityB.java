package com.example.androidactivitylifecycle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class ActivityB extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    public void onFinishActivityB(View view)
    {
        // Set result as OK and finish Activity B
        setResult(RESULT_OK);
        finish();
    }
}
