package com.file.monitoring.common.configs.commands.validators;

import org.apache.commons.chain.Context;

import java.util.List;

public interface CommonFileMonitoringValidators {

    List<String> validate(Context context) throws Exception;

}
