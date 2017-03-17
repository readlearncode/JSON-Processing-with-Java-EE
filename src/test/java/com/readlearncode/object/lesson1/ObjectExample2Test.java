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
public class ObjectExample2Test {


    @Test
    public void givenJsonDateInFlatFile_readsDataIntoJsonStructure() throws Exception {

        // Arrange
        ObjectExample2 objectExample2 = new ObjectExample2();

        // Act
        JsonStructure jsonStructure = objectExample2.loadJsonStructure();

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

        // Arrange
        ObjectExample2 objectExample2 = new ObjectExample2();

        // Act
        JsonObject jsonObject = objectExample2.loadJsonObject();

        // Assert
        assertThat(jsonObject.getValueType()).isEqualTo(JsonValue.ValueType.OBJECT);
    }

    @Test
    public void givenJsonArrayDataInFlatFile_readsDataIntoJsonArray() throws Exception {

        // Arrange
        ObjectExample2 objectExample2 = new ObjectExample2();

        // Act
        JsonArray jsonArray = objectExample2.loadJsonArray();

        // Assert
        assertThat(jsonArray.getValueType()).isEqualTo(JsonValue.ValueType.ARRAY);
    }

}