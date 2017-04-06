package com.readlearncode.object.lesson5;

import com.readlearncode.object.lesson3.ObjectExample3;

import javax.json.Json;
import javax.json.JsonWriter;
import java.io.StringWriter;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ObjectExample6 {

    public String writeJsonStructure() {

        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(stringWriter);
        jsonWriter.writeObject(new ObjectExample3().buildJsonDocument());
        jsonWriter.close();

        return stringWriter.toString();
    }


}