package com.my.poc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {
    @Test
    void testSerialize() throws JsonProcessingException {
        LocalDate localDate = LocalDate.of(2020, 02, 02);
        Long numberValue = 2020l;
        String strInput = "string value";
        List<InputValue> values = List.of(
            DateInput.builder().date(localDate).type("DATE").build(),
            StringValue.builder().value(strInput).type("STRING").build(),
            NumericValue.builder().value(numberValue).type("NUMERIC").build()
        );
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModules(new JavaTimeModule());
        String data = objectMapper.writeValueAsString(values);
        System.out.println(data);
        List<InputValue> actual = objectMapper.readValue(data, new TypeReference<List<InputValue>>() {
        });
        assertAll(
            () -> assertEquals(localDate, actual.get(0).getValue()),
            () -> assertEquals(strInput, actual.get(1).getValue()),
            () -> assertEquals(numberValue, actual.get(2).getValue())
        );
    }
}
