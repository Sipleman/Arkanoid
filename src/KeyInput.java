import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	Handler handler;
	
	public KeyInput(Handler handler){
		this.handler=handler;
	}
	
	public void keyPressed(KeyEvent key){
		int k = key.getKeyCode();
		if(k==KeyEvent.VK_LEFT){
			handler.Player.setVelX(-handler.Player.Speed);
			return;
		}
		if(k==KeyEvent.VK_RIGHT){
			handler.Player.setVelX(handler.Player.Speed);
			return;
		}
	}
	public void keyReleased(KeyEvent key){
		int k = key.getKeyCode();
		if(k == KeyEvent.VK_LEFT){
			handler.Player.setVelX(0);
			return;
		}
		if(k == KeyEvent.VK_RIGHT){
			handler.Player.setVelX(0);
			return;
		}
		
	}
}
