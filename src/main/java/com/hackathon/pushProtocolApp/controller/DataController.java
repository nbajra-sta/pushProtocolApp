package com.hackathon.pushProtocolApp.controller;

import com.hackathon.pushProtocolApp.model.DataRecord;
import com.hackathon.pushProtocolApp.service.DataService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public List<DataRecord> getAllData() throws IOException {
        return dataService.getAllRecords();
    }

    @GetMapping("/{id}")
    public DataRecord getDataById(@PathVariable int id) throws IOException {
        return dataService.getRecordById(id);
    }

    @PostMapping
    public String addData(@RequestBody DataRecord newRecord) {
        return "This API does not support saving data. Just a sample endpoint!";
    }
}

