package com.file.monitoring.generic.commands.dto;

import lombok.Data;

@Data
public class SomeTableDTO {
    private long id;
    private String column2;
    private String column3;

    public SomeTableDTO(long id, String column2, String column3) {
        this.id = id;
        this.column2 = column2;
        this.column3 = column3;
    }
}
