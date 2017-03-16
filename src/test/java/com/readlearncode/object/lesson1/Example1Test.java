package com.readlearncode.object.lesson1;

import org.junit.Test;

import javax.json.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Example1Test {


    @Test
    public void givenJsonDateInFlatFile_readsDataIntoJsonStructure() throws Exception {

        // Arrange
        Example1 example1 = new Example1();

        // Act
        JsonStructure jsonStructure = example1.loadJsonStructure();

        // Assert
        assertThat(jsonStructure.getValueType()).isEqualTo(JsonValue.ValueType.OBJECT);

        assertThat(jsonStructure).isInstanceOf(JsonObject.class);


        // Case JsonStructure to JsonObject
        JsonObject jsonObject = (JsonObject) jsonStructure;

        assertThat(jsonObject.size()).isEqualTo(7);
        assertThat(jsonObject.containsKey("chapters")).isTrue();

        assertThat(jsonObject.getJsonArray("chapters")).isNotNull();

        assertThat(jsonObject.getJsonArray("chapters")).isInstanceOf(JsonArray.class);

        assertThat(jsonObject.getJsonArray("chapters").get(0)).isInstanceOf(JsonValue.class);

        assertThat(jsonObject.getJsonArray("chapters").get(0)).isInstanceOf(JsonString.class);

        assertThat(jsonObject.getJsonArray("chapters").get(0).getValueType()).isEqualTo(JsonValue.ValueType.STRING);

        // JsonArray
        //assertThat(jsonObject.getJsonArray("chapters").get(0).toString()).isEqualTo("Introduction"); // ""Introduction""
        assertThat(((JsonString) jsonObject.getJsonArray("chapters").get(0)).getString()).isEqualTo("Introduction");

        // Nested JsonObject
        assertThat(((JsonString) jsonObject.getJsonObject("sourceCode").get("repositoryName")).getString()).isEqualTo("JSON-Processing-with-Java-EE");
        assertThat(((JsonString) jsonObject.getJsonObject("sourceCode").get("url")).getString()).isEqualTo("github.com/readlearncode");

    }

    @Test
    public void givenJsonDateInFlatFile_readsDataIntoJsonObject() throws Exception {

    }

    @Test
    public void givenJsonArrayDataInFlatFile_readsDataIntoJsonArray() throws Exception {

    }

}