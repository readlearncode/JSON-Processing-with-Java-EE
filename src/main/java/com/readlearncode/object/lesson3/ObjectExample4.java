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

    private String valueIndent = "";
    private String keyIndent = "";
    private String separator = " : ";

    public static void main(String... args) throws FileNotFoundException {
        new ObjectExample4().navigateJsonStructure();
    }

    private void navigateJsonStructure() throws FileNotFoundException {
        JsonObject jsonObject = new ObjectExample2().loadJsonObject();
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
}