package com.file.monitoring.generic.commands.dto;

import lombok.Data;

@Data
public class NamesDTO {
    private long id;
    private String fName;
    private String lName;

    public NamesDTO(long id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }
}
