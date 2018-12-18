package com.epam.se08.pool2;

import lombok.experimental.Delegate;

import java.io.Closeable;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPool {

    private static ConnectionPool pool = new ConnectionPool();
    private List<PooledConnection> freeConnections;
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private Integer connectionNumber;
    private Semaphore semaphore;
    private static Logger logger = Logger.getLogger(ConnectionPool.class.getName());

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setConnectionNumber(Integer connectionNumber) {
        this.connectionNumber = connectionNumber;
    }

    private ConnectionPool() {
    }

    public void initConnections() throws SQLException {
        try {
            Class.forName(driverClassName);
            semaphore = new Semaphore(connectionNumber);
            freeConnections = new LinkedList<PooledConnection>();
            for (int i = 0; i < connectionNumber; i++) {
                Connection connection = DriverManager
                        .getConnection(url, username, password);
                PooledConnection pooledConnection =
                        new PooledConnection(connection);
                freeConnections.add(pooledConnection);
            }
            logger.log(Level.INFO, connectionNumber + " connections created");
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public static ConnectionPool getInstance() {
        return pool;
    }

    public Connection getConnection() {
        try {
            semaphore.acquire();
            PooledConnection pooledConnection =
                    freeConnections.remove(0);
            return pooledConnection;
        } catch (InterruptedException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void closeConnections() {
        int releaseNumber = connectionNumber
                - semaphore.availablePermits();
        semaphore.release(releaseNumber);
    }

    private class PooledConnection implements Connection {

        @Delegate(excludes = {Closeable.class})
        private Connection connection;

        public PooledConnection(Connection c) throws SQLException {
            this.connection = c;
            this.connection.setAutoCommit(true);
        }

        @Override
        public void close() throws SQLException {
            if (connection.isReadOnly()) {
                connection.setReadOnly(false);
            }
            freeConnections.add(this);
            semaphore.release();
        }
    }
}

