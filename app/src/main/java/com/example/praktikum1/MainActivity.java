package com.example.praktikum1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_width;
    private EditText edt_height;
	private EditText edt_length;
	private Button btn_calculate;
	private TextView tv_result;
	private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_width = findViewById(R.id.edt_width);
        edt_height = findViewById(R.id.edt_height);
        edt_length = findViewById(R.id.edt_length);
        btn_calculate = findViewById(R.id.btn_calculate);
        tv_result = findViewById(R.id.tv_result);

        btn_calculate.setOnClickListener(this);
        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tv_result.setText(result);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String inputLength = edt_length.getText().toString().trim();
            String inputWidth = edt_width.getText().toString().trim();
            String inputHeight = edt_height.getText().toString().trim();

            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                edt_length.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                edt_width.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edt_height.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyFields) {

                Double volume = Double.parseDouble(inputLength) * Double.parseDouble(inputWidth) * Double.parseDouble(inputHeight);
                tv_result.setText(String.valueOf(volume));
            }
        }
    }
}
