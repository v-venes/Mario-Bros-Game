package com.bikuta.mariobros.sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class Brick extends InteractiveTileObject {
    public Brick(World world, TiledMap tiledMap, Rectangle bounds) {
        super(world, tiledMap, bounds);
    }
}
