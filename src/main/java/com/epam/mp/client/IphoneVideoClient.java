package com.epam.mp.client;

import com.epam.mp.factory.AbstractVideoFactory;
import com.epam.mp.factory.IphoneVideoFactory;

public class IphoneVideoClient extends VideoClient {


    public AbstractVideoFactory createFactory() {
        return new IphoneVideoFactory();
    }
}
