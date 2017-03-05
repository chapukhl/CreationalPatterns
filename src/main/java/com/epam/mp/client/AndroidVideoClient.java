package com.epam.mp.client;

import com.epam.mp.factory.AbstractVideoFactory;
import com.epam.mp.factory.AndroidVideoFactory;

public class AndroidVideoClient extends VideoClient {

    public AbstractVideoFactory createFactory() {
        return new AndroidVideoFactory();
    }
}
