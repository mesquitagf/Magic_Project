package com.api.Magic.Service;

import com.api.Magic.Model.Entity.ManaType;
import com.api.Magic.Repository.ManaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManaTypeService {

    @Autowired
    ManaTypeRepository manaTypeRepository;

    public ResponseEntity<List<ManaType>> findAll(){
        return ResponseEntity.ok(this.manaTypeRepository.findAll());
    }
}
