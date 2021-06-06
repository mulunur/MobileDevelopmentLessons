package ru.mirea.kartamysheva.mireaprogectapp.ui.calculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.kartamysheva.mireaprogectapp.R;

public class CalculatorFragment extends Fragment implements View.OnClickListener {

    private CalculatorViewModel calculatorViewModel;

    EditText editTextNum1;
    EditText editTextNum2;
    Button buttonAdd;
    Button buttonSub;
    Button buttonMult;
    Button buttonDiv;
    Button buttonReset;
    TextView tvResult;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calculatorViewModel =
                new ViewModelProvider(this).get(CalculatorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calculator, container, false);

        final TextView textView = root.findViewById(R.id.text_calculator);
        editTextNum1 = root.findViewById(R.id.editTextNumber1);
        editTextNum2 = root.findViewById(R.id.editTextNumber2);
        buttonAdd = root.findViewById(R.id.buttonAdd);
        buttonSub= root.findViewById(R.id.buttonSub);
        buttonMult = root.findViewById(R.id.buttonMult);
        buttonDiv = root.findViewById(R.id.buttonDiv);
        buttonReset = root.findViewById(R.id.buttonReset);

        tvResult = root.findViewById(R.id.textViewResult);

        buttonAdd.setOnClickListener(this::onClick);
        buttonSub.setOnClickListener(this::onClick);
        buttonMult.setOnClickListener(this::onClick);
        buttonDiv.setOnClickListener(this::onClick);
        buttonReset.setOnClickListener(this::onClick);

        calculatorViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float result = 0;
        String operat = "";
        if (TextUtils.isEmpty(editTextNum1.getText().toString())
                || TextUtils.isEmpty(editTextNum2.getText().toString())) {
            return;
        }
        num1 = Float.parseFloat(editTextNum1.getText().toString());
        num2 = Float.parseFloat(editTextNum2.getText().toString());
        switch (v.getId()){
            case R.id.buttonAdd :
                operat = "+";
                result = num1 + num2;
                tvResult.setText(num1 + "  " + operat + "  " + num2 + "  =  " + result);
                break;
            case R.id.buttonSub:
                operat = "-";
                result = num1 - num2;
                tvResult.setText(num1 + "  " + operat + "  " + num2 + "  =  " + result);
                break;
            case R.id.buttonMult:
                operat = "*";
                result = num1 * num2;
                tvResult.setText(num1 + "  " + operat + "  " + num2 + "  =  " + result);
                break;
            case R.id.buttonDiv:
                operat = "/";
                result = num1 / num2;
                tvResult.setText(num1 + "  " + operat + "  " + num2 + "  =  " + result);
                break;
            case R.id.buttonReset:
                editTextNum1.setText("");
                editTextNum2.setText("");
                tvResult.setText("");
                break;
            default:
                break;
        }
    }
}