/**
 *
 * @author Ben Agin and Sarah Zhang
 * @version March 17, 2018
 * \@assignment Othello Adventure Game
 *
 *Using IntelliJ
 *
 */

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Screen extends JFrame implements ActionListener
{
    private static final EasySound ding = new EasySound("ding.wav");

    private static final int MAX_NUMBER_ROWS= 5;
    private static final int MAX_NUMBER_COLS=30;

    private AdventureQuestion[] questions=
    {       //all questions that can be asked are added here, easy to change game length.
            //NEW: above 50 is increase, below is decrease.
            new AdventureQuestion("THIS IS A FILL, WONT SHOW", "505050Avoid the question", "505050 ", "505050 "),
            new AdventureQuestion("Barbantio accuses you of bewitching his daughter into marrying you while the entire Venetian senate is watching. How do you respond?", "305050Avoid the question", "605050Politely deny it", "202050Attack Barbantio"),
            new AdventureQuestion( "You made it safely to Cyprus", "405060Throw a party to celebrate!","605050Get back to work, no time for playing.", "505050 "),
            new AdventureQuestion( "At the party, you find Cassio drunk and fighting with Roderigo and Montano. From Iago, you learn that Cassio has injured Montano in their quarrel. How do you reprimand him?", "504080Strip Cassio of his lieutenancy.", "605050Do nothing", "505050"),
            new AdventureQuestion("Desdemona repeatedly asks you to forgive Cassio and make him lieutenant again. How do you respond to her?","607020Forgive Cassio.","504060Put it off.","503070Ignore her."), //only if answer before was throw a party
            new AdventureQuestion( "Iago acts suspiciously, suggesting that Desdemona is having an affair with Cassio. He tells you that he saw Cassio use the handkerchief YOU gave her to wipe his beard. How will you react?", "303080Vow to kill her.", "504050Wait for more evidence before making a decision", "606010Choose to trust Desdemona over Iago"),
            new AdventureQuestion( "You fall into an epileptic seizure after you are somewhat convinced that Desdmona is cheating on you. You see Cassio talking to Iago and holding the handkerchief, what do you do?", "503050Remain in hiding, building up anger.", "505050Now that you have proof, you are ready for revenge on Desdemona. You head to her bedroom.", "505050 "),
            new AdventureQuestion("Lodovico greets you and Desdemona with news from Venice. Cassio will replace you, and you must return back to Venice. What do you do?","103070Hit Desdemona.","404070Call Desdemona a Strumpet.","505020Choose not to be mad at Desdemona without good reason"),
            new AdventureQuestion("You find Desdemona sleeping peacefully in bed at night. What’s your move?", "508040Stare at her lovingly and get into bed with her", "303080Suffocate her to death with a pillow.",  "105030Kill yourself."),

            new AdventureQuestion("The end of Game", "505050 ", "505050 ", "505050Click any button to close game, Thanks for playing!")
    };

    private int questionPlace=0;



    private AdventureQuestion questionNow = questions[questionPlace]; //how it keeps track of question it is on now

    private JButton buttonA= new JButton("A");
    private JButton buttonB= new JButton("B");
    private JButton buttonC= new JButton("C");

                        //"Reputation" bar
    private JProgressBar Respect= new JProgressBar(0,100);
    private JProgressBar Sanity= new JProgressBar(0,100);
    private JProgressBar TrustInIago= new JProgressBar(0,100);


    private JTextArea displayQ;
    private JTextArea displayA;
    private JTextArea displayB;
    private JTextArea displayC;

    //this initializes the window when window object is constructed
    private Screen()
    {
        super("Othello Adventure Game");

        displayQ = new JTextArea(MAX_NUMBER_ROWS,MAX_NUMBER_COLS);
        displayQ.setLineWrap(true);

        displayQ.setWrapStyleWord(true);
        displayQ.setText("Welcome to the Othello \"Choose Your Adventure\" Game! \n\n Made By: Ben Agin and  Sarah Zhang");
        displayQ.setBackground(Color.WHITE);
        displayQ.setEditable(false);
        Color gray= new Color(200,200,200);
        displayQ.setBackground(gray);



        buttonA.addActionListener(this);
        buttonA.setForeground(Color.RED);
        displayA = new JTextArea(MAX_NUMBER_ROWS,MAX_NUMBER_COLS);
        displayA.setLineWrap(true);
        displayA.setWrapStyleWord(true);
        displayA.setText("Read the question at the top and choose how you, Othello, want to respond to it");
        displayA.setBackground(Color.WHITE);
        displayA.setEditable(false);



        buttonB.addActionListener(this);
        buttonB.setForeground(Color.RED);

        displayB = new JTextArea(MAX_NUMBER_ROWS,MAX_NUMBER_COLS);
        displayB.setLineWrap(true);
        displayB.setWrapStyleWord(true);
        displayB.setText("Hover over things on the screen to see more info about that part of the game");
        displayB.setBackground(Color.WHITE);
        displayB.setEditable(false);


        buttonC.addActionListener(this);
        buttonC.setForeground(Color.RED);
        displayC = new JTextArea(MAX_NUMBER_ROWS,MAX_NUMBER_COLS);
        displayC.setLineWrap(true);
        displayC.setWrapStyleWord(true);
        displayC.setText("Have fun! Click any button to begin!");
        displayC.setBackground(Color.WHITE);
        displayC.setEditable(false);


        //adding components to the screen
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(displayQ);

        c.add(buttonA);
        c.add(displayA);

        c.add(buttonB);
        c.add(displayB);

        c.add(buttonC);
        c.add(displayC);


        c.add(Respect); //all bars
        c.add(Sanity);
        c.add(TrustInIago);

        Respect.setString("Reputation");
        Respect.setStringPainted(true);
        Respect.setValue(80);
        Respect.setToolTipText("How much respect you have in the community");
        Respect.setForeground(Color.BLUE);

        Sanity.setString("Sanity");
        Sanity.setStringPainted(true);
        Sanity.setValue(100);
        Sanity.setToolTipText("How mentally sane you are");
        Sanity.setForeground(Color.RED);


        TrustInIago.setStringPainted(true);
        TrustInIago.setValue(25);
        TrustInIago.setString("Trust in Iago");
        TrustInIago.setToolTipText("How much Trust you have in Iago, consider this when you make your choices");
        TrustInIago.setForeground(Color.GREEN);
    }


    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == buttonA)
        {
            adjustBar('a');
        }
        if (e.getSource() == buttonB)
        {
            adjustBar('b');
        }
        if (e.getSource()== buttonC)
        {
            adjustBar('c');
        }


        /**  These is for the branching of stories, depends on user input    */
        if ((e.getSource()==buttonB || e.getSource() == buttonC) && questionPlace == 2) //adds another to skip drunk Cassio
        {
            questionPlace+=2; //2 because next 2 deal with Cassio

        }

        if ((e.getSource()==buttonA && questionPlace == 5))//adds another to skip drunk Cassio
        {
            questionPlace+=2; //2 because next 2 deal with Cassio

        }

        if ((e.getSource()==buttonB && questionPlace == 6))//adds another to skip drunk Cassio
        {
            questionPlace+=1; //2 because next 2 deal with Cassio

        }



        questionPlace++;

        if ((Respect.getValue() <= 0 || TrustInIago.getValue()>=99 || Sanity.getValue() == 0) && questionPlace!= questions.length ) // help to close the game
        {
        questionPlace= questions.length-1;
        //end game response when bars get to their values.

        }


        if (questionPlace>=questions.length)
        {


            //to close game
            ding.play();
            System.exit(1);



        }

        questionNow = questions[questionPlace];
        displayQ.setText(questions[questionPlace].getQuestion());
        displayB.setText(questions[questionPlace].getAnswerB().substring(6));
        displayA.setText(questions[questionPlace].getAnswerA().substring(6));
        displayC.setText(questions[questionPlace].getAnswerC().substring(6));


        //shows the effects of all choices
        buttonA.setToolTipText((questionNow.getEffects(0, questionNow.getAnswerA())-50)+" "+ (questionNow.getEffects(2, questionNow.getAnswerA())-50)+" "+ (questionNow.getEffects(4, questionNow.getAnswerA())-50));
        buttonB.setToolTipText((questionNow.getEffects(0, questionNow.getAnswerB())-50)+" "+ (questionNow.getEffects(2, questionNow.getAnswerB())-50)+" "+ (questionNow.getEffects(4, questionNow.getAnswerB ())-50));
        buttonC.setToolTipText((questionNow.getEffects(0, questionNow.getAnswerC())-50)+" "+ (questionNow.getEffects(2, questionNow.getAnswerC())-50)+" "+ (questionNow.getEffects(4, questionNow.getAnswerC())-50));



        //last question response prompts
        if (questionPlace == questions.length-1)
        {
            if (e.getSource() == buttonA) //end game text if you get to the last question. didn't die to bars.
            {
                displayA.setText("You learn from Desdemona about all the lies Iago has spread and order him to be imprisoned. You and Desdemona live happily ever after.");
            }
            else if (e.getSource()== buttonB)
            {
                displayA.setText("You kill Desdemona for supposedly cheating on you. Emilia walks in and turns you in to the authorities. You get imprisoned for the rest of your life.");
            }
            else
            {
                displayA.setText("Iago got his revenge, for you are left heartbroken and hysterical. You killed yourself and gave into Iago's manipulation.");
            }
        }

        //bar threshold response prompts
        if (Respect.getValue() <= 0 )
        {
            displayA.setText("Your Reputation reached 0 because your people lost trust in you.");

        }

        if (Sanity.getValue() <= 0 )
        {
            displayA.setText("Your Sanity reached 0 because you obsessed over Desdemona's \"affair\" with Cassio.");

        }

        if (TrustInIago.getValue() >= 99 )
        {
            displayA.setText("Your Trust in Iago Bar has reached 100, so high that Iago abused your friendship to kill you.");

        }

        ding.play();

    }

    //changes bars
    private void adjustBar(char ans)
    {
        if (ans=='a')
        {
            Respect.setValue( Respect.getValue()+ questionNow.getEffects(0, questionNow.getAnswerA())-50);
            Sanity.setValue( Sanity.getValue()+ questionNow.getEffects(2, questionNow.getAnswerA())-50);
            TrustInIago.setValue( TrustInIago.getValue()+ questionNow.getEffects(4, questionNow.getAnswerA())-50);

        }
        if (ans=='b')
        {
            Respect.setValue( Respect.getValue()+ questionNow.getEffects(0, questionNow.getAnswerB())-50);
            Sanity.setValue( Sanity.getValue()+ questionNow.getEffects(2, questionNow.getAnswerB())-50);
            TrustInIago.setValue( TrustInIago.getValue()+ questionNow.getEffects(4, questionNow.getAnswerB())-50);

        }
        if (ans=='c')
        {
            Respect.setValue( Respect.getValue()+ questionNow.getEffects(0, questionNow.getAnswerC())-50);
            Sanity.setValue( Sanity.getValue()+ questionNow.getEffects(2, questionNow.getAnswerC())-50);
            TrustInIago.setValue( TrustInIago.getValue()+ questionNow.getEffects(4, questionNow.getAnswerC())-50);

        }
    }


    public static void main(String[] args)
    {
        JFrame window = new Screen();
        window.setBounds(100, 100, 385, 525);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);


    }
}


