package org.example;

import org.example.generics.vehicle.SchoolBus;
import org.example.generics.vehicle.Truck;
import org.example.generics.vehicle.models.goods.Cement;
import org.example.generics.vehicle.models.goods.Sand;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //String vs StringBuilder
        new StringVsStringBuilder().stringVsStringBuilder();

        //Generics
        Truck truck = new Truck();
        truck.load(new Sand());
        truck.load(new Cement());

        ArrayList<Sand> sands = new ArrayList<>();
        sands.add(new Sand());
        sands.add(new Sand());

        //this loadAll is possible becoz the method accepts List<? extends T>.
        //in here T is Goods since Truck is Vehicle<Goods>
        truck.loadAll(sands);
    }
}