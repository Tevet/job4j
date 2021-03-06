package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {

    @Test
    public void whenFirstMax() {
        SqMax check = new SqMax();
        int result = check.max(5, 3, 2, -7);
        Assert.assertThat(result, is(5));
    }

    @Test
    public void whenSecondMax() {
        SqMax check = new SqMax();
        int result = check.max(0, 10, 3, 9);
        Assert.assertThat(result, is(10));
    }

    @Test
    public void whenThirdMax() {
        SqMax check = new SqMax();
        int result = check.max(8, 8, 88, 8);
        Assert.assertThat(result, is(88));
    }

    @Test
            public void additionalTest() {
        int a = 4, b = 1, c = 5, d = 3,
        exp = 5,
        out = SqMax.max(a, b, c, d);
        Assert.assertEquals(exp, out);

    }

    @Test
    public void additionalTest2() {
        int a = 1, b = 2, c = 5, d = 7,
        exp = 7,
        out = SqMax.max(a, b, c, d);
        Assert.assertEquals(exp, out);

    }

}
