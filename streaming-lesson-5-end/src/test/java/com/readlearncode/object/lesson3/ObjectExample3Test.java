package com.readlearncode.object.lesson3;

import org.junit.Test;

import javax.json.JsonObject;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ObjectExample3Test {


    @Test
    public void givenJsonBuiltByBuilder_shouldBuildCorrectly() throws Exception {

        // Arrange
        ObjectExample3 objectExample3 = new ObjectExample3();

        // Act
        JsonObject jsonObject = objectExample3.buildJsonDocument();

        // Assert
        assertThat(jsonObject.getString("title")).isEqualTo("JSON-Processing With Java EE");
        assertThat(jsonObject.getJsonArray("chapters").size()).isEqualTo(6);
        assertThat(jsonObject.getBoolean("released")).isTrue();
        assertThat(jsonObject.getInt("length")).isEqualTo(90);
        assertThat(jsonObject.getJsonObject("sourceCode").getString("repositoryName")).isEqualTo("JSON-Processing-with-Java-EE");
        assertThat(jsonObject.getJsonObject("sourceCode").getString("url")).isEqualTo("github.com/readlearncode");
        assertThat(jsonObject.getJsonArray("complementaryCourse").getJsonObject(0).getString("title")).isEqualTo("RESTful Service with JAX-RS 2.0");
        assertThat(jsonObject.getJsonArray("complementaryCourse").getJsonObject(1).getInt("length")).isEqualTo(130);
        assertThat(jsonObject.isNull("notes")).isTrue();

    }
}