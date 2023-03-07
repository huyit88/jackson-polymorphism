package com.my.poc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NumericValue implements InputValue{
    private Long value;
    private String type="NUMERIC";

    @Override
    public Object getValue() {
        return value;
    }
}
