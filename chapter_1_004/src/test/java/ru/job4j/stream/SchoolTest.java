package ru.job4j.stream;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    private int groupSize = 90;


    @Test
    public void levelOfTest() {
        School school = new School();
        int bound = 50;

        List<Student> group = List.of(
                new Student(50, "Granitcin"),
                new Student(80, "Ahmedov"),
                new Student(51, "Zaporojkina"),
                new Student(96, null),
                new Student(25, "Verisaev"),
                new Student(49, "Porogov"),
                new Student(68, "Yarov"),
                new Student(38, "Mehilidze"));

        ArrayList<Student> filteredGroup = (ArrayList<Student>) school.levelOf(group, bound);

        Assert.assertThat(filteredGroup.size(), is(3));
        boolean result = filteredGroup.stream().allMatch(x -> x.getScore() > bound);
        Assert.assertTrue(result);
    }



    @Test
    public void when0To50() {
     School school = new School();
     List<Student> group = school.group;
     while (group.size() < this.groupSize) {
         group.add(new Student((int) (Math.random() * 100)));
     }
     Predicate<Student> filter = x -> x.getScore() <= 50;

     List<Student> filteredGroup = school.collect(group, filter);
     boolean result = filteredGroup.stream().allMatch(filter);

     Assert.assertTrue(result);
    }

    @Test
    public void when51To70() {
        School school = new School();
        List<Student> group = school.group;
        while (group.size() < this.groupSize) {
            group.add(new Student((int) (Math.random() * 100)));
        }
        Predicate<Student> filter = x -> x.getScore() > 50 && x.getScore() <= 70;

        List<Student> filteredGroup = school.collect(group, filter);
        boolean result = filteredGroup.stream().allMatch(filter);

        Assert.assertTrue(result);
    }

    @Test
    public void when71To100() {
        School school = new School();
        List<Student> group = school.group;
        while (group.size() < this.groupSize) {
            group.add(new Student((int) (Math.random() * 100)));
        }
        Predicate<Student> filter = x -> x.getScore() > 70;

        List<Student> filteredGroup = school.collect(group, filter);
        boolean result = filteredGroup.stream().allMatch(filter);

        Assert.assertTrue(result);
    }

    @Test
    public void whenListToMap() {
        School school = new School();

        List<Student> group = List.of(
                new Student(54, "Lisenko"),
                new Student(80, "Ahmedov"),
                new Student(25, "Verisaev"),
                new Student(68, "Yarov"),
                new Student(68, "Yarov"),
                new Student(68, "Yarov"),
                new Student(58, "Mehilidze"));

        Map<String, Student> resultMap = school.listToMap(group);

        for (Map.Entry<String, Student> st : resultMap.entrySet()) {
            System.out.println(st.getKey() + " " + st.getValue().getScore());
        }

        int resultOfAhmedov = resultMap.get("Ahmedov").getScore();

        assertThat(resultOfAhmedov, is(80));
        Assert.assertTrue(resultMap.containsKey("Yarov"));
        Assert.assertThat(resultMap.size(), is(5));
    }
}
