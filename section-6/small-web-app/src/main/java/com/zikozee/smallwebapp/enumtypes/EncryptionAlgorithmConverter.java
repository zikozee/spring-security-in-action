package com.zikozee.smallwebapp.enumtypes;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

/**
 * @author : Ezekiel Eromosei
 * @created : 17 Dec, 2021
 */

@Converter(autoApply = true)
public class EncryptionAlgorithmConverter implements AttributeConverter<EncryptionAlgorithm, String> {

    @Override
    public String convertToDatabaseColumn(EncryptionAlgorithm encryptionAlgorithm) {
        return encryptionAlgorithm.name();
    }

    @Override
    public EncryptionAlgorithm convertToEntityAttribute(String s) {
        return Arrays.stream(EncryptionAlgorithm.values())
                .filter(enc -> enc.name().equals(s))
                .findFirst().orElse(null);
    }
}
