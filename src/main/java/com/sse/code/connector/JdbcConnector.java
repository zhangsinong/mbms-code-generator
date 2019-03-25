//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.connector;

import java.util.Objects;

public class JdbcConnector {
    private String userName;
    private String password;
    private String url;
    private Driver driver;

    public JdbcConnector() {
        this.driver = Driver.MYSQL;
    }

    public JdbcConnector(String userName, String password, String url) {
        this.driver = Driver.MYSQL;
        this.userName = userName;
        this.password = password;
        this.url = url;
    }

    public JdbcConnector(String userName, String password, String url, Driver driver) {
        this.driver = Driver.MYSQL;
        this.userName = userName;
        this.password = password;
        this.url = url;
        this.driver = driver;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            JdbcConnector that = (JdbcConnector)o;
            return Objects.equals(this.userName, that.userName) && Objects.equals(this.url, that.url);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.userName, this.password, this.url});
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setDriver(String driver) {
        this.driver = Driver.valueOf(driver);
    }
}
