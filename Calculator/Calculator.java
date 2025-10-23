import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField t;
    String op = "";
    double num1, num2, result;

    Calculator() {
        setTitle("Calculator");
        setLayout(new BorderLayout());
        t = new JTextField();
        add(t, BorderLayout.NORTH);
        JPanel p = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] btns = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
        for (String b : btns) {
            JButton btn = new JButton(b);
            btn.addActionListener(this);
            p.add(btn);
        }
        add(p, BorderLayout.CENTER);
        setSize(250, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.matches("[0-9.]")) t.setText(t.getText() + s);
        else if (s.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(t.getText());
            op = s;
            t.setText("");
        } else if (s.equals("=")) {
            num2 = Double.parseDouble(t.getText());
            switch (op) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> result = num2 != 0 ? num1 / num2 : 0;
            }
            t.setText("" + result);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
