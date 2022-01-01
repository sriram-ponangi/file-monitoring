package com.file.monitoring.generic.commands.dao;

import com.file.monitoring.generic.commands.dto.NamesDTO;

import java.util.List;
import java.util.Optional;

public interface NamesDAO {
    int count();
    List<NamesDTO> findAll();
    Optional<NamesDTO> getNameById(long id);
}
