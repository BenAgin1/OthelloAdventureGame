//Look something changed
//?
/**
 *
 * @author Ben Agin and Sarah Zhang
 * @version March 17, 2018
 * \@assignment Othello Adventure Game
 *
 *Using IntelliJ
 *
 */

class AdventureQuestion
{
    private String question;
    private String answerA,answerB,answerC;

    AdventureQuestion(String question, String answerA, String answerB, String answerC)
    {
        this.question=question;
        this.answerA=answerA;
        this.answerB=answerB;
        this.answerC=answerC;
    }

    String getQuestion()
    {
        return question;
    }

    String getAnswerA()
    {
        return answerA;
    }

    String getAnswerB()
    {
        return answerB;
    }

    String getAnswerC()
    {
        return answerC;
    }

    //converts the answers to the effects on bars
    int getEffects(int whichBar, String answer) //0, 2, 4 for each bar
    {
        return Integer.parseInt(answer.substring(whichBar,whichBar+2));
    }

}

