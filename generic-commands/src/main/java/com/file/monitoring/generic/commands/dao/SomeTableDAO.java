package com.file.monitoring.generic.commands.dao;

import com.file.monitoring.generic.commands.dto.SomeTableDTO;

import java.util.List;
import java.util.Optional;

public interface SomeTableDAO {
    int count();
    List<SomeTableDTO> findAll();
    Optional<SomeTableDTO> getNameById(long id);
}
