package com.file.monitoring.generic.commands.dto;

import lombok.Data;

@Data
public class Names {
    private long id;
    private String fName;
    private String lName;

    public Names(long id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }
}
