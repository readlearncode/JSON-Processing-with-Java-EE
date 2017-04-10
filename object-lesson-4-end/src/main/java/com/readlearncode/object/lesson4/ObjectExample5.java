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
public class ObjectExample5 {

    public static void main(String... args) throws FileNotFoundException {
        new ObjectExample5().printValue(loadJsonObject());
    }

    /**
     * Delegates processing to appropriate printValue method based on type
     *
     * @param key       String key value
     * @param jsonValue JsonValue type
     */
    private void printValue(String key, JsonValue jsonValue) {
        printKey(key);
        if (jsonValue instanceof JsonArray) {
            printValue((JsonArray) jsonValue);
            return;
        }
        if (jsonValue instanceof JsonObject) {
            printValue((JsonObject) jsonValue);
            return;
        }
        if (jsonValue instanceof JsonNumber) {
            printValue((JsonNumber) jsonValue);
            return;
        }
        if (jsonValue instanceof JsonString) {
            printValue((JsonString) jsonValue);
            return;
        }
        printValue(jsonValue.toString());
    }

    /**
     * Processes Array types
     *
     * @param jsonValues JsonArray type
     */
    private void printValue(JsonArray jsonValues) {
        jsonValues.forEach(jsonValue -> printValue("", jsonValue));
    }

    /**
     * Processes JsonObject types
     *
     * @param jsonObject JsonObject type
     */
    private void printValue(JsonObject jsonObject) {
        jsonObject.forEach(this::printValue);
    }

    /**
     * Prints the JsonString value
     *
     * @param jsonString the JsonString value
     */
    private void printValue(JsonString jsonString) {
        printValue(jsonString.getString());
    }

    /**
     * Prints the JsonNumber value
     *
     * @param jsonNumber the JsonNumber value
     */
    private void printValue(JsonNumber jsonNumber) {
        printValue(jsonNumber.toString());
    }

    /**
     * Prints the String value to the console
     *
     * @param value the value to print
     */
    private void printValue(String value) {
        System.out.println(" : " + value);
    }

    /**
     * Prints the key name
     *
     * @param key the key name
     */
    private void printKey(String key) {
        System.out.print(key);
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