package ru.job4j.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.io.FileReader;
import java.io.IOException;

public class AnalyzeTest {

    @Test
    public void whenLogFromTestSource() throws IOException {
        String in = "./data/testSource.log";
        String out = "./data/testTarget.csv";
        Analyze wrap = new Analyze();
        wrap.unavailable(in, out);
        BufferedReader br = new BufferedReader(new FileReader("./data/testTarget.csv"));
        assertThat(br.readLine(), is("10:58:13;10:59:24"));
    }
    @Test
    public void whenLogFromRealSource() throws IOException {
        String in = "./data/server.log";
        String out = "./data/unavailable.csv";
        Analyze wrap = new Analyze();
        wrap.unavailable(in, out);
        BufferedReader br = new BufferedReader(new FileReader("./data/unavailable.csv"));
        assertThat(br.readLine(), is("10:58:13;10:59:24"));
        assertThat(br.readLine(), is("11:01:15;11:02:46"));
        assertThat(br.readLine(), is("11:58:27;18:02:50"));
    }

}
