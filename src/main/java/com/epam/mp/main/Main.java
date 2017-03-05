package com.epam.mp.main;

import com.epam.mp.client.AndroidVideoClient;
import com.epam.mp.client.BlackberryVideoClient;
import com.epam.mp.client.IphoneVideoClient;
import com.epam.mp.singleton.VideoHosting;

public class Main {

    public static void main(String[] args) {
        System.out.println(VideoHosting.getInstance().getVideoFactory(new IphoneVideoClient()));
        System.out.println(VideoHosting.getInstance().getVideoFactory(new AndroidVideoClient()));
        System.out.println(VideoHosting.getInstance().getVideoFactory(new BlackberryVideoClient()));

    }
}
