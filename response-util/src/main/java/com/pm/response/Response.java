package com.pm.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Response {
    private String code;
    private String msg;

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
