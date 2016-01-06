import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 640, HEIGHT = 448;

	private boolean running = true;

	private Color backgroundColor = Color.white;

	private Thread thread;
	private Handler handler;

	public Game() {

		handler = new Handler();
		Window window = new Window(WIDTH, HEIGHT, this);
		
		this.addKeyListener(new KeyInput(handler));
		window.setFocusable(true);
		
		Racket r = new Racket(Game.WIDTH / 2, Game.HEIGHT - 64, ID.Racket);
		Ball b = new Ball(Game.WIDTH/2,Game.HEIGHT/2,ID.Ball);
		for(int i=0;i<Game.WIDTH/48;i++){
			for(int j=0;j<5;j++){
				int k=1;
				Block block = new Block(48*i+6,23*j+k*j+5,ID.Block);
				handler.addBlock(block);
			}
		}
		
		handler.add(r);
		handler.add(b);

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
	}

	private void tick() {
		handler.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(backgroundColor);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);

		g.dispose();

		bs.show();
	}

	public static void main(String args[]) {
		Game game = new Game();
	}
}
