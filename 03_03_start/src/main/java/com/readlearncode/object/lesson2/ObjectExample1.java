package com.readlearncode.object.lesson2;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

/**
 * Source code github.com/readlearncode
 * <p>
 * Creating an object model from JSON Data
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ObjectExample1 {

    public static String JSON = "{\n" +
            "  \"title\": \"JSON-Processing With Java EE\",\n" +
            "  \"chapters\": [\n" +
            "    \"Introduction\",\n" +
            "    \"1. JSON and Java\",\n" +
            "    \"2. JSON-Processing API features\",\n" +
            "    \"3. The Java EE JSON Object model\",\n" +
            "    \"4. The Java EE JSON Streaming model\",\n" +
            "    \"Conclusion\"\n" +
            "  ],\n" +
            "  \"released\": true,\n" +
            "  \"length\": 90,\n" +
            "  \"sourceCode\": {\n" +
            "    \"repositoryName\": \"JSON-Processing-with-Java-EE\",\n" +
            "    \"url\": \"github.com/readlearncode\"\n" +
            "  },\n" +
            "  \"complementaryCourse\": [\n" +
            "    {\n" +
            "      \"title\": \"RESTful Service with JAX-RS 2.0\",\n" +
            "      \"length\": 120\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Java Enterprise Edition Introduction\",\n" +
            "      \"length\": 130\n" +
            "    }\n" +
            "  ],\n" +
            "  \"notes\": null\n" +
            "}";

    /**
     * Builds a JsonObject from a Stirng of JSON data.
     *
     * @return a JsonObject built from a String of JSON data
     */
    public JsonObject loadJsonString() {

        JsonReader jsonReader = Json.createReader(new StringReader(JSON));
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();

        return jsonObject;
    }


}