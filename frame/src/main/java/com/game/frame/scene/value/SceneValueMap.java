package com.game.frame.scene.value;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by devuser1 on 2016/9/28.
 */

public class SceneValueMap {
    private static SceneValueMap self;
    private  Map<String, Object> values;

    public SceneValueMap() {
        values = new HashMap<String, Object>();
    }

    public void cleanAllValues() {
        values.clear();
    }

    public void remove(String pKey) {
        values.remove(pKey);
    }

    public boolean containsKey(String pKey) {
        return values.containsKey(pKey);
    }

    public void setInt(String pKey, int pIntValue) {
        values.put(pKey, pIntValue);
    }

    public int getInt(String pKey) {
        return (int) (values.get(pKey));
    }

    public void setFloat(String pKey, float pFlaotValue) {
        values.put(pKey, pFlaotValue);
    }

    public float getFloat(String pKey) {
        return (float) (values.get(pKey));
    }

    public void setEnum(String pKey, Enum pEnumValue) {
        values.put(pKey, pEnumValue);
    }

    public Enum getEnum(String pKey) {
        return (Enum) (values.get(pKey));
    }

    public void setObject(String pKey, Object pObject) {
        values.put(pKey, pObject);
    }

    public Object getObject(String pKey) {
        return values.get(pKey);
    }
    public static SceneValueMap getSceneValuesMap(){
         if(self == null){
             self = new SceneValueMap();
         }
        return self;
    }
}
