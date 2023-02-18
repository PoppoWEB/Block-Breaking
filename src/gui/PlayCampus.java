package gui;

import javax.swing.*;

import gui.frame.LevelFrame;
import sys.ball.BallBound;
import sys.block.Block;
import sys.block.BlockFactory;
import sys.level.Level;
import sys.tmp.PlayFunc;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class PlayCampus extends JPanel implements KeyListener {
    private int Life;
    private int Y = 450;
    private int SX = 250;
    private int EX = 340;
    private Level level;
    private List<Block> list;
    private BallBound ballBound;
    private boolean Stopper = false;
    private Color BarColor = Color.BLUE;
    private Manager manager = Manager.getSinglton();

    public PlayCampus(Level level) {
        super();
        manager.setCampus(this);
        this.level = level;
        this.Life = level.getLife();
        list = BlockFactory.getFactory().getBlock(level);
        ballBound = new BallBound(level.getSpeed_X(), level.getSpeed_Y(), list, this);

        addKeyListener(this);
        setSize(500, 500);
        setBackground(Color.BLACK);
        setVisible(true);
        play();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Bar Set
        g.setColor(BarColor);
        for (int i = SX; i <= EX; i+=PlayFunc.BAR_REPAINT) {
            g.fillRect(i, Y, PlayFunc.BAR_WID, PlayFunc.BAR_HIG);
        }

        // Block
        for (int i = 0; i < list.size(); i++) {
            g.setColor(list.get(i).getBlockColor());
            g.fillRect(list.get(i).getSX(), list.get(i).getY(), level.getBlock_X(), level.getBlock_Y());

            g.setColor(Color.BLACK);
            g.drawRect(list.get(i).getSX(), list.get(i).getY(), level.getBlock_X(), level.getBlock_Y());
        }

        g.setColor(Color.MAGENTA);
        g.fillOval((int)ballBound.getX(), (int)ballBound.getY(), ballBound.getRange(), ballBound.getRange());
    }

    public void play() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if (list.size() == 0 || Life == 0) { break; }
                    if (Stopper) {
                        try {
                            ballBound.xyUpdate();
                            ballBound.xUpdate();
                            ballBound.yUpdate();
                            
                            repaint();
                            Thread.sleep(PlayFunc.BALL_REPAINT_CALL);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.print("");
                    }
                }
                if (list.size() == 0) {
                    Message("GameClear", "GameClear!\nGo to Title?");
                } else {
                    Message("GameOver", "GameOver...\nGo to Title?");
                }
            }
        }).start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'd') {
            if (EX <= PlayFunc.BAR_EX_END) {
                EX += PlayFunc.BAR_X_POINT;
                SX += PlayFunc.BAR_X_POINT;
                if (EX > PlayFunc.BAR_EX_END) {
                    EX = 570;
                    SX = 480;
                }
                repaint();
            }
        } else if (e.getKeyChar() == 'a') {
            if (PlayFunc.BAR_SX_END <= SX) {
                EX -= PlayFunc.BAR_X_POINT;
                SX -= PlayFunc.BAR_X_POINT;
                if (SX < PlayFunc.BAR_SX_END) {
                    EX = 95;
                    SX = 5;
                }
                repaint();
            }
        } else if (e.getKeyCode() == 10) {
            if (Stopper == false) {
                chengeStop();
            }
        }
    }

    public int getSX() {
        return SX;
    }

    public int getEX() {
        return EX;
    }

    public int getSY() {
        return Y;
    }

    public int getLife() {
        return Life;
    }

    public void outLife() {
        Life--;
        manager.getFrame().resetLife();
    }

    public void chengeStop() {
        if (Stopper == false) {
            Stopper = true;
        } else {
            Stopper = false;
        }
    }

    public PlayCampus getPanel() {
        return this;
    }

    private void Message(String title, String msg) {
        int res = JOptionPane.showConfirmDialog(this, msg, title, JOptionPane.YES_NO_OPTION);
        
        if (res == JOptionPane.YES_OPTION) {
            new LevelFrame(PlayFunc.TITLE_NAME);
            manager.getFrame().dispose();
        } else {
            System.exit(0);
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
