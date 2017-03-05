package com.epam.mp.client;

import com.epam.mp.entity.Video;
import com.epam.mp.factory.AbstractVideoFactory;

public abstract class VideoClient {

    public abstract AbstractVideoFactory createFactory();
}
