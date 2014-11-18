package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.classes.EntityA;
import com.game.src.main.libs.Animation;

public class Bullet extends GameObject implements EntityA {
	
	private Textures tex;
	private Game game;
	
	Animation anim;
	
	public Bullet(double x, double y, Textures tex, Game game) {
		super(x, y);
		this.tex = tex;
		this.game = game;
		
		anim = new Animation(5, tex.missile[0], tex.missile[1], tex.missile[2]);
	}
	
	public void tick() {
		y -= 10;
				
		anim.runAnimation();
	}
	
	//construct rectangle around player
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}
	
	public void render(Graphics g) {
		anim.drawAnimation(g, x, y, 0);
		//g.drawImage(tex.missile[0], (int) x, (int) y, null);
	}
	
	public double getY() {
		return y;
	}

	
	public double getX() {
		return x;
	}
}

	