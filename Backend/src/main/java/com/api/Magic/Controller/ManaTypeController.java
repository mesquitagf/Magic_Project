package com.api.Magic.Controller;

import com.api.Magic.Business.ManaTypeBusiness;
import com.api.Magic.Dto.ManaTypeDTO;
import com.api.Magic.Model.Entity.ManaType;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(ManaTypeController.class);

    @PostMapping
    public ResponseEntity<ManaType> createManaType(@RequestBody @Valid ManaTypeDTO manaTypeRequestDTO){
        logger.info("Creating manaType with request body: {}", manaTypeRequestDTO);
        return new ResponseEntity<>(manaTypeBusiness.createManaType(manaTypeRequestDTO.toEntity(manaTypeRequestDTO)),
                                    HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ManaType>> findAllManaType(){
        logger.info("Finding all manaTypes");
        return new ResponseEntity<>(manaTypeBusiness.findAllManaType(), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteManaType(@RequestParam("id") @Valid String id){
        logger.info("Deleting manaType with id: {}", id);
        return new ResponseEntity<>(manaTypeBusiness.deleteManaType(id), HttpStatus.OK);
    }
}
