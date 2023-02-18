package gui.frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sys.level.*;
import sys.tmp.PngMake;

import java.awt.*;
import java.awt.event.*;

public class LevelFrame extends JFrame implements ActionListener {
    private final String names[] = {"Easy", "Normal", "Hard", "Exit"};
    private JButton buttons[] = new JButton[names.length];    
    {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(names[i]);
            buttons[i].addActionListener(this);
        }
    }

    public LevelFrame(String title) {
        super(title);
        setSize(new Dimension(400,400));

        JPanel mainPane = new JPanel();
        mainPane.setLayout(new BorderLayout());

        mainPane.add(setTitle(), BorderLayout.NORTH);
        mainPane.add(setGif() , BorderLayout.CENTER);
        mainPane.add(setButton(), BorderLayout.SOUTH);
        mainPane.setBackground(Color.BLACK);

        getContentPane().add(mainPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private JPanel setTitle() {
        JPanel panel = new JPanel();
        JLabel titleLabel = new JLabel("Block Breaking");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setForeground(Color.BLACK);
        panel.add(titleLabel);

        return panel;
    }

    private JPanel setGif() {
        JPanel panel = new JPanel();
        JLabel gifLabel = new JLabel();
        gifLabel.setIcon(PngMake.Make(280, 280, "lib/" + "Title.jpg"));
        panel.add(gifLabel);

        return panel;
    }

    private JPanel setButton() {
        JPanel panel = new JPanel();
        
        for (int i = 0; i < buttons.length; i++) {
            panel.add(buttons[i]);
        }

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]) {
            new PlayFrame(names[0], new EasyLevel());
        } else if (e.getSource() == buttons[1]) {
            new PlayFrame(names[1], new NormalLevel());
        } else if (e.getSource() == buttons[2]) {
            new PlayFrame(names[2], new HardLevel());
        } else if (e.getSource() == buttons[3]) {
            System.exit(0);
        } 
        dispose();
    }
}