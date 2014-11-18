package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.game.src.main.classes.EntityB;
import com.game.src.main.libs.Animation;

public class Enemy extends GameObject implements EntityB {
	
	private Textures tex;
	Random r = new Random();
	private Game game;
	private Controller c;
	
	private int speed = r.nextInt(3) + 1;
	
	Animation anim;
	
	public Enemy(double x, double y, Textures tex, Controller c, Game game) {
		super(x, y);
		this.tex = tex;
		this.c = c;
		this.game = game;
		
		anim = new Animation(5, tex.enemy[0], tex.enemy[1], tex.enemy[2]);
	}
	
	public void tick() {
		y += speed; //different speeds
		
		if(y > Game.HEIGHT * Game.SCALE) {
			speed = r.nextInt(3) + 1; //rate for coming back up
			x = r.nextInt(640);
			y = -10;
		}
		
		if(Physics.Collision(this, game.ea)) {
			c.removeEntity(this);
			//once enemy is killed off,
			game.setEnemy_killed(game.getEnemy_killed() + 1);
		}
		
		anim.runAnimation();
		
	}
	
	public void render(Graphics g) {
		anim.drawAnimation(g, x, y, 0); //0 is the offset
		//g.drawImage(tex.enemy[0], (int) x, (int) y, null);
		
	}
	
	//construct rectangle around player
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}

	
	public double getX() {
		return x;
	}

}
