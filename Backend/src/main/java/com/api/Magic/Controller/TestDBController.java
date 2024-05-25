package com.api.Magic.Controller;

import com.api.Magic.Model.Entity.TestDB;
import com.api.Magic.Repository.TestDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestDBController {

    @Autowired
    private final TestDBRepository testDBRepository;

    public TestDBController(TestDBRepository testDBRepository) {
        this.testDBRepository = testDBRepository;
    }

    @GetMapping("/testdb")
    public ResponseEntity<List<TestDB>> findAll(){
        return ResponseEntity.ok(this.testDBRepository.findAll());
    }
}
