package cn.lhz.common.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author lhz
 * @date 2019/11/26 23:58
 */
//lombok注解
@Data
public class BaseResult implements Serializable
{
    private static final String RESULT_OK = "ok";
    private static final String RESULT_NOT_OK = "not_ok";
    private static final String SUCCESS = "成功操作";

    private String result;
    private Object data;
    private String success;
    private Cursor cursor;
    private List<Error> errors;

    public static BaseResult ok()
    {
        return createResult(RESULT_OK, null, SUCCESS, null, null);
    }

    public static BaseResult ok(Object data)
        {
            return createResult(RESULT_OK, data, SUCCESS, null, null);
        }

    public static BaseResult notOk(List<Error>errors)
       {
           return createResult(RESULT_NOT_OK, null, "", null, errors);
       }

    private static BaseResult createResult(String result, Object data, String success, Cursor cursor,
                                           List<Error> errors)
    {
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(result);
        baseResult.setData(data);
        baseResult.setSuccess(success);
        baseResult.setCursor(cursor);
        baseResult.setErrors(errors);
        return baseResult;
    }


    //分页内部类
    @Data
    public static class Cursor
    {
        private int total;
        private int offset;
        private int limit;
    }

    //错误内部类
    @Data
    @AllArgsConstructor//全部参数构造函数
    public static class Error
    {
        private String field;
        private String message;
    }


}
