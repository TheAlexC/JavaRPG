package views;


import models.Buff.Buff;

import java.awt.image.BufferedImage;


/**
 * Implemented by Peter Camejo
 */
public class Assets {
    private static final int width = 80, height = 80;

    /* Weapons */
    public static BufferedImage oneHand;
    public static BufferedImage dagger;
    public static BufferedImage twoHand;
    public static BufferedImage fist;
    public static BufferedImage ranged;
    public static BufferedImage staff;

    /* Armor */
    public static BufferedImage headArmor;
    public static BufferedImage chestArmor;
    public static BufferedImage legArmor;
    public static BufferedImage gloveArmor;
    public static BufferedImage bootArmor;
    public static BufferedImage trinket;

    /* Potions */
    public static BufferedImage healthPotion;
    public static BufferedImage manaPotion;
    public static BufferedImage strengthPotion;
    public static BufferedImage intellectPotion;
    public static BufferedImage agilityPotion;
    public static BufferedImage experiencePotion;

    /* Terrain */
    public static BufferedImage grassTerrain;
    public static BufferedImage mountainTerrain;
    public static BufferedImage airTerrain;

    /* Interactive Item */
    public static BufferedImage itemChest;
    public static BufferedImage door;

    /* Misc Items */
    public static BufferedImage chestKey;
    public static BufferedImage doorKey;

    /* Tiles */
    public static BufferedImage grassTile;
    public static BufferedImage waterTile;

    /* Obstacles */
    public static BufferedImage boulder;

    /* Area Effects */
    public static BufferedImage healingAreaEffect;
    public static BufferedImage damageAreaEffect;

    /* Methods */
    public static void init() {


        SpriteSheet oneHandSheet = new SpriteSheet(new ImageLoader().loadImage("/oneHand.png"));
        SpriteSheet daggerSheet = new SpriteSheet(new ImageLoader().loadImage("/dagger.png"));
        SpriteSheet staffSheet = new SpriteSheet(new ImageLoader().loadImage("/staff.png"));
/*        SpriteSheet twoHandSheet = new SpriteSheet(new ImageLoader().loadImage("/twoHand.png"));
        SpriteSheet fistSheet = new SpriteSheet(new ImageLoader().loadImage("/fist.png"));
        SpriteSheet rangedSheet = new SpriteSheet(new ImageLoader().loadImage("/ranged.png"));

        SpriteSheet headArmorSheet = new SpriteSheet(new ImageLoader().loadImage("/headArmor.png"));
        SpriteSheet chestArmorSheet = new SpriteSheet(new ImageLoader().loadImage("/chestArmor.png"));
        SpriteSheet legArmorSheet = new SpriteSheet(new ImageLoader().loadImage("/legArmor.png"));
        SpriteSheet gloveArmorSheet = new SpriteSheet(new ImageLoader().loadImage("/gloves.png"));
        SpriteSheet bootArmorSheet = new SpriteSheet(new ImageLoader().loadImage("/bootArmor.png"));
        SpriteSheet trinketSheet = new SpriteSheet(new ImageLoader().loadImage("/trinket.png"));
*/
        SpriteSheet healthPotionSheet = new SpriteSheet(new ImageLoader().loadImage("/healthPotion.png"));
/*        SpriteSheet manaPotionSheet = new SpriteSheet(new ImageLoader().loadImage("/manaPotion.png"));
        SpriteSheet strengthPotionSheet = new SpriteSheet(new ImageLoader().loadImage("/strengthPotion.png"));
        SpriteSheet intellectPotionSheet = new SpriteSheet(new ImageLoader().loadImage("/intellectPotion.png"));
        SpriteSheet agilityPotionSheet = new SpriteSheet(new ImageLoader().loadImage("/agilityPotion.png"));
        SpriteSheet experiencePotionSheet = new SpriteSheet(new ImageLoader().loadImage("/experiencePotion.png"));

        SpriteSheet itemChestSheet = new SpriteSheet(new ImageLoader().loadImage("/itemChest.png"));
        SpriteSheet doorSheet = new SpriteSheet(new ImageLoader().loadImage("/door.png"));

  */      SpriteSheet chestKeySheet = new SpriteSheet(new ImageLoader().loadImage("/chestKey.png"));
        SpriteSheet doorKeySheet = new SpriteSheet(new ImageLoader().loadImage("/doorKey.png"));

        SpriteSheet grassTileSheet = new SpriteSheet(new ImageLoader().loadImage("/grassTile.jpg"));
        SpriteSheet waterTileSheet = new SpriteSheet(new ImageLoader().loadImage("/waterTile.jpg"));

        SpriteSheet boulderSheet = new SpriteSheet(new ImageLoader().loadImage("/boulder.png"));

        SpriteSheet healingAreaEffectSheet = new SpriteSheet(new ImageLoader().loadImage("/healingAreaEffect.png"));
        SpriteSheet damageAreaEffectSheet = new SpriteSheet(new ImageLoader().loadImage("/damageAreaEffect.png"));

        oneHand = oneHandSheet.crop(0, 0, width, height);
        dagger = daggerSheet.crop(0 , 0 ,width , height);
        staff = staffSheet.crop(0, 0, width, height);
/*        twoHand = twoHandSheet.crop(0, 0, width, height);
        fist = fistSheet.crop(0, 0, width, height);
        ranged = rangedSheet.crop(0, 0, width, height);

        headArmor = headArmorSheet.crop(0, 0, width, height);
        chestArmor = chestArmorSheet.crop(0, 0, width, height);
        legArmor = legArmorSheet.crop(0, 0, width, height);
        gloveArmor = gloveArmorSheet.crop(0, 0, width, height);
        bootArmor = bootArmorSheet.crop(0, 0, width, height);
        trinket = trinketSheet.crop(0, 0, width, height);
*/
        healthPotion = healthPotionSheet.crop(0, 0, width, height);
 /*       manaPotion = manaPotionSheet.crop(0, 0, width, height);
        strengthPotion = strengthPotionSheet.crop(0, 0, width, height);
        intellectPotion = intellectPotionSheet.crop(0, 0, width, height);
        agilityPotion = agilityPotionSheet.crop(0, 0, width, height);
        experiencePotion = experiencePotionSheet.crop(0, 0, width, height);

        itemChest = itemChestSheet.crop(0, 0, width, height);
        door = doorSheet.crop(0, 0, width, height);

        chestKey = chestKeySheet.crop(0, 0, width, height);*/
        doorKey = doorKeySheet.crop(0, 0, width, height);

        grassTile = grassTileSheet.crop(0 , 0 , width , height);
        waterTile = waterTileSheet.crop(0 , 0 , width , height);

        boulder = boulderSheet.crop(0 , 0 , width , height);

        healingAreaEffect = healingAreaEffectSheet.crop(0 , 0 , width , height);
        damageAreaEffect = damageAreaEffectSheet.crop(0 , 0 , width , height);
    }
}
