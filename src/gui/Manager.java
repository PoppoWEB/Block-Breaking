package gui;

import gui.frame.PlayFrame;

public class Manager {
    private static final Manager singlton = new Manager();
    private PlayFrame frame;
    private PlayCampus campus;

    private Manager() {
    }

    public static Manager getSinglton() {
        return singlton;
    }

    public void setFrame(PlayFrame frame) {
        this.frame = frame;
    }

    public void setCampus(PlayCampus campus) {
        this.campus = campus;
    }

    public PlayCampus getCampus() {
        return campus;
    }

    public PlayFrame getFrame() {
        return frame;
    }
}
