package models.Map.Tile;

import models.AreaEffect.AreaEffect;
import models.Entity.Entity;
import models.Item.TakeableItem;

/**
 *
 */
public abstract class Tile {
    /* Attributes */
    protected int height;
    protected Tile bottomTile;
    protected Tile topTile;
    protected Tile northTile;
    protected Tile southTile;
    protected Tile southEastTile;
    protected Tile northEastTile;
    protected Tile southWestTile;
    protected Tile northWestTile;

    protected Entity entity;
    protected TakeableItem item;
    protected AreaEffect areaEffect;

    /* Constructor */
    public Tile(){
        height = 1;
        bottomTile = topTile = northTile =southTile = southEastTile =southWestTile = northEastTile = northWestTile = null;
        entity = null;
        item = null;
        areaEffect = null;
    }

    public Tile(Tile bottomTile , Tile topTile , Tile northTile , Tile southTile , Tile southEastTile , Tile southWestTile , Tile northEastTile , Tile northWestTile , Entity entity , TakeableItem item , AreaEffect areaEffect){
        this.bottomTile = bottomTile;
        this.topTile = topTile;
        this.northTile = northTile;
        this.southTile = southTile;
        this.southEastTile = southEastTile;
        this.southWestTile = southWestTile;
        this.northEastTile = northEastTile ;
        this.northEastTile = northWestTile;

        this.entity  = entity;
        this.item = item;
        this.areaEffect = areaEffect;

        if(bottomTile != null){
            this.height = bottomTile.getHeight() + 1;
        }else{
            this.height = 1;
        }
    }
    /* Methods */
    public abstract void sendEntityNorth();
    public abstract void sendEntitySouth();
    public abstract void sendEntitySouthEast();
    public abstract void sendEntitySouthWest();
    public abstract void sendEntityNorthEast();
    public abstract void sendEntityNorthWest();

    public abstract Boolean receiveEntityFromNorth(Entity entity);
    public abstract Boolean receiveEntityFromSouth(Entity entity);
    public abstract Boolean receiveEntityFromSouthEast(Entity entity);
    public abstract Boolean receiveEntityFromSouthWest(Entity entity);
    public abstract Boolean receiveEntityFromNorthEast(Entity entity);
    public abstract Boolean receiveEntityFromNorthWest(Entity entity);

    public int getHeight(){
        return this.height;
    }


    public void update(){
        if(entity != null) {
            if (areaEffect != null) {
                areaEffect.activate(entity.getStats());
            }
            if (item != null) {
                item.activate(entity);
            }
        }
    }
    

}
