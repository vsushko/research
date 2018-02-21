package ru.vsprog.jbpmtest;

import org.jbpm.api.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;

public class Main {

    private static final String PROCESS_NAME = "MY_TEST_PROCESS";

    public static void main(String[] args) {
        // Инициализируем движок процессов
        ProcessEngine processEngine = new Configuration().setResource("my.jbpm.cfg.xml").buildProcessEngine();
        // Создаем jBPM сервисы
        RepositoryService repositoryService = processEngine.getRepositoryService();
        ExecutionService executionService = processEngine.getExecutionService();

        // Развертываем определение процесса MY_TEST_PROCESS для его запуска
        repositoryService.createDeployment().addResourceFromClasspath("jbpmconfig.jpdl.xml").deploy();
        // Запускаем
        executionService.startProcessInstanceByKey(PROCESS_NAME);
    }

}
