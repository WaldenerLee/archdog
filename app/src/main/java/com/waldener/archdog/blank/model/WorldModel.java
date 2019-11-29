package com.waldener.archdog.blank.model;

public class WorldModel {
    private String world;

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    @Override
    public String toString() {
        return "WorldModel{" +
                "world='" + world + '\'' +
                '}';
    }
}
