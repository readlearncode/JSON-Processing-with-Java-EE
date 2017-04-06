package com.readlearncode.object.lesson4;

import com.readlearncode.object.lesson2.ObjectExample2;

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
        navigateJsonStructure(new ObjectExample2().loadJsonObject(), null);
    }

    private static void navigateJsonStructure(JsonValue jsonValue, String key) {
        if (key != null)
            printKey(key);
        switch (jsonValue.getValueType()) {
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

    private static void printKey(String key) {
        System.out.print(key + ": ");
    }

    private static void printValue(String x) {
        System.out.println(x);
    }

}