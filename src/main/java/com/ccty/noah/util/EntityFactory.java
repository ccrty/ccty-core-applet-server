package com.ccty.noah.util;

import com.ccty.noah.aop.BaseEntity;
import org.mapstruct.TargetType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class EntityFactory implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    public EntityFactory() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        if (applicationContext == null) {
            applicationContext = applicationContext;
        }

    }

    public <T extends BaseEntity> T createEntity(@TargetType Class<T> entityClass) {
        return applicationContext.getBean(entityClass);
    }
}