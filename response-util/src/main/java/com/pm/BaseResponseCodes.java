package com.pm;

import com.pm.response.Response;

public class BaseResponseCodes {
    private static final Response SUCCESS = new Response("0000","Action is successful");
    private static final Response FAIL = new Response("9999","Something went wrong");
}
