package com.readlearncode.streaming.lesson5;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class StreamingExample3Test {

    private static String json = "{\"title\":\"JSON-Processing With Java EE\",\"chapters\":[\"Introduction\",\"1. JSON and Java\",\"2. JSON-Processing API features\",\"3. The Java EE JSON Object model\",\"4. The Java EE JSON Streaming model\",\"Conclusion\"],\"released\":true,\"length\":90,\"sourceCode\":{\"repositoryName\":\"JSON-Processing-with-Java-EE\",\"url\":\"github.com/readlearncode\"},\"complementaryCourse\":[{\"title\":\"RESTful Service with JAX-RS 2.0\",\"length\":120},{\"title\":\"Java Enterprise Edition Introduction\",\"length\":130}],\"notes\":null}";

    @Test
    public void givenJsonAsStream_shouldProduceCorrectJsonString() throws Exception {

        // arrange
        StreamingExample3 streamingExample3 = new StreamingExample3();

        // act
        String jsonString = streamingExample3.writeJsonStreamToString();

        // assert
        // Assert that jsonString is equal to the json string

    }

}