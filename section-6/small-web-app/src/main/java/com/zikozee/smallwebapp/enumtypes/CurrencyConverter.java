package com.zikozee.smallwebapp.enumtypes;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

/**
 * @author : Ezekiel Eromosei
 * @created : 17 Dec, 2021
 */

@Converter(autoApply = true)
public class CurrencyConverter implements AttributeConverter<Currency, String> {
    @Override
    public String convertToDatabaseColumn(Currency currency) {
        return currency.name();
    }

    @Override
    public Currency convertToEntityAttribute(String s) {
        return Arrays.stream(Currency.values())
                .filter(cur -> cur.name().equals(s))
                .findFirst()
                .orElse(null);
    }
}
