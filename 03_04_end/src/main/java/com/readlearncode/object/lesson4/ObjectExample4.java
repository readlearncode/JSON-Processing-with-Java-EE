package com.readlearncode.object.lesson4;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ObjectExample4 {

    public static void main(String... args) throws FileNotFoundException {
        navigateJsonStructure(loadJsonObject(), null);
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

    /**
     * Load JSON data from a flat-file
     *
     * @return a JsonObject that models the JSON data in the flat-file
     * @throws FileNotFoundException
     */
    private static JsonObject loadJsonObject() throws FileNotFoundException {

        String jsonFile = Utils.ROOT + System.getProperty("file.separator") + "jsondata-object.json";

        JsonReader reader = Json.createReader(new FileReader(jsonFile));
        JsonObject jsonObject = reader.readObject();

        return jsonObject;
    }

}