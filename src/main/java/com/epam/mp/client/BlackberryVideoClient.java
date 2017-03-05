package com.epam.mp.client;

import com.epam.mp.exception.UnsupportedClientException;
import com.epam.mp.factory.AbstractVideoFactory;

public class BlackberryVideoClient extends VideoClient {

    public AbstractVideoFactory createFactory() {
        throw new UnsupportedClientException();
    }
}
