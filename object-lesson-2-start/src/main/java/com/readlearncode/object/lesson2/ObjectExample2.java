package com.readlearncode.object.lesson2;

import javax.json.*;
import java.io.FileNotFoundException;

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
     * Builds a JsonObject from a flat-file source containing Json data.
     *
     * @return a JsonObject built from the flat-file
     * @throws FileNotFoundException
     */
    public JsonObject loadJsonObject() throws FileNotFoundException {

        String jsonFile = ROOT + System.getProperty("file.separator") + "example1-jsondata-object.json";

        // Implement code that loads the file and creates a JSON object from the files contents

        return null;

    }

    /**
     * Builds a JsonArray from a flat-file source containing Json Array data.
     *
     * @return a JsonArray built from the flat-file
     * @throws FileNotFoundException
     */
    public JsonArray loadJsonArray() throws FileNotFoundException {

        String jsonFile = ROOT + System.getProperty("file.separator") + "example1-jsondata-array.json";

        // Implement code that loads JSON array data from a flat-file and creates a JsonArray object

        return null;
    }

}