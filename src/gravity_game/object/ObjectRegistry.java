package gravity_game.object;

import java.util.ArrayList;

public class ObjectRegistry {
    private static ArrayList<Class<? extends GameObject>> registeredObjects;
    static {
        registeredObjects = new ArrayList<>();

        registeredObjects.add(Planet.class);

    }

    public static GameObject spawn(int id){
        GameObject object = null;
        try {
            object = registeredObjects.get(id).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static int getIdFor(Class<? extends GameObject> objectClass){
        return registeredObjects.indexOf(objectClass);
    }
}