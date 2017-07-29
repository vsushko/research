package ru.vsprog.springinaction.chapter14;

/**
 * Created by vsa
 * Date: 03.12.14.
 */
public interface HomeControllerManagedOperations {
    // методы, как экспортируемые операции
    int getSpittlesPerPage();
    void getSpittlesPerPage(int spittlesPerPage);
}
