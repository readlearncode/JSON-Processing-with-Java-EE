package com.readlearncode.object.lesson3;

import com.readlearncode.object.lesson1.ObjectExample2;

import javax.json.*;
import java.io.FileNotFoundException;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ObjectExample4 {

    public static void main(String... args) throws FileNotFoundException {
        new ObjectExample4().navigateJsonStructure(new ObjectExample2().loadJsonObject(), null);
    }

    public  void navigateJsonStructure(JsonValue jsonValue, String key) {
        if (key != null)
            printKey(key);
        switch(jsonValue.getValueType()) {
            case OBJECT:
                JsonObject jsonObject = (JsonObject) jsonValue;
                for (String name : jsonObject.keySet())
                    navigateJsonStructure(jsonObject.get(name), name);
                break;
            case ARRAY:
                for (JsonValue value : (JsonArray) jsonValue)
                    navigateJsonStructure(value, null);
                break;
            case STRING:
                printValue(((JsonString) jsonValue).getString());
                break;
            case NUMBER:
                printValue(jsonValue.toString());
                break;
            case TRUE:
            case FALSE:
            case NULL:
                printValue(jsonValue.getValueType().toString());
                break;
        }
    }

    private void printKey(String key) {
        System.out.print(key + ": ");
    }

    private void printValue(String x) {
        System.out.println(x);
    }

}