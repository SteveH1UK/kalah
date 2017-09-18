package com.steveh1uk.kalah.application;

import java.util.List;

/**
 *  This contains a circular list that you navigate in anti-clockwise direction
 */
public class CircularList<T> {

    private final List<T> items;
    private int currentIndex;

    public CircularList(List<T> items) {
        this.items = items;
    }

    public T retrieveCurrentItem(int index) {
        currentIndex = index;
        return getItem();
    }

    public T retrieveNextItem() {
        if (currentIndex == items.size()) {
            currentIndex = 0;
        }
        return getItem();
    }

    private T getItem() {
        return items.get(currentIndex ++);
    }

    @Override
    public String toString() {
        return "CircularList{" +
                "items=" + items +
                '}';
    }
}
