package sys.level;

public class NormalLevel implements Level {
    private final int wid = 8;
    private final int len = 18;
    private final int Life = 3;
    private final int block_X = 25; // block size
    private final int block_Y = 25; // block size
    private final double Speed_X = 2;
    private final double Speed_Y = 1.5;
    private int[][] Y = new int[wid][len];
    private int[] SX = new int[len];
    private int[] EX = new int[len];

    public NormalLevel() {
        int s = 80; // 初期値
        int y = 25; // 縦幅

        for (int i = 0; i < wid; i++) {
            for (int j = 0; j < len; j++) {
                Y[i][j] = y;
            }
            y += 25;
        }

        for (int i = 0; i < len; i++) {
            SX[i] = s;
            EX[i] = s + block_X;
            s += block_X;
        }
    }

    @Override
    public int[][] getY() {
        return Y;
    }

    @Override
    public int[] getSX() {
        return SX;
    }

    @Override
    public int[] getEX() {
        return EX;
    }

    @Override
    public int getLen() {
        return len;
    }

    @Override
    public int getWid() {
        return wid;
    }

    @Override
    public int getLife() {
        return Life;
    }

    @Override
    public int getBlock_X() {
        return block_X;
    }

    @Override
    public int getBlock_Y() {
        return block_Y;
    }

    @Override
    public double getSpeed_X() {
        return Speed_X;
    }

    @Override
    public double getSpeed_Y() {
        return Speed_Y;
    }
}
