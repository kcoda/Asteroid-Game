
public class Enemy {
	public double posx;
	public double posy;
	public double velocity = .01;
	public double velx;
	public double vely;
	
	public Enemy(){
		this.posx = Zen.getZenWidth()*Math.random();
		this.posy = Zen.getZenHeight()*Math.random();
		if (posx > 200 && posx < 300 && posy > 200 && posy < 300){
			while(posx > 200 && posx < 300 && posy > 200 && posy < 300){
				this.posx = (Zen.getZenWidth()+200)*Math.random()-100;
				this.posy = (Zen.getZenHeight()+200)*Math.random()-100;
			}
		}
		double ratio = (Zen.getZenWidth()/2-posx)/(Zen.getZenHeight()/2-posy);		
		if(posy < Zen.getZenHeight()/2) 
			this.vely = (velocity/(Math.sqrt(ratio*ratio+1)));
		else 
			this.vely = -(velocity/(Math.sqrt(ratio*ratio+1)));
		this.velx = (this.vely*ratio); 
		if (posy == Zen.getZenHeight()/2){
			this.vely = 0;
			if( posx > Zen.getZenWidth()/2)
				this.velx = -velocity;
			else this.velx = velocity;
		}
	}

	public static Enemy[] add(Enemy[] oldlist, Enemy e){
		int size = oldlist.length;
		Enemy[] newlist = new Enemy[size+1];
		for(int i=0; i < size; i++)
			newlist[i] = oldlist[i];
		newlist[size] = e;
		return newlist;
	}
	
	public static Enemy[] remove(Enemy[] oldlist, int index){
		int size = oldlist.length;
		Enemy[] newlist = new Enemy[size-1];
		for(int i=0; i < index; i ++)
			newlist[i] = oldlist[i];
		for(int i=index; i < newlist.length; i ++)
			newlist[i] = oldlist[i+1];
		return newlist;
		
	}
}
