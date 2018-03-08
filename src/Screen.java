import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Screen extends JFrame implements ActionListener {
    private static final EasySound ding = new EasySound("ding.wav");

    // Declare an array of "fortunes" (strings):
    String[] fortunes = {"You will be happy for today only.", "You will die today.", "You will find happiness.", "You will find peace."};

    private JTextField display;

    public Screen() {
        super("Fortune Teller");

        display = new JTextField("  Press \"Next\" to see your fortune...", 25);
        display.setBackground(Color.WHITE);
        display.setEditable(false);

        JButton go = new JButton("Next");
        go.addActionListener(this);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(display);
        c.add(go);
    }

    public void actionPerformed(ActionEvent e) {
        // Pick and display a random fortune:
        String fortune = fortunes[(int) (fortunes.length * Math.random())];
        display.setText("  " + fortune);
        ding.play();

            //

    }

    public static void main(String[] args) {
        JFrame window = new Screen();
        window.setBounds(300, 300, 300, 100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
    }