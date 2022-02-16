package core.objects.entities;

import core.listeners.KeyListener;
import core.listeners.MouseListener;
import core.objects.models.TexturedModel;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

public class Player extends Entity{

    //private static final float RUN_SPEED = 30;
    private static final float RUN_SPEED = 0.5f;
    private static final float TURN_SPEED = 3;
    private static final float JUMP_FORCE = 1.5f;

    private static final float TERRAIN_HEIGHT = 0;

    public Player(TexturedModel model, Vector3f position, Vector3f rotation, Vector3f scale) {
        super(model, position, rotation, scale);
        useGravity = true;
    }

    public Player(Entity entity){
        super(entity.getModel(), entity.getPosition(), entity.getRotation(), entity.getScale());
        useGravity = true;
    }

    boolean grounded = true;

    public void move(double deltaTime){
        float playerAngle = getRotation().y;

        Vector2f forwardVector = new Vector2f((float) Math.sin(Math.toRadians(playerAngle)), (float) Math.cos(Math.toRadians(playerAngle))).normalize();
        Vector2f rightVector = new Vector2f((float) Math.sin(Math.toRadians(playerAngle - 90)), (float) Math.cos(Math.toRadians(playerAngle - 90))).normalize();

        int vertical = 0;
        int horizontal = 0;

        if(KeyListener.isKeyPressed(GLFW.GLFW_KEY_W)){
            horizontal = 1;
        }else if (KeyListener.isKeyPressed(GLFW.GLFW_KEY_S)){
            horizontal = -1;
        }

        if(KeyListener.isKeyPressed(GLFW.GLFW_KEY_D)){
            vertical = 1;
        }else if (KeyListener.isKeyPressed(GLFW.GLFW_KEY_A)){
            vertical = -1;
        }

        Vector2f move = forwardVector.mul(horizontal).add(rightVector.mul(vertical));
        move.mul(RUN_SPEED);
        velocity = new Vector3f(move.x, velocity.y, move.y);

        if (KeyListener.isKeyPressed(GLFW.GLFW_KEY_SPACE)){
            if (grounded){
                velocity.y += JUMP_FORCE;
                grounded = false;
            }
        }

        if (getPosition().y < TERRAIN_HEIGHT){
            grounded = true;
            velocity = new Vector3f(velocity.x, 0, velocity.z);
            getPosition().y = TERRAIN_HEIGHT;
        }
    }
}