package org.example.bird;

import org.example.bird.enums.Bird;
import org.example.bird.enums.Color;

public class Ostrich extends BirdBase implements Runnable {

    public Ostrich(int height, int weight, Color color) {
        this.type = Bird.Ostrich;
        this.height = height;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public void run() {
        System.out.println("running...");
    }
}
