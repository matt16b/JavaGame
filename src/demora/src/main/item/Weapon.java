package main.item;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public class Weapon extends Item {

	double weaponX, weaponY;
	int wID;
	
	public Weapon(int nID) {
		super(nID);
	}

	public void destroy() {
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	public void move(double nx, double ny) {
		// TODO Auto-generated method stub
		
	}

	public void damage() {
		// TODO Auto-generated method stub
		
	}

	public void setAnimation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setImg() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void init(int nx, int ny, boolean tilewise) {
		weaponX = nx;
		weaponY = ny;
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getShadowCasterImg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getAng() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getImgOffsetX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getImgOffsetY() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int collect(int x, int y) {
		if(weaponX == x && weaponY == y){
			return Weapon.super.getID();
		}
		else{
			return -1;
		}
	}

}
