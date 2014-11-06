package ru.vsprog.springinaction.chapter3;

import org.springframework.scheduling.support.CronTrigger;

import java.util.TimeZone;

/**
 * Created by vsa
 * Date: 06.11.14.
 */
public class CronTriggerBean extends CronTrigger implements BeanNameAware {
    public String getBeanName() {
        return beanName;
    }

    private String beanName;

    public CronTriggerBean(String cronExpression) {
        super(cronExpression);
    }

    public CronTriggerBean(String cronExpression, TimeZone timeZone) {
        super(cronExpression, timeZone);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public void afterPropertiesSet() {
        if (getBeanName() == null) {
            setBeanName(this.beanName);
        }
    }

}
