package com.epam.mp.factory;

import com.epam.mp.entity.IphoneVideo;
import com.epam.mp.entity.Resolution;
import com.epam.mp.entity.Video;

public class IphoneVideoFactory implements AbstractVideoFactory {
    public Video createHighResolutionVideo() {
        return new IphoneVideo(Resolution.HIGTH);
    }

    public Video createDefaultResolutionVideo() {
        return new IphoneVideo(Resolution.DEFAULT);
    }

    public Video createLowResolutionVideo() {
        return new IphoneVideo(Resolution.LOW);
    }
}
