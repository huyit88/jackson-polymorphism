package com.my.poc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DateInput implements InputValue{
    private LocalDate date;
    private String type="DATE";

    @Override
    @JsonIgnore
    public Object getValue() {
        return date;
    }
}
