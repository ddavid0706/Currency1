package com.example.david.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ndt;
    private TextView tv_jp,tv_usd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        ndt = (EditText)findViewById(R.id.ed_NTD);
        tv_jp = (TextView)findViewById(R.id.tv_jp);
        tv_usd= (TextView)findViewById(R.id.tv_usd);
    }

    public void ndttousa(View view) {
        String str = ndt.getText().toString();

        if (str.length() != 0 ){
            double NDT = Double.parseDouble(str);
            float usd = 30.9f;
            float jp = 3.64f;
            double usd_result = (NDT/usd);
            double jp_result = NDT * jp;
            new AlertDialog.Builder(this)
                    .setTitle(R.string.result)
                    .setMessage(getString(R.string.usd_is) + (float)usd_result)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ndt.setText("");
                        }
                    })
                    .show();

                tv_usd.setText((float)usd_result + "$");
                tv_jp.setText((float)jp_result + "¥");


        }else{
            new AlertDialog.Builder(this)
                    .setTitle(R.string.problem)
                    .setMessage(R.string.please_enter_ntd)
                    .setPositiveButton(R.string.ok, null )
                    .show();
            tv_usd.setText("無");
            tv_jp.setText("無");
        }

    }
}
