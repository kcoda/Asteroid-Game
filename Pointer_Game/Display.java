
public class Display {

	public static void Projectile(Projectile[] p){
		for(int i=0; i< p.length; i++){
			Zen.drawLine((int)p[i].posx, (int)p[i].posy, (int)p[i].posx2, (int)p[i].posy2);
		}	
	}
	
	public static void Player(double x, double y){
		int height = Zen.getZenHeight();
		int width = Zen.getZenWidth();
		double ratio = (height/2-y)/(width/2-x);			
		double x1 = 20/Math.sqrt(1+ratio*ratio);		
		if(x < width/2)
			x1 = -x1;		
		double y1 = ratio*x1;	
		if(x == width/2)
			if(y<height/2)
				y1 = -20;
			else y1 = 20;
		double x2 = 10/Math.sqrt(1+1/(ratio*ratio));
		double y2 = -x2/ratio; 
		Zen.drawLine((int)x1+width/2, (int)y1+height/2, (int)-x2+width/2, (int)-y2+height/2);
		Zen.drawLine((int)x1+width/2, (int)y1+height/2, (int)x2+width/2, (int)y2+height/2);
		Zen.drawLine((int)-x2+width/2, (int)-y2+height/2, (int)x2+width/2, (int)y2+height/2);		
	}
	public static void Enemy(Enemy[] e){
		for(int i=0; i< e.length; i++)
			Zen.fillOval((int)e[i].posx, (int)e[i].posy, 20, 20);
	}
	public static void PowerUp(int x, int y){
		Zen.fillRect(x, y, 20, 20);
		Zen.setColor(0, 0, 0);
		Zen.fillRect(x+2, y+2, 16, 16);
		Zen.setColor(255,255,255);		
	}
	public static void Wave(int x, int y){
		Zen.fillOval(x, y, 20, 20);
		Zen.setColor(0,0,0);
		Zen.fillOval(x+2, y+2, 16, 16);
		Zen.setColor(255, 255, 255);
	}
	public static void WaveEffect(int r){
		Zen.fillOval(250-(r/2), 250-(r/2), r, r);
		Zen.setColor(0,0,0);
		Zen.fillOval(250-(r/2)+3, 250-(r/2)+3, r-6, r-6);
		Zen.setColor(255, 255, 255);
		
	}

	}
