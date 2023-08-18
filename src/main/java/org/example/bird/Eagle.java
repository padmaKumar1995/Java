package org.example.bird;

import org.example.bird.enums.Bird;
import org.example.bird.enums.Color;
import org.example.bird.interfaces.Flyable;
import org.example.bird.interfaces.Runnable;

public class Eagle extends BirdBase implements Flyable, Runnable {

    public Eagle(int height, int weight, Color color) {
        this.type = Bird.Eagle;
        this.height = height;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public void fly() {
        System.out.println("flying...");
    }

    @Override
    public void run() {
        System.out.println("running...");
    }
}
