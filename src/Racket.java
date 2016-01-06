import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Racket extends GameObject {

	private int w = 64, h = 10;
	
	public Racket(int x, int y, ID id) {
		super(x, y, id);
		rect = new Rectangle(x, y, w, h);
		velocityY = 0;
		velocityX = 0;
		Speed=5;
	}

	@Override
	public void tick() {
		x += velocityX;
		x=checkEdge(x,Game.WIDTH-w,0);
		rect.x=x;
	}
	private static int checkEdge(int val,int max,int min){
		if(val>max) return max;
		else if(val<min) return min;
		else return val;
	}
	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, w, h);
	}
	public int getSpeed(){
		return Speed;
	}
}
