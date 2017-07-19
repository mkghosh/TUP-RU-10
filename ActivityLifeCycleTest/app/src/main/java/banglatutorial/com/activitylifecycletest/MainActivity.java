package banglatutorial.com.activitylifecycletest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int createCount = 0;
    private int startCount = 0;
    private int resumeCount = 0;
    private int pauseCount = 0;

    private TextView tvCreateCount, tvStartCount, tvResumeCount, tvPauseCount;
    private Button nextAcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        if (savedInstanceState != null) {

            createCount = savedInstanceState.getInt("createCount");
            startCount = savedInstanceState.getInt("startCount");
            resumeCount = savedInstanceState.getInt("resumeCount");
            pauseCount = savedInstanceState.getInt("pauseCount");
        }
        createCount++;
        tvCreateCount.setText("Create Count : " + createCount);

        nextAcButton.setOnClickListener((v) -> {
            startActivity(new Intent(this, SecondActivity.class));
//            finish();
        });
    }

    private void init() {
        tvCreateCount = (TextView) findViewById(R.id.tvOnCreate);
        tvStartCount = (TextView) findViewById(R.id.tvOnStart);
        tvResumeCount = (TextView) findViewById(R.id.tvOnResume);
        tvPauseCount = (TextView) findViewById(R.id.tvOnPause);
        nextAcButton = (Button) findViewById(R.id.btnNextActivity);
        tvPauseCount.setText("Pause Count : 0");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("createCount", createCount);
        outState.putInt("startCount", startCount);
        outState.putInt("resumeCount", resumeCount);
        outState.putInt("pauseCount", pauseCount);
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onStart() {
        super.onStart();
        startCount++;
        tvStartCount.setText("Start Count : " + startCount);

    }

    @Override
    protected void onResume() {
        super.onResume();
        resumeCount++;
        tvResumeCount.setText("Resume Count : " + resumeCount);

    }

    @Override
    protected void onPause() {
        super.onPause();
        pauseCount++;
        tvPauseCount.setText("Pause Count : " + pauseCount);

    }
}
