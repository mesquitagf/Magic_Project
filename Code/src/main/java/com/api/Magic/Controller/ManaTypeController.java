package com.api.Magic.Controller;

import com.api.Magic.Model.Entity.ManaType;
import com.api.Magic.Repository.ManaTypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manatypes")
public class ManaTypeController {

    private final ManaTypeRepository manaTypeRepository;

    public ManaTypeController(ManaTypeRepository manaTypeRepository) {
        this.manaTypeRepository = manaTypeRepository;
    }

    @GetMapping
    public ResponseEntity<List<ManaType>> findAll(){
        return ResponseEntity.ok(this.manaTypeRepository.findAll());
    }
}
