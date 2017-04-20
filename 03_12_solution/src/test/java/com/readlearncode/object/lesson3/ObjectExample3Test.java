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
        // Implement code that asserts each element of the JSON document has been
        // appropriately interpreted and loaded into a JSON object.

    }
}