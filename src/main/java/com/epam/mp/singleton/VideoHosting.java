package com.epam.mp.singleton;

import com.epam.mp.client.VideoClient;
import com.epam.mp.factory.AbstractVideoFactory;

public class VideoHosting {

    private VideoHosting() {

    }

    public static VideoHosting getInstance() {
        return VideoHostingHolder.instance;
    }

    private static class VideoHostingHolder {
        private static final VideoHosting instance = new VideoHosting();
    }

    public AbstractVideoFactory getVideoFactory(VideoClient videoClient){
        return videoClient.createFactory();
    }




}
