package com.hackathon.pushProtocolApp.utils;

import com.hackathon.pushProtocolApp.model.DataRecord;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileReaderUtil {
    public List<DataRecord> readData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String path = new ClassPathResource("dataset.json").getFile().getPath();
        String json = new String(Files.readAllBytes(Paths.get(path)));
        return objectMapper.readValue(json, new TypeReference<List<DataRecord>>() {});
    }
}

