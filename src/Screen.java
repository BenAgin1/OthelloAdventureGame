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

    // Declare an array of "fortunes" (strings):
    String[] fortunes = {"You will be happy for today only. eifjiesjfoisejfiejijsieofjiosej foisejfoisejfoisjefoiseo ifjisoejf", "You find Desdemona sleeping in bed, what do you do?", "You will find happiness.", "You will find peace."};

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



        JButton buttonA = new JButton("A");
        buttonA.addActionListener(this);
        //buttonA.setBounds(100,400,500,20);
        displayA = new JTextArea(MAX_NUMBER_ROWS,MAX_NUMBER_COLS);
        displayA.setLineWrap(true);
        displayA.setWrapStyleWord(true);
        displayA.setText("Kill Desdemona.");
        displayA.setBackground(Color.WHITE);
        displayA.setEditable(false);


        JButton buttonB = new JButton("B");
        buttonB.addActionListener(this);

        displayB = new JTextArea(MAX_NUMBER_ROWS,MAX_NUMBER_COLS);
        displayB.setLineWrap(true);
        displayB.setWrapStyleWord(true);
        displayB.setText("Save her.");
        displayB.setBackground(Color.WHITE);
        displayB.setEditable(false);

        JButton buttonC = new JButton("C");
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



    }

    public void actionPerformed(ActionEvent e)
    {
        // Pick and display a random fortune:
        String fortune = fortunes[(int) (fortunes.length * Math.random())];
        displayQ.setText("  " + fortune);
        ding.play();

        //

    }

    public static void main(String[] args)
    {
        JFrame window = new Screen();
        window.setBounds(100, 100, 385, 500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setVisible(true);
    }
}