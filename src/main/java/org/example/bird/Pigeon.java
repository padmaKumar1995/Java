package org.example.bird;

import org.example.bird.enums.Bird;
import org.example.bird.enums.Color;

public class Pigeon extends BirdBase {

    public Pigeon(int height, int weight, Color color) {
        this.type = Bird.Pigeon;
        this.height = height;
        this.weight = weight;
        this.color = color;
    }
}
