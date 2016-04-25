package net.greenriver.ontopgames.quiz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by alexo on 4/15/2016.
 */
public class Quiz {
    public static Quiz instance;
    private int questionsCorrect;
    public int currentQuestion = 0;
    List<Question> questions;

    /**
     * Creates a quiz
     * @param questionsAdd the questions that are available to be used.
     * @param maxQuestions the max amount of questions that are used in the
     */
    public Quiz(Question[] questionsAdd, int maxQuestions) {
        Random randInt = new Random();
        this.questions = new ArrayList<Question>(Arrays.<Question>asList(questionsAdd));
        int size = this.questions.size();
        for(int i = 0; i < size - maxQuestions; i++){
            this.questions.remove(randInt.nextInt(this.questions.size()));
        }
    }

    /**
     * Checks the choice of the current question.
     * @param choice true/false answer
     * @return the result of the question
     */
    public boolean checkChoice(boolean choice){
        boolean result = questions.get(currentQuestion).isCorrectAnswer(choice);
        if(result && !questions.get(currentQuestion).beenAnswered()){
            questions.get(currentQuestion).hasBeenAnswered();
            questionsCorrect++;
        }
        return result;
    }

    /**
     * Shifts to the next question.
     */
    public  void shiftRight(){
        currentQuestion++;
    }

    /**
     * checks to see if it is the last question in the set.
     * @return true/false result.
     */
    public boolean isLast(){
        return currentQuestion == questions.size() - 1;
    }

    /**
     * Get the current questions info.
     * @return Gets the current question
     */
    public Question GetQuestion(){
        return questions.get(currentQuestion);
    }

    /**
     * Get the percentage of right cards.
     * @return percentage in string form.
     */
    public String GetPercentRight(){
        return +((questionsCorrect * 100) / questions.size())+"%";
    }
}