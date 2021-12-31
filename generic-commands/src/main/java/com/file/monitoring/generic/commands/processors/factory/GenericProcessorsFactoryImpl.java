package com.file.monitoring.generic.commands.processors.factory;

import com.file.monitoring.generic.commands.processors.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenericProcessorsFactoryImpl implements GenericProcessorsFactory {
    @Autowired
    private BeanFactory beanFactory;

    @Override
    public GenericProcessor createGenericProcessor1_1() {
        return beanFactory.getBean(GenericProcessor1_1.class.getSimpleName(), GenericProcessor.class);
    }

    @Override
    public GenericProcessor createGenericProcessor1_2() {
        return beanFactory.getBean(GenericProcessor1_2.class.getSimpleName(), GenericProcessor.class);
    }

    @Override
    public GenericProcessor createGenericProcessor2_1() {
        return beanFactory.getBean(GenericProcessor2_1.class.getSimpleName(), GenericProcessor.class);
    }

    @Override
    public GenericProcessor createGenericProcessor3_1() {
        return beanFactory.getBean(GenericProcessor3_1.class.getSimpleName(), GenericProcessor.class);
    }

    @Override
    public GenericProcessor createGenericProcessor3_2() {
        return beanFactory.getBean(GenericProcessor3_2.class.getSimpleName(), GenericProcessor.class);
    }

    @Override
    public GenericProcessor createGenericProcessor4_1() {
        return beanFactory.getBean(GenericProcessor4_1.class.getSimpleName(), GenericProcessor.class);
    }

    @Override
    public GenericProcessor createGenericProcessor5_1() {
        return beanFactory.getBean(GenericProcessor5_1.class.getSimpleName(), GenericProcessor.class);
    }

    @Override
    public GenericProcessor createGenericProcessor5_2() {
        return beanFactory.getBean(GenericProcessor5_2.class.getSimpleName(), GenericProcessor.class);
    }
}
