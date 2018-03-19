package jp.techacademy.youichi.satou.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText;
    EditText nEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText = (EditText) findViewById(R.id.editText1);
        nEditText = (EditText) findViewById(R.id.editText2);

    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.button1) {
            int value3 = 1;
            showOpenSecondActivity(value3);
        } else if (v.getId() == R.id.button2) {
            int value3 = 2;
            showOpenSecondActivity(value3);
        } else if (v.getId() == R.id.button3) {
            int value3 = 3;
            showOpenSecondActivity(value3);
        } else if (v.getId() == R.id.button4) {
            int value3 = 4;
            showOpenSecondActivity(value3);
        }
    }

    private void showAlertDialog(String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("エラーを検出しました");
        alertDialogBuilder.setMessage(message);

        alertDialogBuilder.setPositiveButton("閉じる",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        dialog.dismiss();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    public void showOpenSecondActivity(int value3) {
        try {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("VALUE1", Double.parseDouble(mEditText.getText().toString()));
            intent.putExtra("VALUE2", Double.parseDouble(nEditText.getText().toString()));
            intent.putExtra("VALUE3", value3);
            if ((value3 == 4) && (Double.parseDouble(nEditText.getText().toString()) == 0)) {
                String message = "数値を0で割ることはできません";
                showAlertDialog(message);
            } else {
                startActivity(intent);
            }
        } catch (NumberFormatException e) {
            String message = "計算できない文字が含まれています";
            showAlertDialog(message);
        }
    }
}
