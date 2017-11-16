package gravity_game.object;

import com.sun.istack.internal.Nullable;
import gravity_game.world.World;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ObjectRegistry {
    private static ArrayList<Class<? extends GameObject>> registeredObjects;
    static {
        registeredObjects = new ArrayList<>();

        registeredObjects.add(Planet.class);
        registeredObjects.add(Player.class);
    }

    @Nullable
    public static GameObject spawn(int id, World world){
        if(id<0||id>=registeredObjects.size())return null;

        GameObject object = null;
        try {
            object = (GameObject) registeredObjects.get(id).getDeclaredConstructors()[0].newInstance(world);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.err.println("Object of ID: " + id + " does not exist.");
        }
        return object;
    }

    public static int getIdFor(Class<? extends GameObject> objectClass){
        return registeredObjects.indexOf(objectClass);
    }
}