import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x, y;
	protected ID id;
	protected int velocityX, velocityY;
	protected int Speed;
	protected Rectangle rect;
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVelX(int x){
		velocityX=x;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public ID getID() {
		return id;
	}
}
