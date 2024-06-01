package com.api.Magic.Business;

import com.api.Magic.Dto.ManaTypeDTO;
import com.api.Magic.Exception.BusinessException;
import com.api.Magic.Model.Entity.ManaType;
import com.api.Magic.Service.ManaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManaTypeBusiness {

    @Autowired
    ManaTypeService manaTypeService;

    public String createManaType(ManaTypeDTO manaTypeRequestDTO){
        validateManaTypeField(manaTypeRequestDTO);
        return manaTypeService.createManaType(manaTypeRequestDTO);
    }

    public ResponseEntity<List<ManaType>> findAllManaType(){
        return manaTypeService.findAllManaType();
    }

    private void validateManaTypeField(ManaTypeDTO manaTypeDTO){
        if (manaTypeDTO.getManaType().isEmpty()){
            throw new BusinessException("ManaType is null!");
        }
    }

    public String deleteManaType(String id) {
        validateIdField(id);
        return manaTypeService.deleteManaType(id);
    }

    private void validateIdField(String id){
        if (id.isEmpty()){
            throw new BusinessException("ID is null!");
        }
    }

}
