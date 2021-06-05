package ru.mirea.kartamysheva.multiactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MultiActivity extends AppCompatActivity {

    private String TAG = MultiActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
    }

    public void onClickNewActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("key", "MIREA - Kartamysheva Taisia Nikolaevna");
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "OnStart()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "OnRestoreInstanceState()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "OnRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "OnResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "OnPause()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "OnSaveInstanceState()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "OnStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "OnDestroy()");
    }
    
}