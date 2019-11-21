package xyz.ieden.core.common.exception;

/**
 * @author lianghongwei01
 * @version 1.0.1
 * @date 2019/11/21 15:26
 */
public class EdenException extends RuntimeException {

    private Integer code;
    private String msg;

    public EdenException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public EdenException(String message, Integer code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public EdenException(String message, Throwable cause, Integer code, String msg) {
        super(message, cause);
        this.code = code;
        this.msg = msg;
    }

    public EdenException(Throwable cause, Integer code, String msg) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public EdenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code, String msg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.msg = msg;
    }
}
