package cc.morawiec.apps;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Okienko {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;


    public Okienko() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("test");
            }
        });
    }



    public static void main(String[] args) throws IOException {
        JFrame okienko = new JFrame("Talia kart");

        //okienko.setContentPane(new JLabel(new ImageIcon(someCard.getCardImage())));
        okienko.setContentPane(new Okienko().panel1);
        okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okienko.pack();
        okienko.setSize(500,500);
        okienko.setVisible(true);
    }
}
