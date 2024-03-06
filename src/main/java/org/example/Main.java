package org.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.Highlighter;
import javax.swing.text.NumberFormatter;


public class Main extends JFrame implements ActionListener, FocusListener {
    JLabel title, text1, text2, text3;
    JButton Calculate, Exit;
    JTextField ans1, ans2, ans3, output;

    public Main() throws FontFormatException {
        this.setSize(1000, 750);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title = new JLabel("Roller Coaster Ride!", JLabel.CENTER);
        title.setFont(new Font("Century Gothic", Font.BOLD, 30));
        title.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0xBB0808), 6, true), "David's", TitledBorder.LEFT, TitledBorder.TOP, new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24)));

        text1 = new JLabel("Height in cm?");
        text1.setFont(new Font("Ariel", Font.BOLD, 15));
        text2 = new JLabel("Back Trouble? (Y/N)");
        text2.setFont(new Font("Ariel", Font.BOLD, 15));
        text3 = new JLabel("Heart Trouble? (Y/N)");
        text3.setFont(new Font("Ariel", Font.BOLD, 15));


        ans1 = new JTextField("Type here");
        ans1.setFont(new Font("Ariel", Font.PLAIN, 15));
        ans1.addFocusListener(this);
        ans2 = new JTextField("Type here");
        ans2.setFont(new Font("Ariel", Font.PLAIN, 15));
        ans2.addFocusListener(this);
        ans3 = new JTextField("Type here");
        ans3.setFont(new Font("Ariel", Font.PLAIN, 15));
        ans3.addFocusListener(this);

        output = new JTextField("Results will appear here. ");
        output.setEditable(false);
        output.setFont(new Font("Ariel", Font.PLAIN, 15));


        Calculate = new JButton("Calculate");
        Calculate.setFont(new Font("Ariel", Font.BOLD, 15));
        Calculate.setFocusPainted(false);
        Calculate.setFocusable(false);
        Calculate.addActionListener(this);


        Exit = new JButton("Exit");
        Exit.setFont(new Font("Ariel", Font.BOLD, 15));
        Exit.setFocusPainted(false);
        Exit.addActionListener(this);


        this.add(ans1);
        ans1.setBounds(600, 200, 100, 50);
        this.add(ans2);
        ans2.setBounds(600, 300, 100, 50);
        this.add(ans3);
        ans3.setBounds(600, 400, 100, 50);
        this.add(output);
        output.setBounds(300, 500, 400, 50);
        this.add(text1);
        text1.setBounds(300, 200, 200, 50);
        this.add(text2);
        text2.setBounds(300, 300, 200, 50);
        this.add(text3);
        text3.setBounds(300, 400, 200, 50);
        this.add(title);
        title.setBounds(300, 8, 500, 100);
        this.add(Calculate);
        Calculate.setBounds(175, 600, 150, 50);
        this.add(Exit);
        Exit.setBounds(750, 600, 150, 50);
        this.setVisible(true);


    }

    public static void main(String[] args) throws FontFormatException {
        new Main();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = ans1.getText();
        String backpain = ans2.getText().toLowerCase();
        String heartIssues = ans3.getText().toLowerCase();


        try {
            int height = Integer.parseInt(a);
            if (e.getSource() == Calculate) {


                if (height < 188 && height > 122) {


                    if (backpain.equals("n") || backpain.equals("no")) {
                        if (heartIssues.equals("n") || heartIssues.equals("no")) {
                            output.setText("Enjoy the ride bro");
                        } else if (heartIssues.equals("y") || heartIssues.equals("yes")) {
                            output.setText("You can't ride bro");
                        } else {
                            output.setText("Type yes or no bro");
                        }
                    } else if (backpain.equals("yes") || backpain.equals("y")) {
                        output.setText("You can't ride bro");
                    } else {
                        output.setText("Type yes or no bro");
                    }
                } else if (height < 0) {
                    output.setText("You can't be negative height bro");
                } else {
                    output.setText("You can't ride bro");
                }

            }
        }catch (NumberFormatException x) {
            output.setText("Number aint a number bro");
        }
        if (e.getSource() == Exit){
            System.exit(0);

        }
    }


    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == ans1){
            ans1.setText("");


        }else if(e.getSource() == ans2) {
            ans2.setText("");


        }else if(e.getSource() == ans3){
            ans3.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
