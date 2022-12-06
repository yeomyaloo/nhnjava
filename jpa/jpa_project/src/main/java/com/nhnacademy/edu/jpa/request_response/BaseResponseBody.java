package com.nhnacademy.edu.jpa.request_response;



import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

//@ApiModel
@Data
public class BaseResponseBody {
    //@ApiModelProperty(name="응답 메시지", example = "정상")
    String message = null;
    //@ApiModelProperty(name="응답 코드", example = "200")
    HttpStatus statusCode = null;

    public BaseResponseBody() {}

    public BaseResponseBody(HttpStatus statusCode){
        this.statusCode = statusCode;
    }

    public BaseResponseBody(HttpStatus statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }

    public static BaseResponseBody of(HttpStatus statusCode, String message) {
        BaseResponseBody body = new BaseResponseBody();
        body.message = message;
        body.statusCode = statusCode;
        return body;
    }



}
