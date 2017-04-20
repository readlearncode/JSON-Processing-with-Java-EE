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
public class ObjectExample5WithLayout {

    private String valueIndent = "";
    private String keyIndent = "";
    private String separator = " : ";

    public static void main(String... args) throws FileNotFoundException {
        new ObjectExample5WithLayout().navigateJsonStructure();
    }

    private void navigateJsonStructure() throws FileNotFoundException {
        JsonObject jsonObject = loadJsonObject();
        printValue(jsonObject);
    }

    private void printValue(JsonArray jsonValues) {
        setValueIndent();
        System.out.println("");
        jsonValues.forEach(jsonValue -> printValue("", jsonValue));
        unsetValueIndent();
    }

    private void printValue(JsonObject jsonObject) {
        jsonObject.forEach(this::printValue);
    }

    private void printValue(String key, JsonValue jsonValue) {
        printKey(key);
        if (jsonValue instanceof JsonString) {
            setSeparator();
            printValue((JsonString) jsonValue);
            return;
        }
        if (jsonValue instanceof JsonArray) {
            unsetSeparator();
            printValue((JsonArray) jsonValue);
            setSeparator();
            return;
        }
        if (jsonValue instanceof JsonObject) {
            System.out.println("");
            setKeyIndent();
            unsetValueIndent();
            printValue((JsonObject) jsonValue);
            unsetKeyIndent();
            return;
        }
        if (jsonValue instanceof JsonNumber) {
            printValue((JsonNumber) jsonValue);
            return;
        }
        printValue(jsonValue.toString());
    }

    private void printKey(String key) {
        System.out.print(keyIndent + key);
    }

    private void printValue(JsonString jsonString) {
        printValue(jsonString.getString());
    }

    private void printValue(JsonNumber jsonNumber) {
        printValue(jsonNumber.toString());
    }

    private void printValue(String value) {
        System.out.println(valueIndent + separator + value);
    }

    private void unsetValueIndent() {
        valueIndent = "";
    }

    private void setValueIndent() {
        valueIndent = "-----";
    }

    private void setKeyIndent() {
        keyIndent = "-----";
    }

    private void unsetKeyIndent() {
        keyIndent = "";
    }

    private void setSeparator() {
        separator = " : ";
    }

    private void unsetSeparator() {
        separator = "";
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