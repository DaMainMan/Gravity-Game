package gravity_game.game_engine;

import java.util.ArrayList;

public class DataStorage {
    private ArrayList<DataStorage> subStorages;
    private ArrayList<Double> data;
    public DataStorage(){
        subStorages = new ArrayList<>();
        data = new ArrayList<>();
    }

    public DataStorage(String data){
        this();
        parse(data);
    }

    private void parse(String data){
        int index = data.indexOf('(');
        String[] split = data.substring(0, index).split("/");
        for(String num : split){
            this.data.add(Double.parseDouble(num));
        }
        parseSub(data.substring(index));
    }

    private void parseSub(String sub){
        int levels = 0, beginIndex = 0;
        for (int i = 0; i < sub.length(); i++) {
            char character = sub.charAt(i);
            if(character=='('){
                levels++;
                beginIndex = i;
            }
            else if(character==')'){
                levels--;
                if(levels==0){
                    subStorages.add(new DataStorage(sub.substring(beginIndex, i)));
                }
            }
        }
    }

    public double getData(int index){
        return data.get(index);
    }

    public DataStorage getSubStorage(int index){
        return subStorages.get(index);
    }

    public String toString(){
        String out = "";
        for(double num : data){
            out += num + "/";
        }
        for(DataStorage storage : subStorages){
            out += "(" + storage.toString() + ")/";
        }
        return out;
    }
}