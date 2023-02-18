package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sys.level.EasyLevel;
import java.awt.*;
import java.awt.event.*;

public class PlayFrame extends JFrame implements ActionListener , KeyListener {
    private PlayCampus campus = new PlayCampus(new EasyLevel());

    public PlayFrame(String title) {
        super(title);
        setBackground(Color.WHITE);

        JPanel mainPane = new JPanel();
        mainPane.setLayout(new BorderLayout());

        mainPane.add(setTitle(), BorderLayout.NORTH);
        mainPane.add(campus.getPanel(), BorderLayout.CENTER);

        getContentPane().add(mainPane);
        addKeyListener(this);
        setSize(new Dimension(600, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private JPanel setTitle() {
        JPanel panel = new JPanel();
        JLabel lifeLabel = new JLabel("Life");
        JLabel lifes = new JLabel(String.valueOf(campus.getLife()));
        JLabel titleName = new JLabel("BlockOut");

        panel.add(lifeLabel);
        panel.add(lifes);
        panel.add(titleName);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        campus.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
