import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> list;
	LinkedList<GameObject> blocks = new LinkedList<GameObject>();
	
	GameObject Player;
	
	public void tick() {
		for (int i = 0; i < list.size(); i++) {
			GameObject temp = list.get(i);
			temp.tick();
			if(temp.id==ID.Ball){
				if(temp.rect.intersects(Player.rect)){
					temp.velocityX*=1;
					temp.velocityY*=-1;
				}
				for(int j=0;j<blocks.size();j++){
					if(temp.rect.intersects(blocks.get(j).rect)){
						System.out.println(temp.rect.x + " " + temp.rect.y);
						System.out.println(blocks.get(j).rect.x + " " + blocks.get(j).rect.y );
						blocks.remove(j);
						temp.velocityY*=-1;				
					}
				}
			}
		}
		for(int i=0;i<blocks.size();i++){
			GameObject temp = blocks.get(i);
			temp.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < list.size(); i++) {
			GameObject temp = list.get(i);
			temp.render(g);
		}
		for(int i=0;i<blocks.size();i++){
			GameObject temp = blocks.get(i);
			temp.render(g);
		}
	}

	public Handler() {
		list = new LinkedList<GameObject>();
		
	}

	public void add(GameObject obj) {
		list.add(obj);
		if(obj.id==ID.Racket) Player = list.getLast();
	}
	public void addBlock(GameObject obj){
		blocks.add(obj);
		
	}
	public void remove(int i) {
		list.remove(i);
	}
}
