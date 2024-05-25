package com.api.Magic.Controller;

import com.api.Magic.Business.ManaTypeBusiness;
import com.api.Magic.Model.Entity.ManaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manatypes")
public class ManaTypeController {

    @Autowired
    ManaTypeBusiness manaTypeBusiness;

    @GetMapping
    public ResponseEntity<List<ManaType>> findAll(){
        return manaTypeBusiness.findAll();
    }
}
