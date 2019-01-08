package service.commonService.util.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092400586218";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key =
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDtDEUaS2Dcalll\n" +
            "Q6igOmBf5sgNsHkNiay2u8mlG9WVXhOONrjxeLBrPOQxpGiFkGL7HBDdg459R+tZ\n" +
            "CRgdDzP4GSyBVeNi9YCwK5LAiECU5bBBTYJJ1x2eiuSy2Fyo44bNsjV83vlFx8mr\n" +
            "4D3hHaGp9ke9dGPLTahsXAMRRloCLQja7RwEIHibTQENUkzxIdxo5LEs178TcL28\n" +
            "bgeF6i6PDhX6Uj5U0+SvlJOqf45d+8T76o4zCoAXgynHPwj+2qH72hH1cVdh5upB\n" +
            "oHZruafqu0ybXzwfxJE9FJfGmNhfUsw3637V600/jam4nXKbkq+CCIUHJ6Fpuhqe\n" +
            "FrprFhBzAgMBAAECggEALn43l36tUs3xFrF8g2Cvwl+LYVP5ijQ0keqnFCEvdQps\n" +
            "n3oQMBxRzda1kx8B+SBmqYXJsQi6i8vtVxs3hYuTz9dwKTXlUWWBhgwlzmlq8UlT\n" +
            "lptTMJRmlM/9Jy7UjbOCnxmS8Bjzn0IeRf3HZT3glWteisQnRprGq+ooF91Kjh5S\n" +
            "d5oAe6SiZ9r2sCmIgLJqO975iuFANDHBO5YE5DMarbiOoHx4ZNkIXXBlY1x7WJga\n" +
            "XsztVNHU6ASGpdCv8N+iPA6auZzK8wHA4NYovs7ukTsMwZtxao+OB0Evc0l08Z0c\n" +
            "66npUfBdshIcreFVsUrJUJl834cA31CcLs7GNxTOUQKBgQD58ISAjtsTO7FMw6ud\n" +
            "z9Zad338lwlLTzC0mOxkyUbdnzMKdPXlg4NTrJylLk6AZ3bfj3T1/R4s3k2ajADH\n" +
            "ipc9sSE1iCw/axNjzCcy1CIz/UchRfSdCdQ3T1/x6y3re0JSTV3ug/6qABcP7RKB\n" +
            "RrWTbW9q+o1Wl97CagvzqWycZwKBgQDyy7qKN8nBsbbmDiND5djurbPfIOx2w9pG\n" +
            "xZj3u+GYidJGaWB40Pe3jz3R+GPn5up9AZB6gEQo9vrfr2gLVM3x8MPMm/ZqD9Ol\n" +
            "orO+5IN4OeYg9tn4oLvhgBqQVqPCzpgDhSoBDCUgblltx+ryPDK8fvklqPIS7d52\n" +
            "IPGK2iNkFQKBgFU8jxOApHmkq8xwFoDVNlbX1WFk6MiEEyoj1MpyUfaWqkNwq8M/\n" +
            "3HOWtD0o06C6qDGJrOuPDNFkZrbD9CgYvYdOdvLYo65lB9HK97s/2QI96BoSz18W\n" +
            "0QajzSale52JBY8nz1beMOUs7rCBuwPXZ2kFsy+ajsTvOgq3O6g3KVEVAoGBAIjK\n" +
            "BRe4JKBO+oeUcYPgbB7UmGFekDq9Ty3OR8dS/9/Lzj9DQUnwGZA+UIsKkWbm7zds\n" +
            "eTS7LSuTMnZxwYGYzsq/ZeDSAbtxnUFVcEVdQ0CqBiCOUvHDxPZgERc+6NZpRLW/\n" +
            "AZJDgGtMIHA8UP8WsVMHimEQVQobH9mX593d1lCdAoGBAKuDn7Y/DVIYnNy2NDCf\n" +
            "PLOf3kfG6JRFXIvJdq7oy/PDdzdG0giX/5gF+UmUPuyEaRd3TnrxvugZqESJZ9wB\n" +
            "Y4gbRqgq6PbXmMDG3OyAbKkA+2JN40vhbW1V29ZBgMmVWoWQB8MlyhW6BsVFg30o\n" +
            "5OnX5J9PCBs3354nP35YuIWW";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7QxFGktg3GpZZUOooDpgX+bIDbB5DYmstrvJpRvVlV4Tjja48XiwazzkMaRohZBi+xwQ3YOOfUfrWQkYHQ8z+BksgVXjYvWAsCuSwIhAlOWwQU2CSdcdnorksthcqOOGzbI1fN75RcfJq+A94R2hqfZHvXRjy02obFwDEUZaAi0I2u0cBCB4m00BDVJM8SHcaOSxLNe/E3C9vG4Hheoujw4V+lI+VNPkr5STqn+OXfvE++qOMwqAF4Mpxz8I/tqh+9oR9XFXYebqQaB2a7mn6rtMm188H8SRPRSXxpjYX1LMN+t+1etNP42puJ1ym5KvggiFByehaboanha6axYQcwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

//    public static String notify_url ="http://localhost:8080/success.html";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    public static String return_url="http://localhost:8080/login3.html";
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

