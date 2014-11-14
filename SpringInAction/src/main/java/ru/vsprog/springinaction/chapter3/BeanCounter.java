package ru.vsprog.springinaction.chapter3;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


/**
 * Created by vsa
 * Date: 06.11.14.
 */
public class BeanCounter implements BeanFactoryPostProcessor {
    private Logger LOGGER = Logger.getLogger(BeanCounter.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory)
            throws BeansException {
        LOGGER.debug("BEAN COUNT: " + factory.getBeanDefinitionCount());
    }
}
