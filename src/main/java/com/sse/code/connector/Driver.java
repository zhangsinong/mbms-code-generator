//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.connector;

public enum Driver {
    MYSQL("com.mysql.jdbc.Driver"),
    ORACLE("");

    private String path;

    private Driver(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
