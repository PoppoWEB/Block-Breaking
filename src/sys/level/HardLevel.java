package sys.level;

public class HardLevel implements Level {
    private final int wid = 10;
    private final int len = 20;
    private final int Life = 3;
    private final int block_X = 20;
    private final int block_Y = 20;
    private final double Speed_X = 2.5;
    private final double Speed_Y = 2.5;
    private int[][] Y = new int[wid][len];
    private int[] SX = new int[len];
    private int[] EX = new int[len];

    public HardLevel() {
        int s = 80; // 初期値
        int y = 20; // 縦幅

        for (int i = 0; i < wid; i++) { // 高さ設定
            for (int j = 0; j < len; j++) {
                if (i >= wid/2) {
                    Y[i][j] = y + 50;
                } else {
                    Y[i][j] = y;
                }
            }
            y += block_Y;
        }

        for (int i = 0; i < len; i++) {
            if (i >= len/2) {
                SX[i] = s + 50;
                EX[i] = s + block_X + 50;
                s += block_X;
            } else {
                SX[i] = s;
                EX[i] = s + block_X;
                s += block_X;
            }
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
