package com.epam.mp.pool;

import com.epam.mp.exception.GetFromPoolException;
import com.epam.mp.prototype.Prototype;
import com.epam.mp.prototype.PrototypeInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ObjectPool {

    private static Logger logger = LoggerFactory.getLogger(ObjectPool.class);

    private static final int DEFAULT_OBJECT_NUMBER = 2;
    private static final long DEFAULT_DELAY_TIME = 5000;

    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);

    private static Lock locking = new ReentrantLock();

    private static ObjectPool instance;


    private long delayTime;


    private BlockingQueue<Prototype> prototypes;


    private ObjectPool() {
        prototypes = new ArrayBlockingQueue<>(DEFAULT_OBJECT_NUMBER);
        FillThePool();

    }


    private void FillThePool() {
        int capacity = prototypes.remainingCapacity();
        for (int i = 0; i < capacity; i++) {
            prototypes.add(new PrototypeInstance());
        }
    }


    private static ObjectPool getInstance() {
        if (!instanceCreated.get()) {
            locking.lock();
            try {
                if (!instanceCreated.get()) {
                    instance = new ObjectPool();
                    instanceCreated.set(true);
                }
            } finally {
                locking.unlock();
            }
        }
        return instance;
    }


    public Prototype getObject() {
        Prototype prototype;
        try {
            prototype = tryToGetObjectFromPool();
        } catch (InterruptedException e) {
            throw new GetFromPoolException("Object isn't available now. Try later)");
        }

        return prototype;
    }

    private Prototype tryToGetObjectFromPool() throws InterruptedException {
        if (instanceCreated.get()) {
            return prototypes.take();
        } else {
            throw new GetFromPoolException("Cannot get object! Instance is not availuble");
        }
    }

    public void putObject(Prototype prototype) {
        try {
            prototypes.put(prototype);
        } catch (InterruptedException e) {
            logger.error("Cannot put object: " + e);
        }
    }

    public void releaseAllObjects() {
        instanceCreated.set(false);
        try {
            waitAllObjects();
        } catch (InterruptedException e) {
            logger.error("Interrupted exception {}", e);
        }
        prototypes.clear();
    }

    private void waitAllObjects() throws InterruptedException {
        long delay = delayTime != 0 ? delayTime : DEFAULT_DELAY_TIME;
        TimeUnit.MILLISECONDS.sleep(delay);
    }


    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public static class ObjectPoolBuilder {

        private ObjectPool objectPool;


        public ObjectPoolBuilder() {
            objectPool = getInstance();
        }


        public ObjectPoolBuilder delayTime(long delayTime) {
            objectPool.setDelayTime(delayTime);
            return this;
        }


        public ObjectPool build() {
            return objectPool;
        }
    }

}
