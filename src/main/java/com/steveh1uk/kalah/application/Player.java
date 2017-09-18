package com.steveh1uk.kalah.application;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.summingInt;

public class Player {

    private final int id;

    private final Store store = new Store(0, this);

    private final List<House> houses = new ArrayList<>();

    public Player(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }

    List<House> getHouses() {
        return houses;
    }

    void addHouse(int intialSeeds) {
        houses.add(new House(intialSeeds, this));

    }

    int countSeedsInHouses() {
        return houses.stream().mapToInt(House::getSeeds).sum();
    }

    Store getStore() {
        return store;
    }

    void calculateOppositeHouses(Player otherPlayer) {
        for (int i = 0; i < houses.size(); i++) {
            houses.get(i).setOppositeHouse(otherPlayer.getHouses().get(houses.size() - ( 1 + i)) );
        }
    }

    public void moveRemainingSeedsToStore() {
        store.addSeeds(houses.stream().mapToInt(House::removeAllSeeds).sum());
    }
}