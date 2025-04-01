package com.hackathon.pushProtocolApp.service;

import com.hackathon.pushProtocolApp.model.DataRecord;
import com.hackathon.pushProtocolApp.utils.FileReaderUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DataService {
    private final FileReaderUtil fileReaderUtil;

    public DataService(FileReaderUtil fileReaderUtil) {
        this.fileReaderUtil = fileReaderUtil;
    }

    public List<DataRecord> getAllRecords() throws IOException {
        return fileReaderUtil.readData();
    }

    public DataRecord getRecordById(int id) throws IOException {
        return fileReaderUtil.readData().stream()
                .filter(record -> record.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
