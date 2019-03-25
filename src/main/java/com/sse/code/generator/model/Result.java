//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.generator.model;

import java.io.Serializable;

public final class Result implements Serializable {
    private static final long serialVersionUID = 777898778896772434L;
    private int code;
    private String message;
    private boolean success;
    private Object data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
        this.success = true;
    }

    public Result(int code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public Result(int code, String message, boolean success, Object data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public static Result success() {
        return new Result(200, "操作成功", true);
    }

    public static Result success(Object data) {
        return new Result(200, "操作成功", true, data);
    }

    public static Result error(String msg) {
        return new Result(422, msg, false);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
