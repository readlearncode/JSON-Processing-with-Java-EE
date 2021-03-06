package com.readlearncode.object.lesson1;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.readlearncode.Utils.ROOT;

/**
 * Source code github.com/readlearncode
 * <p>
 * Creating an object model from JSON Data
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ObjectExample2 {


    /**
     * Builds a JsonStructure from a flat-file source containing Json data.
     *
     * @return a JsonStructure built from the flat-file
     * @throws FileNotFoundException
     */
    public JsonStructure loadJsonStructure() throws FileNotFoundException {

        String jsonFile = ROOT + System.getProperty("file.separator") + "example1-jsondata-structure.json";

        JsonReader jsonReader = Json.createReader(new FileReader(jsonFile));
        JsonStructure jsonStructure = jsonReader.read();
        jsonReader.close();

        return jsonStructure;
    }

    /**
     * Builds a JsonObject from a flat-file source containing Json data.
     *
     * @return a JsonObject built from the flat-file
     * @throws FileNotFoundException
     */
    public JsonObject loadJsonObject() throws FileNotFoundException {

        String jsonFile = ROOT + System.getProperty("file.separator") + "example1-jsondata-object.json";

        JsonReader reader = Json.createReader(new FileReader(jsonFile));
        JsonObject jsonObject = reader.readObject();

        return jsonObject;

    }

    /**
     * Builds a JsonArray from a flat-file source containing Json Array data.
     *
     * @return a JsonArray built from the flat-file
     * @throws FileNotFoundException
     */
    public JsonArray loadJsonArray() throws FileNotFoundException {

        String jsonFile = ROOT + System.getProperty("file.separator") + "example1-jsondata-array.json";

        JsonReader reader = Json.createReader(new FileReader(jsonFile));
        JsonArray jsonArray = reader.readArray();

        return jsonArray;
    }

}