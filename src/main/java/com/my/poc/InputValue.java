package com.my.poc;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "type",
    visible = true
)

@JsonSubTypes({
    @JsonSubTypes.Type(value = DateInput.class, name = "DATE"),
    @JsonSubTypes.Type(value = StringValue.class, name = "STRING"),
    @JsonSubTypes.Type(value = NumericValue.class, name = "NUMERIC")
})

public interface InputValue {
    Object getValue();
}
