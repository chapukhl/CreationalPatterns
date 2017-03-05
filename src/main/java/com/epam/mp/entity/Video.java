package com.epam.mp.entity;

public abstract class Video  {

    protected Resolution resolution;

    public Video(Resolution resolution) {
        this.resolution = resolution;
    }
}
