package net.greenriver.ontopgames.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int MAX_QUESTIONS = 5;
    public static Question[] possibleQuestions = {
            new Question("The game series: Golden Sun has four games", false),
            new Question("Cream legbar chickens lay blue eggs", true),
            new Question("Calico cats a usually female", true),
            new Question("An icosahedron has 20 faces", true),
            new Question("Albinos usually have blue eyes", false),
            new Question("Baby turkeys are called pults", true),
            new Question("Dolphins are mammals", true),
            new Question("There are 65 books in the bible", false),
            new Question("Fire, Earth, Stone, Ice, Wind, Water are the six elements of the Toa in the Bionicle story", true),
            new Question("Amiibo have sold more then any other interactive game figure", true)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Quiz.instance = new Quiz(possibleQuestions, MAX_QUESTIONS);
        updateView();
    }


    /**
     *Goes to the next question
     * @param view that is being altered.
     */
    public void next(View view){
        if(Quiz.instance.isLast()){
            Intent intent = new Intent(this, Results.class);
            startActivity(intent);
        }else {
            Quiz.instance.shiftRight();
        }
        updateView();
    }

    /**
     * Checks the question when the user chooses true.
     * @param view that is being altered.
     */
    public void pickTrue(View view){
        if(Quiz.instance.checkChoice(true)){
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Checks the question when the user chooses false.
     * @param view that is being altered.
     */
    public void pickFalse(View view){
        if(Quiz.instance.checkChoice(false)){
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Updates the view with the new information.
     */
    public void updateView(){
        Question question = Quiz.instance.GetQuestion();
        TextView text = (TextView) findViewById(R.id.question);
        text.setText(question.getQuestion());


    }

}
