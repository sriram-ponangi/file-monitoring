package com.file.monitoring.common.configs;

import java.util.HashMap;

public interface Command {
    boolean CONTINUE_PROCESSING = false;
    boolean COMPLETE_PROCESSING = true;

    boolean execute(HashMap<String, Object> context) throws Exception;

}
