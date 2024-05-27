package com.api.Magic.Converter;

import com.api.Magic.Dto.ManaTypeDTO;
import com.api.Magic.Model.Entity.ManaType;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ManaTypeConverter {

    public ManaType toEntity(ManaTypeDTO manaTypeDTO){
        return ManaType.builder()
                .id(UUID.randomUUID().toString())
                .manaType(manaTypeDTO.getManaType())
                .build();
    }
}
