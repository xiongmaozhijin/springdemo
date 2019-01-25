package main.exception;

import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public static class Json {
        private int code;
        private String msg;

        public Json() {
        }

        public Json(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ShiroException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public Json handleShiroException(ShiroException e) {
        e.printStackTrace();
        String localizedMessage = e.getLocalizedMessage();
        log.error("shiro 鉴权或授权过程出错 " + localizedMessage);
        return new Json(401, localizedMessage);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Json handleException(Exception e) {
        e.printStackTrace();
        System.err.println("handleException. " + e.getLocalizedMessage());
        return new Json(405, "error " + e.getLocalizedMessage());
    }

}
