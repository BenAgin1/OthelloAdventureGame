import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Screen extends JFrame implements ActionListener
{
    private static final EasySound ding = new EasySound("ding.wav");

    public final int MAX_NUMBER_ROWS= 5;
    public final int MAX_NUMBER_COLS=30;

    AdventureQuestion[] questions= {new AdventureQuestion("Whats up?", "123242nothing much", "674839Hillll", "984523HUihefsef")};

    // Declare an array of "fortunes" (strings):
    String[] fortunes = {"You will be happy for today only. eifjiesjfoisejfiejijsieofjiosej foisejfoisejfoisjefoiseo ifjisoejf", "You find Desdemona sleeping in bed, what do you do?", "You will find happiness.", "You will find peace."};
    public int questionPlace=0;

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
        displayQ.setText("\"  Press \\\"Next\\\" to see your fortune... tihjeoirjgeo ergeroijgoe roigjeirgjergie eirjgeirgje");
        displayQ.setBackground(Color.WHITE);
        displayQ.setEditable(false);



        //JButton buttonA = new JButton("A");
        buttonA.addActionListener(this);
        //buttonA.setBounds(100,400,500,20);
        displayA = new JTextArea(MAX_NUMBER_ROWS,MAX_NUMBER_COLS);
        displayA.setLineWrap(true);
        displayA.setWrapStyleWord(true);
        displayA.setText("Kill Desdemona.");
        displayA.setBackground(Color.WHITE);
        displayA.setEditable(false);


        //JButton buttonB = new JButton("B");
        buttonB.addActionListener(this);

        displayB = new JTextArea(MAX_NUMBER_ROWS,MAX_NUMBER_COLS);
        displayB.setLineWrap(true);
        displayB.setWrapStyleWord(true);
        displayB.setText("Save her.");
        displayB.setBackground(Color.WHITE);
        displayB.setEditable(false);

        //JButton buttonC = new JButton("C");
        buttonC.addActionListener(this);

        displayC = new JTextArea(MAX_NUMBER_ROWS,MAX_NUMBER_COLS);
        displayC.setLineWrap(true);
        displayC.setWrapStyleWord(true);
        displayC.setText("Kill yourself.");
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

        Sanity.setString("Sanity");
        Sanity.setStringPainted(true);
        Sanity.setValue(100);

        TrustInIago.setString("TrustInIago");
        TrustInIago.setStringPainted(true);
        TrustInIago.setValue(50);
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


        questionPlace++;
        if (questionPlace ==2 && TrustInIago.getValue() <= 40)
            questionPlace++;

        //questionNow

        displayQ.setText("  " + questions[questionPlace].getQuestion());
        displayB.setText(questions[questionPlace].getAnswerB());
        ding.play();

        //
    }

    public void adjustBar(char ans)
    {
        if (ans=='a')
        {
            Respect.setValue( Respect.getValue()+ questionNow.getEffects(0, questionNow.getAnswerA()));
            Sanity.setValue( Sanity.getValue()+ questionNow.getEffects(2, questionNow.getAnswerA()));
            TrustInIago.setValue( TrustInIago.getValue()+ questionNow.getEffects(4, questionNow.getAnswerA()));

        }
        if (ans=='b')
        {
            Respect.setValue( Respect.getValue()+ questionNow.getEffects(0, questionNow.getAnswerB()));
            Sanity.setValue( Sanity.getValue()+ questionNow.getEffects(2, questionNow.getAnswerB()));
            TrustInIago.setValue( TrustInIago.getValue()+ questionNow.getEffects(4, questionNow.getAnswerB()));

        }
        if (ans=='c')
        {
            Respect.setValue( Respect.getValue()+ questionNow.getEffects(0, questionNow.getAnswerC()));
            Sanity.setValue( Sanity.getValue()+ questionNow.getEffects(2, questionNow.getAnswerC()));
            TrustInIago.setValue( TrustInIago.getValue()+ questionNow.getEffects(4, questionNow.getAnswerC()));

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