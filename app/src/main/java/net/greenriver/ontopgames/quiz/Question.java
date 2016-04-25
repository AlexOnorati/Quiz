package net.greenriver.ontopgames.quiz;

/**
 * Created by alexo on 4/15/2016.
 */
public class Question {
    private String question;
    private boolean isTrue;
    private boolean gotCorrect;
    private boolean beenAnswered;

    /**
     * Constructor for the Question
     * @param question to be read.
     * @param isTrue gets the answer.
     */
    public Question(String question, boolean isTrue){
        this.question = question;
        this.isTrue = isTrue;
        beenAnswered = false;
    }

    /**
     * Gets the question.
     * @return the question
     */
    public String getQuestion(){
        return  question;
    }

    /**
     * Checks to see if the answer is correct.
     * @param choice that was given.
     * @return
     */
    public boolean isCorrectAnswer(boolean choice){
        return choice == isTrue;
    }

    /**
     * Checks to see if the question has been answered.
     * @return true/false result
     */
    public boolean beenAnswered(){
        return beenAnswered;
    }

    /**
     * Sets the question to be answered.
     */
    public void hasBeenAnswered(){
        beenAnswered = true;
    }
}
