package com.file.monitoring.generic.commands.dao;

import com.file.monitoring.generic.commands.dto.Names;

import java.util.List;
import java.util.Optional;

public interface NamesDAO {
    int count();
    List<Names> findAll();
    Optional<Names> getNameById(long id);
}
