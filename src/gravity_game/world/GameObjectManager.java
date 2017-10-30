package gravity_game.world;

import gravity_game.object.GameObject;

import java.awt.*;
import java.util.ArrayList;

public class GameObjectManager {
    private ArrayList<GameObject> objects, addedObjects, removedObjects;
    public GameObjectManager(){
        objects = new ArrayList<>();
        addedObjects = new ArrayList<>();
        removedObjects = new ArrayList<>();
    }

    public void add(GameObject object){
        addedObjects.add(object);
    }

    public void remove(GameObject object) {
        removedObjects.add(object);
    }

    public void tick(){
        objects.addAll(addedObjects);
        objects.removeAll(removedObjects);
        addedObjects.clear();
        removedObjects.clear();
        for(GameObject object : objects){
            object.tick();
        }
    }

    public void render(Graphics g){
        for(GameObject object : objects){
            object.render(g);
        }
    }
}
