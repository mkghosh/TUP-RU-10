package banglatutorial.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText numberText;
    private double numberOne;

    private Action action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        init();
    }

    private void init() {
        numberText = (EditText) findViewById(R.id.editText);
        findViewById(R.id.btnPlus).setOnClickListener(this);
        findViewById(R.id.btnMinus).setOnClickListener(this);
        findViewById(R.id.btnDiv).setOnClickListener(this);
        findViewById(R.id.btnEquals).setOnClickListener(this);
        findViewById(R.id.btnMul).setOnClickListener(this);
        findViewById(R.id.btnPer).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String temp = numberText.getText().toString();

        if (temp.isEmpty()) {
            numberText.setError("No Number provided");
            return;
        } else {
            numberOne = Double.parseDouble(temp);
            if(view.getId() != R.id.btnEquals)
                numberText.setText("");
        }
        switch (view.getId()) {
            case R.id.btnPlus:
                action = Action.ADD;
                break;
            case R.id.btnMinus:
                action = Action.MINUS;
                break;
            case R.id.btnDiv:
                action = Action.DIVISION;
                break;
            case R.id.btnMul:
                action = Action.MULTIPLICATION;
                break;
            case R.id.btnPer:
                action = Action.PERCENTAGE;
                break;
            case R.id.btnEquals:
                process();
                break;
        }
    }

    private void process() {
        String temp = numberText.getText().toString();
        if (temp.isEmpty()) {
            numberText.setError("Please Insert second number");
        } else {
            double numberTwo = Double.parseDouble(temp);
            switch (action) {
                case ADD:
                    numberText.setText("" + (numberOne + numberTwo));
                    break;
                case MINUS:
                    numberText.setText("" + (numberOne - numberTwo));
                    break;
                case MULTIPLICATION:
                    numberText.setText("" + (numberOne * numberTwo));
                    break;
                case DIVISION:
                    numberText.setText("" + (numberOne / numberTwo));
                    break;
                case PERCENTAGE:
                    double result = (numberOne * numberTwo) / 100;
                    numberText.setText("" + result);
                    break;

            }
            numberOne = 0;
        }
    }

    private enum Action {
        ADD, MINUS, MULTIPLICATION, DIVISION, PERCENTAGE
    }
}
