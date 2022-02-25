package core;

import core.sound.AudioMaster;
import core.toolbox.Vector3;

public class Consts {
    public static final Vector3 positionOffset = new Vector3(-3,-5 + 30,3);
    public static final float GRAVITY = -5;
    public static final float BULLET_GRAVITY = -1;
    public static final float radConst = (float) (Math.PI/180);

    public static int MAX_TARGETS = 10;

    //Sounds
    public static int BREAK_SOUND = AudioMaster.loadSound("res/sounds/break.wav");
    public static int AMBIENT_SOUND = AudioMaster.loadSound("res/sounds/ambient.wav");
    public static int SHOOT_SOUND = AudioMaster.loadSound("res/sounds/shoot.wav");
}
