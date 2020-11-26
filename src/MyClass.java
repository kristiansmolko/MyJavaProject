import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyClass extends WindowAdapter implements ActionListener{
    JFrame f;
    JTextArea ta;
    JButton b1, b2, b3, b4, dialogB;
    JTextField tf;
    private static JDialog d;
    private Calculations calc = new Calculations();

    MyClass(){
        f = new JFrame("My Project");
        Panel buttonPanel = new Panel(new GridLayout(1,4));
        Panel displayPanel = new Panel(new GridLayout(1,2));
        f.setLayout(new BorderLayout());
        b1 = new JButton("Why?");
        b1.setBounds(20,100,50,30);
        b2 = new JButton("Add");
        b2.setBounds(100,100,50,30);
        b3 = new JButton("Show");
        b3.setBounds(180,100,50,30);
        b4 = new JButton("Clear");
        b4.setBounds(260,100,50,30);
        ta = new JTextArea();
        ta.setBounds(0,0,200,200);
        tf = new JTextField();
        tf.setBounds(0,0,200,30);
        displayPanel.add(new JLabel("Add number:"));
        displayPanel.add(tf);
        try {
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
            Thread.sleep(1000);
        }catch(Exception ex){}
        buttonPanel.add(b1); buttonPanel.add(b2); buttonPanel.add(b3); buttonPanel.add(b4);
        f.add(buttonPanel, BorderLayout.SOUTH);
        f.add(displayPanel, BorderLayout.NORTH);
        f.add(ta, BorderLayout.CENTER);
        f.setSize(400,400);
        f.addWindowListener(this);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setVisible(true);
    }

    public void windowClosing(WindowEvent e){
        Calculations calculations = new Calculations();
        String message = calculations.print();
        int a = JOptionPane.showConfirmDialog(f,message + " Are you sure you want to quit?");
        if (a == JOptionPane.YES_OPTION){
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public static void main(String[] args) {
        new MyClass();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == b1){
            ta.setText("Helping you remeber numbers!\n" +
                    "---------------------------------------\n");
        }
        if (e.getSource() == b2){
            int number = Integer.parseInt(tf.getText());
            calc.storeToList(number);
            tf.setText("");
            ta.append("Added number: " + number +"\n");
        }
        if (e.getSource() == b3){
            ta.setText("");
            ta.append("Stored values: ");
            for (Integer temp : calc.getList()){
                ta.append(temp + ", ");
            }
        }
        if (e.getSource() == b4){
            if (calc.isEmpty())
                try {
                    throw new MyException("List is empty");
                } catch (MyException myException) {
                    myException.printStackTrace();
                    System.exit(0);
                }
            else {
                calc = new Calculations(true);
                tf.setText("");
                ta.setText("You have cleared your list");
            }
        }
    }
}


