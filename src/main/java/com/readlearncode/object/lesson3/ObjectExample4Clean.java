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
public class ObjectExample4Clean {

    public static void main(String... args) throws FileNotFoundException {
        JsonObject jsonObject = new ObjectExample2().loadJsonObject();
        new ObjectExample4Clean().printValue(jsonObject);
    }

    private void printValue(JsonArray jsonValues) {
        jsonValues.forEach(jsonValue -> printValue("", jsonValue));
    }

    private void printValue(JsonObject jsonObject) {
        jsonObject.forEach(this::printValue);
    }

    private void printValue(String key, JsonValue jsonValue) {
        printKey(key);
        if (jsonValue instanceof JsonString) {
            printValue((JsonString) jsonValue);
            return;
        }
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
        printValue(jsonValue.toString());
    }

    private void printKey(String key) {
        System.out.print(key);
    }

    private void printValue(JsonString jsonString) {
        printValue(jsonString.getString());
    }

    private void printValue(JsonNumber jsonNumber) {
        printValue(jsonNumber.toString());
    }

    private void printValue(String value) {
        System.out.println(" : " + value);
    }

}