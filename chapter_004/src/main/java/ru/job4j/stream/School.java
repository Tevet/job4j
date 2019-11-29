package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    /**
     * Список, для хранения учащихся в классе
     */
    public List<Student> group = new ArrayList();

    /**
     *
     * @param students список учашихся в классе
     * @param userFilter условие фильтрации по среднему баллу
     * @return отфильтрованный список учащихся
     */
    public List<Student> collect(List<Student> students, Predicate<Student> userFilter) {
        return students.stream().filter(userFilter).collect(Collectors.toList());
    }
}
