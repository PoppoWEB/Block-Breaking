package sys.ball;

public abstract class Ball {
    protected double x = 250;
    protected double y = 430;
    protected double dt = 1.5;
    protected double u = 1;
    protected int range = 15;

    public abstract void xyUpdate();
    public abstract void xUpdate();
    public abstract void yUpdate();

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void set_xy(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int getRange() {
        return range;
    }
}
