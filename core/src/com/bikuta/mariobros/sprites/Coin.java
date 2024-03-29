package com.bikuta.mariobros.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.bikuta.mariobros.MarioBros;
import com.bikuta.mariobros.scenes.Hud;
import com.bikuta.mariobros.screens.PlayScreen;

public class Coin extends InteractiveTileObject {

    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 28;

    public Coin(PlayScreen screen, Rectangle bounds, AssetManager assetManager) {
        super(screen, bounds, assetManager);
        tileSet = tiledMap.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.COIN_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Coin", "Collision");
        if (getCell().getTile().getId() == BLANK_COIN){
            assetManager.get("audio/sounds/bump.wav", Sound.class).play();
        }else{
            setCategoryFilter(MarioBros.GROUND_BIT);
            getCell().setTile(tileSet.getTile(BLANK_COIN));
            Hud.addScore(200);
            assetManager.get("audio/sounds/coin.wav", Sound.class).play();
        }

    }
}
