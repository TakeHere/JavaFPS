package core.objects;

import core.objects.entities.Entity;
import core.objects.models.ModelTexture;
import core.objects.models.RawModel;
import core.objects.models.TexturedModel;
import core.objects.models.objloader.OBJFileLoader;
import core.toolbox.Loader;
import org.joml.Vector3f;

public class EntityCreator {

    public static Entity createEntity(Loader loader, String modelPath, String texturePath, Vector3f position, Vector3f rotation, Vector3f scale){
        try {
            RawModel rawModel = OBJFileLoader.loadOBJ(modelPath, loader);
            ModelTexture texture = new ModelTexture(loader.loadTexture(texturePath));

            TexturedModel texturedModel = new TexturedModel(rawModel, texture);

            return new Entity(texturedModel, position, rotation, scale);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}