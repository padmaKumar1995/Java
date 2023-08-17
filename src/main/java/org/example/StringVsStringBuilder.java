package org.example;

public class StringVsStringBuilder {
    public void stringVsStringBuilder() {
        String s = "value";

        //performs slower
        String s1 = "";
        Long start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            s1 += s;
        }
        Long end = System.currentTimeMillis();
        System.out.printf("time = %d%n", end - start);

        //performs faster
        StringBuilder sb = new StringBuilder();
        Long start1 = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            sb.append(s);
        }
        Long end1 = System.currentTimeMillis();
        System.out.printf("time = %d%n", end1 - start1);
    }
}
