package sys.ball;

import java.util.ArrayList;
import java.util.List;

import gui.PlayCampus;
import sys.block.Block;

public class BallBound extends Ball{
    private List<Block> list = new ArrayList<>();
    private PlayCampus campus;
    private int xmin = 0;   // ball のxの移動最小範囲 
    private int xmax = 550; // ball のxの移動最大範囲
	private int ymin = 0;   // ball のyの移動最小範囲
	private int ymax = 500; // ball のyの移動最大範囲
	private double vx; // ball 速度
    private double vy; // ball 速度

    public BallBound(double vx, double vy, List<Block> list, PlayCampus campus) {
        this.vx = vx;
        this.vy = vy;
        this.list = list;
        this.campus = campus;
    }

    @Override
	public void xyUpdate()
	{
		x = x + vx * dt;
		y = y + vy * dt;

        double UY = y + range;
        double DY = y - range;
        double LX = x;
        double RX = x + range;

        if (campus.getSX() <= RX  && LX  <= campus.getEX() && campus.getSY() <= UY && DY <= campus.getSY()) {
            double resY = campus.getSY() - y;
            if (resY >= 5 ){
                this.vy *= -u;
            } else {
                this.vx *= -u;
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getSX() <= RX  && LX  <= list.get(i).getEX() && list.get(i).getY() <= UY && DY <= list.get(i).getY())
                {
                    double resY = list.get(i).getY() - y;
    
                    if (resY >= 10 ){
                        vy *= -u;
                    } else if (resY <= 0) {
                        vy *= -u;
                    } else {
                        vx *= -u;
                    }
                    list.remove(i);
                }
            }
        }
	}

    @Override
    public void xUpdate() // 壁の反射
	{
		if(x < xmin )
		{
			vx *= -u;
		}
		else if(xmax < x )
		{
			vx *= -u;
		}
	}
	
    @Override
	public void yUpdate() // 壁の反射
	{
		if(y < ymin )
		{
			vy *= -u;
		}
		else if(ymax < y )
		{
            campus.outLife();
            campus.chengeStop();
            x = 250;
            y = 430;

		}
	}
}
