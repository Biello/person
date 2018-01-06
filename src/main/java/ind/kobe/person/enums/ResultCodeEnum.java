package ind.kobe.person.enums;

/**
 * 统一维护返回编码
 * @Author: Bielu
 * @Date: Created on 0:30 2018/1/7
 */
public enum ResultCodeEnum {
    UNKONW_ERROT(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRESCHOOL_AGE(10, "学龄前儿童"),
    PRIMARY_SCHOOL(11, "小学生"),
    ;

    private int code;

    private String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
