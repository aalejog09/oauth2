package com.api.resources.util;

import jakarta.persistence.AttributeConverter;

public class BooleanToSmallintConverter implements AttributeConverter<Boolean, Short> {
    @Override
    public Short convertToDatabaseColumn(Boolean value) {
        return (value != null && value) ? (short) 1 : (short) 0;
    }

    @Override
    public Boolean convertToEntityAttribute(Short value) {
        return (value != null && value == 1);
    }
}
