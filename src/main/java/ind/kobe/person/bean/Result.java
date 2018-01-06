package ind.kobe.person.bean;

/**
 * 统一返回对象
 * @Author: Bielu
 * @Date: Created on 23:43 2018/1/6
 */
public class Result<T> {

    // 错误码
    private int code;

    // 提示信息
    private String msg;

    // 返回内容
    private T data;

    public Result(int code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public Result(int code, String msg, T data) {
        this(code, msg);
        this.setData(data);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
