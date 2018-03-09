//Look something changed

public class AdventureQuestion
{
    private String question;
    private String answerA,answerB,answerC;

    public AdventureQuestion(String question, String answerA, String answerB, String answerC)
    {
        this.question=question;
        this.answerA=answerA;
        this.answerB=answerB;
        this.answerC=answerC;
    }

    public  String getQuestion()
    {
        return question;
    }

    public  String getAnswerA()
    {
        return answerA;//.substring(6); //because the first 2 chars determine the effect on sanity and Iago trust.
    }

    public  String getAnswerB()
    {
        return answerB;//.substring(6); //because the first 2 chars determine the effect on sanity and Iago trust.
    }

    public String getAnswerC()
    {
        return answerC;//.substring(6); //because the first 2 chars determine the effect on sanity and Iago trust.
    }
    public  int getEffects(int whichBar, String answer) //0, 2, 4 for each bar
    {
        return Integer.parseInt(answer.substring(whichBar,whichBar+2));
    }




    //public static int getBarMods



}

//250000Avoid the question.