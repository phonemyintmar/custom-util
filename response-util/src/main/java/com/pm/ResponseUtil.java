package com.pm;

import com.pm.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ResponseUtil {

    public static ResponseEntity<?> onDefaultSuccess(Object result) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResult(result);
        baseResponse.setCode("0000");
        baseResponse.setMessage("Action is successful");
        baseResponse.setRespondedAt(LocalDateTime.now());
        return ResponseEntity.ok(baseResponse);
    }

    public static ResponseEntity<?> onSuccess(String code, String msg, Object result) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResult(result);
        baseResponse.setCode(code);
        baseResponse.setMessage(msg);
        baseResponse.setRespondedAt(LocalDateTime.now());
        return ResponseEntity.ok(baseResponse);
    }

    public static ResponseEntity<?> onError(String code, String msg, HttpStatus status) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResult(null);
        baseResponse.setCode(code);
        baseResponse.setMessage(msg);
        baseResponse.setRespondedAt(LocalDateTime.now());
        return ResponseEntity.status(status).body(baseResponse);
    }

    public static ResponseEntity<?> on4xxError() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResult(null);
        baseResponse.setCode("8888");
        baseResponse.setMessage("Wrong request");
        baseResponse.setRespondedAt(LocalDateTime.now());
        return ResponseEntity.badRequest().body(baseResponse);
    }

    public static ResponseEntity<?> on5xxError() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResult(null);
        baseResponse.setCode("9999");
        baseResponse.setMessage("Something went wrong");
        baseResponse.setRespondedAt(LocalDateTime.now());
        return ResponseEntity.internalServerError().body(baseResponse);
    }
}
