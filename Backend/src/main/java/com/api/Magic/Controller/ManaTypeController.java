package com.api.Magic.Controller;

import com.api.Magic.Business.ManaTypeBusiness;
import com.api.Magic.Dto.ManaTypeDTO;
import com.api.Magic.Model.Entity.ManaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manatypes")
public class ManaTypeController {

    @Autowired
    ManaTypeBusiness manaTypeBusiness;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createManaType(@RequestBody ManaTypeDTO manaTypeRequestDTO){
        return manaTypeBusiness.createManaType(manaTypeRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ManaType>> findAllManaType(){
        return manaTypeBusiness.findAllManaType();
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteManaType(@RequestParam String id){
        return manaTypeBusiness.deleteManaType(id);
    }
}
