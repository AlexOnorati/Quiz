package net.greenriver.ontopgames.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        TextView result = (TextView) findViewById(R.id.result);
        result.setText(getString(R.string.results)+"" + Quiz.instance.GetPercentRight());
    }

    /**
     * Restarts with the new view.
     * @param view that is being altered.
     */
    public void Restart(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
