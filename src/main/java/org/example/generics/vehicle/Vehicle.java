package org.example.generics.vehicle;

import java.util.List;
import java.util.Stack;

public class Vehicle<T> {
    private Stack<T> items = new Stack<>();
    private int capacity = 10;
    private int filled = 0;

    public void load(T item) {
        //check whether Vehicle can accommodate the items TODO
        filled++;
        items.push(item);
    }

    // loadAll(List<? extends T> items) accepts a bounded type, wild card generic list,
    // this is used to solve the invariant property of Java generics
    public void loadAll(List<? extends T> items) {
        //check whether Vehicle can accommodate the items TODO
        filled += items.size();
        this.items.addAll(items);
    }

    public T unload() {
        //check whether vehicle has load TODO
        filled--;
        return items.pop();
    }
}
