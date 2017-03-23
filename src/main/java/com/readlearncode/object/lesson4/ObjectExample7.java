package com.readlearncode.object.lesson4;

import com.readlearncode.object.lesson2.ObjectExample3;

import javax.json.Json;
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

    public static void main(String ...arg) throws IOException {

        File file = new File("json-output.json");

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {

            if (!file.exists()) {
                file.createNewFile();
            }

            JsonWriter jsonWriter = Json.createWriter(fileOutputStream);
            jsonWriter.writeObject(new ObjectExample3().buildJsonDocument());

            jsonWriter.close();

            // Flush and close file output streams
            fileOutputStream.flush();
            fileOutputStream.close();
        }

    }


}