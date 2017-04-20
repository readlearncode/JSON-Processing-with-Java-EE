package com.readlearncode.object.lesson2;

import org.junit.Test;

import javax.json.JsonObject;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ObjectExample1Test {


    @Test
    public void givenJsonDataInString_readsDataIntoJsonObject() throws Exception {

        // Arrange
        ObjectExample1 objectExample1 = new ObjectExample1();

        // Act
        JsonObject jsonObject = objectExample1.loadJsonString();

        // Assert
        // Implement code that asserts each element of the JSON document has been
        // appropriately interpreted and loaded into a JSON object.

    }

}