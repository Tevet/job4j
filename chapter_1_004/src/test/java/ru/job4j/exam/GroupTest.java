package ru.job4j.exam;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GroupTest {
    @Test
    public void testOne() {
        List<Student> classList = new ArrayList<>();

        Set<String> andreyUnits = new TreeSet<>();
        andreyUnits.add("Algebra");
        andreyUnits.add("Geometry");
        andreyUnits.add("Physics");
        classList.add(new Student("Andrey", andreyUnits));

        Set<String> alexUnits = new TreeSet<>();
        alexUnits.add("Algebra");
        alexUnits.add("Geometry");
        alexUnits.add("Physics");
        alexUnits.add("Music Arts");
        alexUnits.add("Literature");
        alexUnits.add("History");
        classList.add(new Student("Alex", alexUnits));

        Set<String> olgaUnits = new TreeSet<>();
        olgaUnits.add("Chemistry");
        olgaUnits.add("History");
        olgaUnits.add("Physics");
        classList.add(new Student("Olga", olgaUnits));

        Map<String, Set<String>> sortResult = Group.sections(classList);

        for (Student student : classList) {
            System.out.println(student.getName() + " посещает: " + student.getUnits());
        }
        System.out.println(Group.sections(classList).entrySet());

        Assert.assertThat(classList.get(2).getName(), is("Olga"));
        Assert.assertThat(classList.get(2).getUnits().toString(), is("[Chemistry, History, Physics]"));
        Assert.assertThat(sortResult.entrySet().toString(), is("[Geometry=[Alex, Andrey], Chemistry=[Olga], Algebra=[Alex, Andrey], Literature=[Alex], History=[Alex, Olga], Physics=[Alex, Andrey, Olga], Music Arts=[Alex]]"));
    }
}
