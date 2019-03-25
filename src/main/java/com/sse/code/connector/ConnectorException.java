//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.connector;

public class ConnectorException extends RuntimeException {
    public static int DRIVER_NOT_FOUND = 1;
    public static int CONNECTOR_EXCEPTION = 2;
    private int code;
    private String message;

    public ConnectorException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
