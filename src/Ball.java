import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends GameObject {

	
	public Ball(int x, int y, ID id) {
		super(x, y, id);
		Speed=5;
		velocityX=Speed;
		velocityY=Speed;
		rect = new Rectangle(x, y, 16, 16);
	}

	@Override
	public void tick() {
		x+=velocityX;
		y+=velocityY;
		if(x<=0) velocityX*=-1;
		if(x>=Game.WIDTH-16) velocityX*=-1;
		if(y<=0) velocityY*=-1;
		if(y>=Game.HEIGHT-40){velocityY*=-1;Game.gameOver();}
		rect.x=x;
		rect.y=y;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, 16, 16);
	}

	
}
