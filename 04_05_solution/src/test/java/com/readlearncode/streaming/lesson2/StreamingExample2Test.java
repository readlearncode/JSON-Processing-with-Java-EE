package com.readlearncode.streaming.lesson2;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class StreamingExample2Test {

    @Test
    public void givenKeyName_shouldReturnKeyStringValue() throws Exception {

        // arrange
        StreamingExample2 streamingExample2 = new StreamingExample2();

        // act
        String value = streamingExample2.retrieveValue("title", JSON);

        // assert
        assertThat(value).isEqualTo("JSON-Processing With Java EE");
    }

    @Test
    public void givenKeyName_shouldReturnKeyNumberValue() throws Exception {

        // arrange
        StreamingExample2 streamingExample2 = new StreamingExample2();

        // act
        String value = streamingExample2.retrieveValue("length", JSON);

        // assert
        assertThat(value).isEqualTo("90");
    }

    @Test
    public void givenKeyName_whenKeyIsArray_shouldReturnNullValue() throws Exception {

        // arrange
        StreamingExample2 streamingExample2 = new StreamingExample2();

        // act
        String value = streamingExample2.retrieveValue("chapters", JSON);

        // assert
        assertThat(value).isNull();

    }


    private static String JSON = "{\n" +
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

}