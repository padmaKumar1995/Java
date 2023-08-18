package org.example.bird;

import org.example.bird.enums.Bird;
import org.example.bird.enums.Color;

public abstract class BirdBase {
    public Bird type;
    public int height;
    public int weight;
    public Color color;

    public void sleep() {
        System.out.println("zzzz.....");
    }

    public void eat() {
        System.out.println("eating....");
    }
}
