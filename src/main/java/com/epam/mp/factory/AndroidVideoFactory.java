package com.epam.mp.factory;

import com.epam.mp.entity.AndroidVideo;
import com.epam.mp.entity.Resolution;
import com.epam.mp.entity.Video;

public class AndroidVideoFactory implements AbstractVideoFactory {

    public Video createHighResolutionVideo() {
        return new AndroidVideo(Resolution.HIGTH);
    }

    public Video createDefaultResolutionVideo() {
        return new AndroidVideo(Resolution.DEFAULT);
    }

    public Video createLowResolutionVideo() {
        return new AndroidVideo(Resolution.LOW);
    }
}
