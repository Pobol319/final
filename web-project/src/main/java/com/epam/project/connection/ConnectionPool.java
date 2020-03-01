package com.epam.project.connection;


import com.epam.project.exceptions.ConnectionFactoryException;
import com.epam.project.exceptions.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger LOG = LogManager.getLogger(ConnectionPool.class);

    private static int MAX_POOL_SIZE = 13;
    private Semaphore semaphore = new Semaphore(MAX_POOL_SIZE);
    private static final AtomicReference<ConnectionPool> instance = new AtomicReference<>();

    private Queue<ProxyConnection> availableConnections;
    private Queue<ProxyConnection> connectionInUse;

    private Lock connectionsLock = new ReentrantLock();

    private ConnectionPool() {
        availableConnections = new ArrayDeque<>();
        connectionInUse = new ArrayDeque<>();
        createPool();
    }

    private void createPool() {
        ConnectionFactory factory = new ConnectionFactory();
        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            try {
                Connection connection = factory.create();
                ProxyConnection proxyConnection = new ProxyConnection(connection, this);
                availableConnections.add(proxyConnection);
            } catch (ConnectionFactoryException e) {
                LOG.error("Error with creation of connection", e);
            }
        }
    }

    public static ConnectionPool getInstance() {
        Lock lock = new ReentrantLock();
        if (instance.get() == null) {
            lock.lock();
            try {
                try {
                    instance.compareAndSet(null, new ConnectionPool());
                } catch (ConnectionFactoryException e) {
                    throw new ConnectionPoolException("Problems with ConnectionPool", e);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance.get();
    }

    public void returnConnection(ProxyConnection proxyConnection) {
        connectionsLock.lock();
        try {
            if (connectionInUse.contains(proxyConnection)) {
                availableConnections.add(proxyConnection);
                connectionInUse.poll();
            }
        } finally {
            connectionsLock.unlock();
            semaphore.release();
        }
    }

    public ProxyConnection getConnection() {
        ProxyConnection proxyConnection;
        try {
            semaphore.acquire();
            connectionsLock.lock();
            proxyConnection = availableConnections.poll();
            connectionInUse.add(proxyConnection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Problems with ConnectionPool", e);
        } finally {
            connectionsLock.unlock();
        }
        return proxyConnection;
    }
}
