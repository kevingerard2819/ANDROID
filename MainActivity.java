package com.example.androidactivitylifecycle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        // Update the counter when MainActivity restarts
        TextView threadCounterText = findViewById(R.id.thread_counter_txt);
        threadCounterText.setText("ThreadCounter: " + counter);
    }

    // Start Activity B
    public void onStartActivityB(View view) {
        Intent activityBIntent = new Intent(MainActivity.this, ActivityB.class);
        startActivityForResult(activityBIntent, 1); // Request code 1 for Activity B
    }

    // Start Activity C
    public void onStartActivityC(View view) {
        Intent activityCIntent = new Intent(MainActivity.this, ActivityC.class);
        startActivityForResult(activityCIntent, 2); // Request code 2 for Activity C
    }

    // Trigger a dialog
    public void onTriggerDialog(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Dialog")
                .setMessage("Simple Dialog Box")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {}
                })
                .show();
    }

    // Close the app
    public void onCloseApp(View view) {
        finish();
        System.exit(0);
    }

    // Handle results from Activity B and C
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                // Increment counter by 5 for Activity B
                counter += 5;
            } else if (requestCode == 2) {
                // Increment counter by 10 for Activity C
                counter += 10;
            }

            TextView threadCounterText = findViewById(R.id.thread_counter_txt);
            threadCounterText.setText("ThreadCounter: " + counter);
        }
    }
}
