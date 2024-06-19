package com.api.Magic.Dto;

import com.api.Magic.Model.Entity.ManaType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class ManaTypeDTO {

    @NotBlank
    private String manaType;

    public ManaType toEntity(ManaTypeDTO manaTypeDTO){
        var manaType = new ManaType();
        BeanUtils.copyProperties(manaTypeDTO, manaType);
        return manaType;
    }

}
