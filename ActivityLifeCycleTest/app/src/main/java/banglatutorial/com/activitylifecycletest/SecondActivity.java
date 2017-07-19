package banglatutorial.com.activitylifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.btnPreviousActivity).setOnClickListener((v) -> {

//            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}
