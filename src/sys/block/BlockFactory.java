package sys.block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import sys.level.Level;

public class BlockFactory {
    private static BlockFactory factory = new BlockFactory();
    private final Color colors[] = {Color.ORANGE, Color.RED, Color.WHITE, Color.GREEN,Color.YELLOW, Color.CYAN, Color.DARK_GRAY, Color.BLUE, Color.MAGENTA, Color.PINK};

    private BlockFactory() {
        super();
    }

    public static BlockFactory getFactory() {
        return factory;
    }

    public List<Block> getBlock(Level level) {
        List<Block> list = new ArrayList<>();
        int Y[][] = level.getY();
        int SX[] = level.getSX();
        int EX[] = level.getEX();

        for (int i = 0; i < level.getY().length; i++) {
            for (int j = 0; j < level.getLen(); j++) {
                list.add(new Block(Y[i][0], SX[j], EX[j], colors[i]));
            }
        }

        return list;
    }
}
