package com.readlearncode.object.lesson5;


import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ObjectExample7 {

    public static void main(String... arg) throws IOException {

        File file = new File("json-output.json");

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {

            if (!file.exists()) {
                file.createNewFile();
            }

            JsonWriter jsonWriter = Json.createWriter(fileOutputStream);
            jsonWriter.writeObject(buildJsonDocument());

            jsonWriter.close();

            // Flush and close file output streams
            fileOutputStream.flush();
            fileOutputStream.close();
        }

    }

    private static JsonObject buildJsonDocument() {

        JsonObject jsonObject = Json.createObjectBuilder()
                .add("title", "JSON-Processing With Java EE")
                .add("chapters", Json.createArrayBuilder()
                        .add("Introduction")
                        .add("1. JSON and Java")
                        .add("2. JSON-Processing API features")
                        .add("3. The Java EE JSON Object model")
                        .add("4. The Java EE JSON Streaming model")
                        .add("Conclusion"))
                .add("released", true)
                .add("length", 90)
                .add("sourceCode", Json.createObjectBuilder()
                        .add("repositoryName", "JSON-Processing-with-Java-EE")
                        .add("url", "github.com/readlearncode"))
                .add("complementaryCourse", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("title", "RESTful Service with JAX-RS 2.0")
                                .add("length", 120))
                        .add(Json.createObjectBuilder()
                                .add("title", "Java Enterprise Edition Introduction")
                                .add("length", 130)))
                .addNull("notes")
                .build();

        return jsonObject;
    }


}