package com.epam.mp.factory;

import com.epam.mp.entity.Video;

public interface AbstractVideoFactory {

    Video createHighResolutionVideo();

    Video createDefaultResolutionVideo();

    Video createLowResolutionVideo();

}
