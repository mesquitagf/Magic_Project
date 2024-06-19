package com.api.Magic.Business;

import com.api.Magic.Exception.BusinessException;
import com.api.Magic.Model.Entity.ManaType;
import com.api.Magic.Service.ManaTypeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManaTypeBusiness {

    @Autowired
    ManaTypeService manaTypeService;

    BusinessException businessException;


    public ManaType createManaType(ManaType manaTypeRequest){
        try {
            return manaTypeService.createManaType(manaTypeRequest);
        } catch (BusinessException e) {
            throw new BusinessException("Error creating ManaType", e);
        }
    }

    public List<ManaType> findAllManaType(){
        try {
            return manaTypeService.findAllManaType();
        } catch (BusinessException e) {
            throw new BusinessException("Error finding ManaTypes", e);
        }
    }

    public String deleteManaType(String id) {
        try {
            return manaTypeService.deleteManaType(id);
        } catch (BusinessException e) {
            throw new BusinessException("Error deleting ManaType!", e);
        }
    }
}
