
public class Projectile {

	double posx = Zen.getZenWidth()/2;
	double posy = Zen.getZenHeight()/2;
	double posx2 = Zen.getZenWidth()/2;
	double posy2 = Zen.getZenWidth()/2;
	double vely = 0;
	double velx = 0;
	double inclination = 0;

	public Projectile(double x, double y){
		double velocity = .5;
		double ratio = (Zen.getZenWidth()/2-x)/(Zen.getZenHeight()/2-y);		
		if(y < Zen.getZenHeight()/2) 
			this.vely = -(velocity/(Math.sqrt(ratio*ratio+1)));
		else 
			this.vely = (velocity/(Math.sqrt(ratio*ratio+1)));
		this.velx = (this.vely*ratio); 
		if (y == Zen.getZenHeight()/2){
			this.vely = 0;
			if( x > Zen.getZenWidth()/2)
				this.velx = velocity;
			else 
				this.velx = -velocity;
		}
		this.inclination = 1/ratio;
		posx2+= velx*40;
		posy2+= vely*40;
		posx+= velx*40;
		posy+= vely*40;
		
	}
	
	public static Projectile[] add(Projectile[] oldlist, Projectile p){
		int size = oldlist.length;
		Projectile[] newlist = new Projectile[size+1];
		for(int i=0; i < size; i++)
			newlist[i] = oldlist[i];
		newlist[size] = p;
		return newlist;
	}
	
	public static Projectile[] remove(Projectile[] oldlist, int index){
		int size = oldlist.length;
		Projectile[] newlist = new Projectile[size-1];
		for(int i=0; i < index; i ++)
			newlist[i] = oldlist[i];
		for(int i=index; i < newlist.length; i ++)
			newlist[i] = oldlist[i+1];
		return newlist;
		
	}
}
