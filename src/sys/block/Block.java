package sys.block;

import java.awt.*;

public class Block {
    private int Y;
    private int SX;
    private int EX;
    private Color blockColor;

    public Block(int Y , int SX, int EX, Color blockColor) {
        this.Y = Y;
        this.SX = SX;
        this.EX = EX;
        this.blockColor = blockColor;
    }

    public int getSX() {
        return SX;
    }

    public int getEX() {
        return EX;
    }

    public int getY() {
        return Y;
    }

    public Color getBlockColor() {
        return blockColor;
    }
}