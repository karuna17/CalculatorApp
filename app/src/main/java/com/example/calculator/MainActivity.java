package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.databinding.ActivityMainBinding;
import com.example.calculatorlibrary.Calculator;

public class MainActivity extends AppCompatActivity {
    private double num1;
    private double num2;
    private double result;
    private String answer;
    private String operation, primary;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        clear();
        pressBtn_0();
        pressBtn_1();
        pressBtn_2();
        pressBtn_3();
        pressBtn_4();
        pressBtn_5();
        pressBtn_6();
        pressBtn_7();
        pressBtn_8();
        pressBtn_9();
        pressBtn_dot();
        pressBtn_Backspace();
        addBtn();
        subBtn();
        multBtn();
        divBtn();
        equalBtn();
    }

    private void clear() {
        binding.clearButton.setOnClickListener(v -> {
            binding.text1.setText(null);
            binding.text2.setText(null);
        });
    }

    private void pressBtn_0() {
        binding.btn0.setOnClickListener(v -> {
            String txt = binding.text2.getText().toString() + binding.btn0.getText().toString();
            binding.text2.setText(txt);
        });
    }

    private void pressBtn_1() {
        binding.btn1.setOnClickListener(v -> {
            String txt = binding.text2.getText().toString() + binding.btn1.getText().toString();
            binding.text2.setText(txt);
        });
    }

    private void pressBtn_2() {
        binding.btn2.setOnClickListener(v -> {
            String txt = binding.text2.getText().toString() + binding.btn2.getText().toString();
            binding.text2.setText(txt);
        });
    }

    private void pressBtn_3() {
        binding.btn3.setOnClickListener(v -> {
            String txt = binding.text2.getText().toString() + binding.btn3.getText().toString();
            binding.text2.setText(txt);
        });
    }

    private void pressBtn_4() {
        binding.btn4.setOnClickListener(v -> {
            String txt = binding.text2.getText().toString() + binding.btn4.getText().toString();
            binding.text2.setText(txt);
        });
    }

    private void pressBtn_5() {
        binding.btn5.setOnClickListener(v -> {
            String txt = binding.text2.getText().toString() + binding.btn5.getText().toString();
            binding.text2.setText(txt);
        });
    }

    private void pressBtn_6() {
        binding.btn6.setOnClickListener(v -> {
            String txt = binding.text2.getText().toString() + binding.btn6.getText().toString();
            binding.text2.setText(txt);
        });
    }

    private void pressBtn_7() {
        binding.btn7.setOnClickListener(v -> {
            String txt = binding.text2.getText().toString() + binding.btn7.getText().toString();
            binding.text2.setText(txt);
        });
    }

    private void pressBtn_8() {
        binding.btn8.setOnClickListener(v -> {
            String txt = binding.text2.getText().toString() + binding.btn8.getText().toString();
            binding.text2.setText(txt);
        });
    }

    private void pressBtn_9() {
        binding.btn9.setOnClickListener(v -> {
            String txt = binding.text2.getText().toString() + binding.btn9.getText().toString();
            binding.text2.setText(txt);
        });
    }

    private void pressBtn_dot() {
        binding.btnDot.setOnClickListener(v -> {
            String txt = binding.text2.getText().toString() + binding.btnDot.getText().toString();
            binding.text2.setText(txt);
        });
    }

    private void pressBtn_Backspace() {
        binding.backspaceButton.setOnClickListener(v -> {
            String back = null;
            if (binding.text2.getText().length() > 0) {
                StringBuilder builder = new StringBuilder(binding.text2.getText());
                builder.deleteCharAt(binding.text2.getText().length() - 1);
                back = builder.toString();
                binding.text2.setText(back);
            }
        });
    }

    private void percentBtn() {
        binding.percentButton.setOnClickListener(v -> {
//            String txt = binding.text2.getText().toString() + binding.percentButton.getText().toString();
//            binding.text1.setText(txt);
//            binding.text2.setText("");

            num1 = Double.parseDouble("" + binding.text2.getText());
            String primary = String.format("%.2f", num1);
            binding.text1.setText(primary);
            binding.text2.setText("");
            operation = "%";
        });
    }

    private void addBtn() {
        binding.btnAdd.setOnClickListener(v -> {
//            String txt = binding.text2.getText().toString() + binding.btnAdd.getText().toString();
//            binding.text2.setText(txt);
            num1 = Double.parseDouble((String) binding.text2.getText().toString());
            primary = String.format("%.2f", num1);
            binding.text1.setText(primary);
            binding.text2.setText("");
            operation = "+";
        });
    }

    private void subBtn() {
        binding.btnSub.setOnClickListener(v -> {
//            String txt = binding.text2.getText().toString() + binding.btnSub.getText().toString();
//            binding.text2.setText(txt);
            num1 = Double.parseDouble((String) binding.text2.getText().toString());
            String primary = String.format("%.2f", num1);
            binding.text1.setText(primary);
            binding.text2.setText("");
            operation = "-";
        });
    }

    private void multBtn() {
        binding.btnMult.setOnClickListener(v -> {
//            String txt = binding.text2.getText().toString() + binding.btnMult.getText().toString();
//            binding.text2.setText(txt);
            num1 = Double.parseDouble((String) binding.text2.getText().toString());
            String primary = String.format("%.2f", num1);
            binding.text1.setText(primary);
            binding.text2.setText("");
            operation = "*";
        });
    }

    private void divBtn() {
        binding.devideButton.setOnClickListener(v -> {
            //           String txt = binding.text2.getText().toString() + binding.devideButton.getText().toString();
            //           binding.text2.setText(txt);
            num1 = Double.parseDouble((String) binding.text2.getText().toString());
            String primary = String.format("%.2f", num1);
            binding.text1.setText(primary);
            binding.text2.setText("");
            operation = "/";
        });
    }

    private void equalBtn() {
        binding.btnEqual.setOnClickListener(v -> {
            num2 = Double.parseDouble("" + binding.text2.getText().toString());
            if (operation == "+") {
                result = num1 + num2;
                result = Calculator.addition(num1, num2);
                answer = String.format("%.2f", result);
                binding.text2.setText(answer);
                binding.text1.setText(null);
            } else if (operation == "-") {
                result = Calculator.subtraction(num1, num2);
                answer = String.format("%.2f", result);
                binding.text2.setText(answer);
                binding.text1.setText(null);
            } else if (operation == "*") {
                result = Calculator.multiplication(num1, num2);
                answer = String.format("%.2f", result);
                binding.text2.setText(answer);
                binding.text1.setText(null);
            } else if (operation == "/") {
                result = Calculator.division(num1, num2);
                answer = String.format("%.2f", result);
                binding.text2.setText(answer);
                binding.text1.setText(null);
            }
        });
    }
}