package ind.kobe.person.utils;

import ind.kobe.person.bean.Result;

/**
 * @Author: Bielu
 * @Date: Created on 23:54 2018/1/6
 */
public class ResultUtil {

    public static Result success(Object obj) {
        Result result = new Result(0, "success", obj);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(int code, String msg) {
        Result result = new Result(code, msg);
        return result;
    }


}
