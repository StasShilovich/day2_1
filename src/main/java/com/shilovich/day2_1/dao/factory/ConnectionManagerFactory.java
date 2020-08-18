package com.shilovich.day2_1.dao.factory;

import com.shilovich.day2_1.dao.connection.ConnectionManager;
import com.shilovich.day2_1.dao.connection.impl.ConnectionManagerImpl;

public final class ConnectionManagerFactory {
    private static final ConnectionManagerFactory instance = new ConnectionManagerFactory();

    private final ConnectionManager connectionManager = new ConnectionManagerImpl();

    private ConnectionManagerFactory() {
    }

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }

    public static ConnectionManagerFactory getInstance() {
        return instance;
    }
}