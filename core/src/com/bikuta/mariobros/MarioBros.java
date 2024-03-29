package com.bikuta.mariobros;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bikuta.mariobros.screens.PlayScreen;

public class MarioBros extends Game {

	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static final float PPM = 100; //Pixels por metro

	public static final short GROUND_BIT = 1;
	public static final short MARIO_BIT = 2;
	public static final short BRICK_BIT = 4;
	public static final short COIN_BIT = 8;
	public static final short DESTROYED_BIT = 16;
	public static final short OBJECT_BIT = 32;
	public static final short ENEMY_BIT = 64;
	public static final short ENEMY_HEAD_BIT = 128;

	private SpriteBatch batch;

	private boolean debugMode = false;

	// Passar o assetManager como parametro, deixar como static pode causar erros
	private AssetManager assetManager;

	public SpriteBatch getBatch(){
		return this.batch;
	}

	public AssetManager getAssetManager(){
		return this.assetManager;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		assetManager = new AssetManager();
		assetManager.load("audio/music/mario_music.ogg", Music.class);
		assetManager.load("audio/sounds/breakblock.wav", Sound.class);
		assetManager.load("audio/sounds/bump.wav", Sound.class);
		assetManager.load("audio/sounds/coin.wav", Sound.class);
		assetManager.load("audio/sounds/mariodie.wav", Sound.class);
		assetManager.load("audio/sounds/powerdown.wav", Sound.class);
		assetManager.load("audio/sounds/powerup.wav", Sound.class);
		assetManager.load("audio/sounds/powerup_spawn.wav", Sound.class);
		assetManager.load("audio/sounds/stomp.wav", Sound.class);
		assetManager.load("audio/sounds/jump.wav", Sound.class);
		assetManager.finishLoading();

		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
		assetManager.update();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
		assetManager.dispose();
	}

	public boolean getDebugMode(){
	    return debugMode;
    }

    public void setDebugMode(boolean debugMode){
	    this.debugMode = debugMode;
    }
}
