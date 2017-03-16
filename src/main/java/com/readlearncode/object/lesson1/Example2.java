package com.readlearncode.object.lesson1;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import static com.readlearncode.Utils.ROOT;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Example2 {

    public static void main(String... args) throws FileNotFoundException {

        new Example2().navigateJsonStructure();

    }

    public void navigateJsonStructure() throws FileNotFoundException {

        String jsonFile = ROOT + System.getProperty("file.separator") + "example1-jsondata-structure.json";

        JsonReader jsonReader = Json.createReader(new FileReader(jsonFile));
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();


        //jsonObject.keySet().forEach(s -> System.out.println(jsonObject.get(s)));



        List<String> chapters = ((JsonArray) jsonObject.get("chapters")).stream()
                .peek(jsonValue -> System.out.println(jsonValue.getValueType()))
                .filter(jsonValue -> jsonValue.getValueType().equals(JsonValue.ValueType.STRING))
                .map(jsonValue -> ((JsonString)jsonValue).getString())
                .collect(Collectors.toList());


        System.out.println("chapters: " + chapters);
    }


}