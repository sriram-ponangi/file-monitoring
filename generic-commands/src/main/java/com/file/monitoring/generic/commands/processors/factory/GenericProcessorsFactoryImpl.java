package com.file.monitoring.generic.commands.processors.factory;

import com.file.monitoring.generic.commands.processors.*;
import org.springframework.stereotype.Component;

@Component
public class GenericProcessorsFactoryImpl implements GenericProcessorsFactory {
    @Override
    public GenericProcessor createGenericProcessor1_1() {
        return new GenericProcessor1_1();
    }

    @Override
    public GenericProcessor createGenericProcessor1_2() {
        return new GenericProcessor1_2();
    }

    @Override
    public GenericProcessor createGenericProcessor2_1() {
        return new GenericProcessor2_1();
    }

    @Override
    public GenericProcessor createGenericProcessor3_1() {
        return new GenericProcessor3_1();
    }

    @Override
    public GenericProcessor createGenericProcessor3_2() {
        return new GenericProcessor3_2();
    }

    @Override
    public GenericProcessor createGenericProcessor4_1() {
        return new GenericProcessor4_1();
    }

    @Override
    public GenericProcessor createGenericProcessor5_1() {
        return new GenericProcessor5_1();
    }

    @Override
    public GenericProcessor createGenericProcessor5_2() {
        return new GenericProcessor5_2();
    }
}
