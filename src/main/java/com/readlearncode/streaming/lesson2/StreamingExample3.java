package com.readlearncode.streaming.lesson2;

import javax.json.Json;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;
import java.io.StringWriter;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class StreamingExample3 {


    public String writeJsonStreamToString(){

        StringWriter stringWriter = new StringWriter();

        JsonGenerator generator = Json.createGenerator(stringWriter);
        generator.writeStartObject()
                    .write("title","JSON-Processing With Java EE")
                    .writeStartArray("chapters")
                        .write("Introduction")
                        .write("1. JSON and Java")
                        .write("2. JSON-Processing API features")
                        .write("3. The Java EE JSON Object model")
                        .write("4. The Java EE JSON Streaming model")
                        .write("Conclusion")
                    .writeEnd()
                    .write("released",JsonValue.TRUE)
                    .write("length",90)
                    .writeStartObject("sourceCode")
                        .write("repositoryName", "JSON-Processing-with-Java-EE")
                        .write("url","github.com/readlearncode")
                    .writeEnd()
                    .writeStartArray("complementaryCourse")
                        .writeStartObject()
                            .write("title", "RESTful Service with JAX-RS 2.0")
                            .write("length", 120)
                        .writeEnd()
                        .writeStartObject()
                            .write("title", "Java Enterprise Edition Introduction")
                            .write("length", 130)
                        .writeEnd()
                    .writeEnd()
                    .write("notes", JsonValue.NULL)
                .writeEnd();
        generator.close();

        return stringWriter.toString();
    }


}