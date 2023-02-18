package gui.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.Manager;
import gui.PlayCampus;
import sys.level.Level;
import sys.tmp.BorderMake;
import sys.tmp.PngMake;

import java.awt.*;
import java.awt.event.*;

public class PlayFrame extends JFrame implements KeyListener {
    private JLabel life;
    private final String Heart = "Heart.png";
    private Manager manager = Manager.getSinglton();

    public PlayFrame(String title, Level level) {
        super(title);
        manager.setFrame(this);
        manager.setCampus(new PlayCampus(level)); 
        setBackground(Color.WHITE);

        JPanel mainPane = new JPanel();
        mainPane.setLayout(new BorderLayout());

        JPanel titlePane = new JPanel();
        titlePane.setBorder(BorderMake.lowBorder());
        titlePane.add(setTitle());
        mainPane.add(titlePane, BorderLayout.NORTH);

        mainPane.add( manager.getCampus().getPanel(), BorderLayout.CENTER);

        getContentPane().add(mainPane);
        addKeyListener(this);
        setSize(new Dimension(600, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private JPanel setTitle() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JPanel lifePane = new JPanel();
        JLabel lifeLabel = new JLabel(PngMake.Make(50, 50, "lib/" + Heart));
        life = new JLabel(String.valueOf(manager.getCampus().getLife()));
        life.setFont(new Font("Century", Font.BOLD, 20));
        lifePane.add(lifeLabel);
        lifePane.add(life);

        panel.add(lifePane, BorderLayout.CENTER);
        return panel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        manager.getCampus().keyPressed(e);
    }

    public void resetLife() {
        life.setText(String.valueOf(manager.getCampus().getLife()));
    }
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
