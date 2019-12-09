package cn.lhz.common.hystrix;

import cn.lhz.common.constants.HttpStatusConstants;
import cn.lhz.common.dto.BaseResult;
import cn.lhz.common.utils.MapperUtils;

import java.util.*;

/**
 * 通用的熔断方法
 *
 * @author Neo
 * @date 2019/11/28 0:08
 */
public class FallBack
{
    public FallBack()
    {
    }

    /**
     * 502错误
     * @return
     */
    public static  String badGetway(){
        BaseResult.Error error = new BaseResult.Error(
                       String.valueOf(HttpStatusConstants.BAD_GETWAT.getStatus()), HttpStatusConstants.BAD_GETWAT.getContent()
               );
               List<BaseResult.Error> errors = new ArrayList<>();
               errors.add(error);
               BaseResult baseResult = BaseResult.notOk(errors);
        try
        {
            return MapperUtils.obj2json(baseResult);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

}
