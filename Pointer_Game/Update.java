
public class Update {
	
	
	public static void Projectile(Projectile[] p){
		int length = 1500;
		int width = Zen.getZenWidth();
		int height = Zen.getZenHeight();
		for(int i=0; i<p.length; i++)
			if (width/2-Math.abs(width/2 - p[i].posx) < 0 || height/2-Math.abs(height/2 -p[i].posy) < 0)
    				p = Projectile.remove(p, i);
		for(int i = 0; i < p.length; i++){
			p[i].posx+=p[i].velx;
			p[i].posy+=p[i].vely;
			if (Math.abs((width/2-p[i].posx)*(width/2-p[i].posx)+(height/2-p[i].posy)*(height/2-p[i].posy)) > length){
				p[i].posx2+=p[i].velx;
				p[i].posy2+=p[i].vely;
			}
		}
		Pointer_Game.p = p;
	}
	public static boolean Collision(Projectile[] p, Enemy[] e){
		for(int i=0; i<e.length; i++){
			for(int j=0;j<p.length; j++)
				if(p[j].posx > e[i].posx-15 && p[j].posx < e[i].posx+15 && p[j].posy > e[i].posy-25&& p[j].posy < e[i].posy+20){
					Pointer_Game.p= Projectile.remove(Pointer_Game.p, j);
					if(Pointer_Game.e.length > 0) Pointer_Game.e = Enemy.remove(Pointer_Game.e, i);
					Pointer_Game.score++;
					
				}
			if(e[i].posx > 240 && e[i].posx < 260 && e[i].posy > 240 && e[i].posy < 260)
				return true;
		}
		return false;
	}
	public static void PowerUp(Projectile[] p){
		for(int i=0; i<p.length; i++)
			if(p[i].posx > Pointer_Game.pu.posx-15 && p[i].posx < Pointer_Game.pu.posx+15 && p[i].posy > Pointer_Game.pu.posy-25&& p[i].posy < Pointer_Game.pu.posy+20){
				Pointer_Game.powertimer = 10000;
				Pointer_Game.p = Projectile.remove(Pointer_Game.p, i);
				Pointer_Game.pu.posx = -1;
				Pointer_Game.pu.posy = -1;
				
			}
	}
	public static void Enemy(Enemy[] e){
		for(int i = 0; i < e.length; i++){
			e[i].posx+=e[i].velx*Pointer_Game.score*.04;
			e[i].posy+=e[i].vely*Pointer_Game.score*.04;
		}
	}
	public static void Wave(Projectile[] p){
		for(int i=0; i<p.length; i++)
			if(p[i].posx > Pointer_Game.w.posx-15 && p[i].posx < Pointer_Game.w.posx+15 && p[i].posy > Pointer_Game.w.posy-25&& p[i].posy < Pointer_Game.w.posy+20){
				Pointer_Game.powertimer2 = 10000;
				Pointer_Game.wavetimer = 600;
				Pointer_Game.p = Projectile.remove(Pointer_Game.p, i);
				Pointer_Game.w.posx = -1;
				Pointer_Game.w.posy = -1;
			}
	
	}
	public static void WaveEffect(Enemy[] e){
		for(int i=0; i < e.length; i++)
			if((e[i].posx-10)*(e[i].posx-10)+(e[i].posy-10)*(e[i].posy-10) < (Pointer_Game.w.radius+20)*(Pointer_Game.w.radius+20)){
				Pointer_Game.e = Enemy.remove(Pointer_Game.e, i);
				Pointer_Game.score++;
			}
	}
}