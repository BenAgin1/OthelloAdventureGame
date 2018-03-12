import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Screen extends JFrame implements ActionListener
{
    private static final EasySound ding = new EasySound("ding.wav");
    //private static final EasySound damn = new EasySound("ding.wav");





    public final int MAX_NUMBER_ROWS= 5;
    public final int MAX_NUMBER_COLS=30;

    AdventureQuestion[] questions= //add the questions here, and effects as well
    {//I will edit it later to not show the numbers right in front.
            //NEW: above 50 is increase, below is decrease.
            new AdventureQuestion("THIS IS A FILL, WONT SHOW", "505050nothing much", "505050Hillll", "505050HUihefsef"),
            new AdventureQuestion("Whats up2?", "506070nothing much2", "405020Hillll2", "506050HUihefsef2"),
            new AdventureQuestion("You see Desdemona on the bed. What do you do?", "000099Kill her.", "606030Wake her up and talk through it.",  "000020Kill yourself."),
            new AdventureQuestion("The end of Game", "505050 ", "505050 ", "505050 ")
    };

    // Declare an array of "fortunes" (strings):
    //String[] fortunes = {"You will be happy for today only. eifjiesjfoisejfiejijsieofjiosej foisejfoisejfoisjefoiseo ifjisoejf", "You find Desdemona sleeping in bed, what do you do?", "You will find happiness.", "You will find peace."};
    public int questionPlace=0;
    JFrame window;
//    BufferedImage myPicture = ImageIO.read(new File("/Users/benagin/Library/Mobile Documents/com~apple~CloudDocs/APCS/OthelloAdventure/68512519-cyprus-wallpapers.jpg"));
//    JLabel picLabel = new JLabel(new ImageIcon(myPicture));

    AdventureQuestion questionNow = questions[questionPlace];

    JButton buttonA= new JButton("A");
    JButton buttonB= new JButton("B");
    JButton buttonC= new JButton("C");

    JProgressBar Respect= new JProgressBar(0,100);
    JProgressBar Sanity= new JProgressBar(0,100);
    JProgressBar TrustInIago= new JProgressBar(0,100);

    //String[] question1= {"" , "", "" , ""};

    private JTextArea displayQ;
    private JTextArea displayA;
    private JTextArea displayB;
    private JTextArea displayC;

    public Screen()
    {
        super("Othello Adventure Game");

        displayQ = new JTextArea(MAX_NUMBER_ROWS,MAX_NUMBER_COLS);
        displayQ.setLineWrap(true);
        displayQ.setWrapStyleWord(true);
        displayQ.setText("Welcome to the Othello \"Choose Your Adventure\" Game! \n\n Made By: Ben Agin and  Sarah Zhang");
        displayQ.setBackground(Color.WHITE);
        displayQ.setEditable(false);



        //JButton buttonA = new JButton("A");
        buttonA.addActionListener(this);
        buttonA.setForeground(Color.RED);
        //buttonA.setBounds(100,400,500,20);
        displayA = new JTextArea(MAX_NUMBER_ROWS,MAX_NUMBER_COLS);
        displayA.setLineWrap(true);
        displayA.setWrapStyleWord(true);
        displayA.setText("Read the question at the top and choose how you, Othello, want to respond to it");
        displayA.setBackground(Color.WHITE);
        displayA.setEditable(false);


        //JButton buttonB = new JButton("B");
        buttonB.addActionListener(this);
        buttonB.setForeground(Color.RED);

        displayB = new JTextArea(MAX_NUMBER_ROWS,MAX_NUMBER_COLS);
        displayB.setLineWrap(true);
        displayB.setWrapStyleWord(true);
        displayB.setText("Hover over things on the screen to see more info about that part of the game");
        displayB.setBackground(Color.WHITE);
        displayB.setEditable(false);

        //JButton buttonC = new JButton("C");
        buttonC.addActionListener(this);
        buttonC.setForeground(Color.RED);
        //buttonC.setToolTipText(questionNow.getAnswerC().substring(0,2)+" "+ questionNow.getAnswerC().substring(2,4)+" "+ questionNow.getAnswerC().substring(4,6));


        displayC = new JTextArea(MAX_NUMBER_ROWS,MAX_NUMBER_COLS);
        displayC.setLineWrap(true);
        displayC.setWrapStyleWord(true);
        displayC.setText("Have fun! Click any button to begin!");
        displayC.setBackground(Color.WHITE);
        displayC.setEditable(false);





        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(displayQ);

        c.add(buttonA);
        c.add(displayA);

        c.add(buttonB);
        c.add(displayB);

        c.add(buttonC);
        c.add(displayC);


        c.add(Respect);
        c.add(Sanity);
        c.add(TrustInIago);

        Respect.setString("Respect");
        Respect.setStringPainted(true);
        Respect.setValue(80);
        Respect.setToolTipText("How much respect you have in the community");

        Sanity.setString("Sanity");
        Sanity.setStringPainted(true);
        Sanity.setValue(100);
        Sanity.setToolTipText("How mentally sane you are");

        //TrustInIago.setString("TrustInIago");
        TrustInIago.setStringPainted(true);
        TrustInIago.setValue(50);
        TrustInIago.setString("Trust in Iago");
        TrustInIago.setToolTipText("How much Trust you have in Iago, consider this when you make your choices");
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

        // Pick and display a random fortune:

        //String fortune = fortunes[questionPlace];
//        try
//        {
//
//            window.add(picLabel);
//            picLabel.setBounds(0,0,385,442);
//        }
//        catch(IOException c)
//
//        {System.exit(3);}
//

        questionPlace++;

        if (questionPlace>=questions.length)
        {

            return;

        }

        //if (questionPlace ==2 && TrustInIago.getValue() <= 40)
         //   questionPlace++;

        //questionNow
        questionNow = questions[questionPlace];
        displayQ.setText(questions[questionPlace].getQuestion());
        displayB.setText(questions[questionPlace].getAnswerB().substring(6));
        displayA.setText(questions[questionPlace].getAnswerA().substring(6));
        displayC.setText(questions[questionPlace].getAnswerC().substring(6));

        buttonC.setToolTipText(questionNow.getAnswerC().substring(0,2)+" "+ questionNow.getAnswerC().substring(2,4)+" "+ questionNow.getAnswerC().substring(4,6));
        buttonB.setToolTipText(questionNow.getAnswerB().substring(0,2)+" "+ questionNow.getAnswerB().substring(2,4)+" "+ questionNow.getAnswerB().substring(4,6));
        buttonA.setToolTipText(questionNow.getAnswerA().substring(0,2)+" "+ questionNow.getAnswerA().substring(2,4)+" "+ questionNow.getAnswerA().substring(4,6));

        ding.play();



        //
    }

    public void adjustBar(char ans)
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


//        try
//        {
//            BufferedImage myPicture = ImageIO.read(new File("/Users/benagin/Library/Mobile Documents/com~apple~CloudDocs/APCS/OthelloAdventure/68512519-cyprus-wallpapers.jpg"));
//            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//            window.add(picLabel);
//            picLabel.setBounds(0,0,385,442);
//        }
//        catch(IOException e)

        //{System.exit(3);}
    }
}