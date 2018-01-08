package ind.kobe.person.utils;

import ind.kobe.person.bean.Result;

/**
 * @Author: Bielu
 * @Date: Created on 23:54 2018/1/6
 */
public class ResultUtil {

    public static Result<Object> success(Object obj) {
        Result<Object> result = new Result<Object>(0, "success", obj);
        return result;
    }

    public static Result<Object> success() {
        return success(null);
    }

    public static Result<?> error(int code, String msg) {
        Result<?> result = new Result<Object>(code, msg);
        return result;
    }


}
