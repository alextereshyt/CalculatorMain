package com.example.calculatormain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private StringBuilder currentNumber;
    private String operator;
    private double operand1;
    private double operand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
        currentNumber = new StringBuilder();
    }
    public void onNumberClick(View view) {
        Button button = (Button) view;
        String number = button.getText().toString();
        currentNumber.append(number);
        textViewResult.setText(currentNumber.toString());
    }
    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        operand1 = Double.parseDouble(currentNumber.toString());
        currentNumber.setLength(0);
    }
    public void onEqualsClick(View view) {
        operand2 = Double.parseDouble(currentNumber.toString());
        double result = 0;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
        }

        textViewResult.setText(String.valueOf(result));
        currentNumber.setLength(0);
        currentNumber.append(result);
    }

    public void onClearClick(View view) {
        currentNumber.setLength(0);
        textViewResult.setText("0");
    }

}