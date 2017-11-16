package gravity_game.game_engine;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyMap {
    private HashMap<Integer, String> keyBinds;
    public KeyMap(){
        keyBinds = new HashMap<>();
    }

    public void load(DataStorage dataStorage){
        keyBinds.put((int) dataStorage.getData(0), "up");
        keyBinds.put((int) dataStorage.getData(1), "right");
        keyBinds.put((int) dataStorage.getData(2), "left");

    }

    public void loadDefaults(){
        keyBinds.put(KeyEvent.VK_SPACE, "up");
        keyBinds.put(KeyEvent.VK_D, "right");
        keyBinds.put(KeyEvent.VK_A, "left");
    }

    public String get(int key){
        return keyBinds.get(key);
    }
}
