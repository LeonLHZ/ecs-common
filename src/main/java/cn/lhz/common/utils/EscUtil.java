package cn.lhz.common.utils;

import java.math.BigInteger;
import java.security.*;

/**
 * @author Neo
 * @date 2019/10/23 23:37
 */
public class EscUtil
{
    public EscUtil()
    {
    }

    /**
     * md5加密
     *
     * @param plainText
     * @return
     */
    public static String md5(String plainText)
    {
        byte[] secretBytes = null;
        try
        {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException();
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);

        for (int i = 0; i < 32 - md5code.length(); i++)
        {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    /**
     *
     * @param value
     * @param secret 异或运算字符
     * @return
     */
    private  static String secret(String value, char secret)

    {

        byte[] bt = value.getBytes();//将需要加密的内容转换为字节数组

        for (int i = 0; i < bt.length; i++)

        {

            bt[i] = (byte) (bt[i] ^ (int) secret);//通过异或运算进行加密

        }

        String newresult = new String(bt, 0, bt.length);//将加密后的字符串保存到 newresult 变量中

        return newresult;

    }

    public  static String encryption(String s){
        return secret(s,'A');
    }

    /**
    * 加密，把一个字符串在原有的基础上+1
    * @param data 需要解密的原字符串
    * @return 返回解密后的新字符串
    */
     public static String encode(String data) {
        //把字符串转为字节数组
          byte[] b = data.getBytes();
          //遍历
          for(int i=0;i<b.length;i++) {
              b[i] += 1;//在原有的基础上+1
          }
          return new String(b);
      }

    /**
        * 解密：把一个加密后的字符串在原有基础上-1
        * @param data 加密后的字符串
        * @return 返回解密后的新字符串
        */
       public static String decode(String data) {
           //把字符串转为字节数组
           byte[] b = data.getBytes();
           //遍历
           for(int i=0;i<b.length;i++) {
               b[i] -= 1;//在原有的基础上-1
           }
           return new String(b);
       }

}
