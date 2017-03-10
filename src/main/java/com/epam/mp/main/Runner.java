package com.epam.mp.main;

import com.epam.mp.pool.ObjectPool;
import com.epam.mp.prototype.Prototype;

public class Runner {

    public static void main(String[] args) {
        ObjectPool objectPool = new ObjectPool.ObjectPoolBuilder().build();
        System.out.println(objectPool.getObject());
        Prototype prototype = objectPool.getObject();
        System.out.println(prototype);
        objectPool.putObject(prototype);
        System.out.println(objectPool.getObject());
        objectPool.releaseAllObjects();
    }
}
