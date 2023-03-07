package com.my.poc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StringValue implements InputValue{

    private String value;
    private String type="STRING";

    @Override
    public Object getValue() {
        return value;
    }
}
