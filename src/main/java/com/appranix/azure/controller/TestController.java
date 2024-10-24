package com.appranix.azure.controller;

import com.appranix.azure.component.ApnxFileWriter;
import com.appranix.azure.entity.SampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/test")
public class TestController {

    @Autowired
    ApnxFileWriter apnxFileWriter;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(
            @RequestBody SampleData sampleData)
            throws Exception {

        apnxFileWriter.write(sampleData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
