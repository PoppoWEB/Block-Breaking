package sys.level;

public interface Level {
    abstract int[] getSX();
    abstract int[] getEX();
    abstract int[][] getY();
    abstract int getLen();
    abstract int getWid();
    abstract int getLife();
    abstract int getBlock_X();
    abstract int getBlock_Y();
    abstract double getSpeed_X();
    abstract double getSpeed_Y();
}
