package ind.kobe.person.exception;

import ind.kobe.person.enums.ResultCodeEnum;

/**
 * 自定义统一异常
 * @Author: Bielu
 * @Date: Created on 0:11 2018/1/7
 */
// 注意继承RuntimeException， Spring只对RuntimeException进行事务回滚
public class PersonException extends RuntimeException {
	
	/**
	 * generated version ID
	 */
	private static final long serialVersionUID = 5721861430106678585L;
	
	private int code;

    public PersonException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMsg());
        this.code = resultCodeEnum.getCode();
    }

    public PersonException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
