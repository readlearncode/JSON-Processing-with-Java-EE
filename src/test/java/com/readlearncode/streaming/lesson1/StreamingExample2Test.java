package com.readlearncode.streaming.lesson1;

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
    public void givenKeyName_shouldReturnKeyValue() throws Exception {

        // arrange
        StreamingExample2 streamingExample2 = new StreamingExample2();

        // act
        String value = streamingExample2.retrieveValue("title");

        // assert
        assertThat(value).isEqualTo("JSON-Processing With Java EE");

    }

}