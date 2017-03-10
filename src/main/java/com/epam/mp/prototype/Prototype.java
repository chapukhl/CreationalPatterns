package com.epam.mp.prototype;

public interface Prototype extends Cloneable {

    Object clone() throws CloneNotSupportedException;

}
