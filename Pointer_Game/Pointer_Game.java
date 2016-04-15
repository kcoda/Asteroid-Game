
public class Pointer_Game {
	
	public static Projectile[] p = new Projectile[0];
	public static Enemy[] e = new Enemy[0];
	public static int powertimer = 0;
	public static int powertimer2 = 0;
	public static int wavetimer = 0;
	public static PowerUp pu = new PowerUp(-1, -1);
	public static int score = 0;
	public static Wave w = new Wave(-1, -1);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Zen.create(500,500,"Pointer");
		Zen.flipBuffer();
		int x = Zen.getZenWidth();
		int y = Zen.getZenHeight();
		int h = y;
		int width = x;
		int shoottimer = 0;
		double random = 0;
		
		
		while(true){			
			x = Zen.getMouseX();
			y = Zen.getMouseY();
			random = Math.random();
			if (Zen.isKeyPressed(' ') && shoottimer == 0){			
			  p = Projectile.add(p, new Projectile(x, y));
			  if (powertimer > 0)			  
				  shoottimer = 100;
			  else shoottimer = 400;
			}
			if (random < .001)
				e = Enemy.add(e, new Enemy());
			if (powertimer == 0 && random > .99999){
				pu.posx = (int)(Math.random()*(width-40)+20);
				pu.posy = (int)(Math.random()*(h-40)+20);
			}
			if (powertimer2 == 0 && random < .00001){
				w.radius = 0;
				w.posx = (int)(Math.random()*(width-40)+20);
				w.posy = (int)(Math.random()*(h-40)+20);
			}
			Update.Projectile(p);
			
			Update.Enemy(e);
			if(wavetimer > 0){
				Display.WaveEffect(w.radius);
				w.radius+=1;
				wavetimer--;
				Update.WaveEffect(e);
			}
			Display.Projectile(p);
			if(powertimer == 0 && pu.posx > 0)
				Display.PowerUp(pu.posx, pu.posy);	
			if(powertimer2 == 0 && w.posx > 0)
				Display.Wave((int)w.posx, (int)w.posy);
			Display.Player(x, y);
			Display.Enemy(e);
			Zen.drawText("Score: "+ score, 400, 20);
			if(Update.Collision(p, e)) break;			
			if (shoottimer > 0)
				shoottimer--;
			if(powertimer > 0)
				powertimer--;
			if(powertimer2 > 0)
				powertimer2--;
			
			if (pu.posx > 0)
				Update.PowerUp(p);
			if(w.posx > 0)
				Update.Wave(p);
			if(Zen.isKeyPressed('q'))
				break;
			Zen.flipBuffer();
		}
		Zen.setFont("Times New Roman - 48");
		Zen.drawText("Game Over", 130, 230);
		Zen.flipBuffer();
	}

}
