package com.example.david.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ndt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        ndt = (EditText)findViewById(R.id.ed_NTD);
    }

    public void ndttousa(View view) {
        String str = ndt.getText().toString();

        if (str.length() != 0 ){
            double NDT = Double.parseDouble(str);
            float usd = 30.9f;
            double result = (NDT/usd);
            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("USD is " + (float)result)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ndt.setText("");
                        }
                    })
                    .show();

        }else{
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter you NTD amount")
                    .setPositiveButton("OK", null )
                    .show();
        }

    }
}
