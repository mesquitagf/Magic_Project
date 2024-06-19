package com.api.Magic.Service;

import com.api.Magic.Exception.BusinessException;
import com.api.Magic.Model.Entity.ManaType;
import com.api.Magic.Repository.ManaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ManaTypeService {

    @Autowired
    ManaTypeRepository manaTypeRepository;

    public ManaType createManaType(ManaType manaTypeRequest) {
        manaTypeRequest.setId(UUID.randomUUID().toString());
        return manaTypeRepository.save(manaTypeRequest);
    }

    public List<ManaType> findAllManaType(){
        return this.manaTypeRepository.findAll();
    }

    public String deleteManaType(String id){
        var manaType = this.manaTypeRepository.findById(id).orElseThrow(() -> new BusinessException("ManaType not found!"));
        manaTypeRepository.deleteById(manaType.getId());
        return "ManaType deleted successfully! ID:" + id;
    }

}
