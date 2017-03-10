package com.epam.mp.prototype;

public class PrototypeInstance implements Prototype {

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
