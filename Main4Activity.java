package com.example.lab31;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
    public void run(View v) {
        long time, start, end;
        int n, p, q, k;
        EditText nInput;
        nInput = (EditText) findViewById(R.id.nubmerN);
        start = System.nanoTime();
        if (nInput.getText().toString().equals("")) {
            hideKeyboard();
            showToast("Type in an odd number, please");
        } else {
            n = Integer.parseInt(nInput.getText().toString());
            k = (int) Math.sqrt(n);

            do {
                p = (int) (k + Math.sqrt(k * k - n));
                q = (int) (k - Math.sqrt(k * k - n));
                k++;
            }
            while (p * q != n && p < n);

            if (p * q == n) {
                hideKeyboard();
                showToast("Result: p = " + p + ", q = " + q + "\n\n" + p + " * " + q + " = " + n);
            } else {
                hideKeyboard();
                showToast("Try oce again with another number");
            }
        }
        end = System.nanoTime();
        time = end - start;
        showToast("Time = " + time);
    }
    private void showToast(String text) {
        Toast.makeText(Main4Activity.this, text, Toast.LENGTH_SHORT).show();
    }
    public void hideKeyboard() {
        try {
            InputMethodManager inputManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            assert inputManager != null;
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
