package com.readlearncode.streaming.lesson2;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.StringReader;

import static javax.json.stream.JsonParser.Event.VALUE_NUMBER;
import static javax.json.stream.JsonParser.Event.VALUE_STRING;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class StreamingExample2 {

    public String retrieveValue(final String key_to_find, final String json) {

        JsonParser parser = Json.createParser(new StringReader(json));

        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            switch (event) {
                case KEY_NAME:
                    if (parser.getString().equalsIgnoreCase(key_to_find)) {
                        event = parser.next();
                        if (event == VALUE_STRING || event == VALUE_NUMBER) {
                            return parser.getString();
                        }
                    }
                    break;
            }
        }

        return null;
    }

}