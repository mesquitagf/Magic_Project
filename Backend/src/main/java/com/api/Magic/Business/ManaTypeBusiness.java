package com.api.Magic.Business;

import com.api.Magic.Model.Entity.ManaType;
import com.api.Magic.Service.ManaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component("ManaTypeBusiness")
public class ManaTypeBusiness {

    @Autowired
    ManaTypeService manaTypeService;

    @GetMapping
    public ResponseEntity<List<ManaType>> findAll(){
        return manaTypeService.findAll();
    }
}
