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
                // Implement code that deals with object types
                break;
            case ARRAY:
                // Implement code that deals with array types
                break;
            case STRING:
                // Implement code that deals with string types
                break;
            case NUMBER:
                // Implement code that deals with number types
                break;
            case TRUE:
                // Implement code that deals with boolean types
                break;
            case FALSE:
                // Implement code that deals with boolean types
                break;
            case NULL:
                // Implement code that deals with nulls
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
    public static JsonObject loadJsonObject() throws FileNotFoundException {

        String jsonFile = Utils.ROOT + System.getProperty("file.separator") + "jsondata-object.json";

        JsonReader reader = Json.createReader(new FileReader(jsonFile));
        JsonObject jsonObject = reader.readObject();

        return jsonObject;
    }

}