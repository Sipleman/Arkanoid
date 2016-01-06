import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends GameObject {

	int w=46,h=23;
	public Block(int x, int y, ID id) {
		super(x, y, id);
		rect = new Rectangle(x, y, w, h);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}

	
}
