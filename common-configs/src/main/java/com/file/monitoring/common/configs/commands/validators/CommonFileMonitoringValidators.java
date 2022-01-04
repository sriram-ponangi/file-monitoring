package com.file.monitoring.common.configs.commands.validators;

import java.util.HashMap;
import java.util.List;

public interface CommonFileMonitoringValidators {

    List<String> validate(HashMap<String, Object> context) throws Exception;

}
