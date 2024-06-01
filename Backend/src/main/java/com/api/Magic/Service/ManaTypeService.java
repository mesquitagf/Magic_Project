package com.api.Magic.Service;

import com.api.Magic.Converter.ManaTypeConverter;
import com.api.Magic.Dto.ManaTypeDTO;
import com.api.Magic.Exception.BusinessException;
import com.api.Magic.Model.Entity.ManaType;
import com.api.Magic.Repository.ManaTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManaTypeService {

    @Autowired
    ManaTypeRepository manaTypeRepository;

    private final ManaTypeConverter manaTypeConverter;

    public String createManaType(ManaTypeDTO manaTypeRequestDTO) {
        try {
            var manaTypeRequest = manaTypeConverter.toEntity(manaTypeRequestDTO);
            manaTypeRepository.save(manaTypeRequest);
            return "ManaType created successfully! ID:" + manaTypeRequest.getId();
        } catch (Exception e){
            throw new BusinessException("Error creating ManaType!", e);
        }
    }

    public ResponseEntity<List<ManaType>> findAllManaType(){
        return ResponseEntity.ok(this.manaTypeRepository.findAll());
    }

    public String deleteManaType(String id){
        try {
            manaTypeRepository.deleteById(id);

            return "ManaType deleted successfully! ID:" + id;
        } catch (Exception e){
            throw new BusinessException("Error deleting ManaType!", e);
        }
    }

}
