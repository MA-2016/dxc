package com.mobileai.dxc.util;

import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @param to 被发送的手机号码
 * @param status 状态码：1.验证短信 2.通知短信（商家）3.通知短信（用户）
 * 
 * @return 随机数验证码
 */
public class SendMsgUtils {

    /**
     * ACCOUNT_SID:开发者主账号ID(注册后自动生成)
     */
    public static final String ACCOUNT_SID = "d8f51d252cef438cb65d90e912ce51c2";

    /**
     * AUTH_TOKEN:开发者账号认证密匙(注册后自动生成)
     */
    public static final String AUTH_TOKEN = "f4109d797322492b80b1ebf7e2816a6f";

    /**
     * Validate_URL:验证请求地址
     */
    public static final String Validate_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";

    /**
     * Inform_URL:通知请求地址
     */
    public static final String Inform_URL = "https://api.miaodiyun.com/20150822/affMarkSMS/sendSMS";

    /**
     * RESP_DATA_TYPE:数据返回格式为JSON格式
     */
    public static final String RESP_DATA_TYPE = "json";

    /**
     * randNum:生成的验证码随机数
     */
    static String randNum = createRandNum();

    /**
     * smsContent_validate:短信内容(短信签名+短信内容，注意要和配置的模板一致，否则报错)
     */
    public static String smsContent_validate = "【稻香村】尊敬的用户，您的验证码为" + randNum;
    public static String smsContent_inform_seller = "【稻香村】亲爱的用户，您有新的订单等待确认，请及时登录。";
    public static String smsContent_inform_user = "【稻香村】亲爱的用户，您的申请已经被接受，请在约定时间到达当地享受农家乐的欢愉吧！";

    /**
     * 
     * @Title：sendMsgTo
     * @Description：发送短信验证码 @param：
     * @return：String
     */
    public static String sendMsgTo(String to, int status) {

        /**
         * 获取时间戳
         */
        String timestamp = getTimestamp();

        /**
         * 获取签名
         */
        String sig = MD5Utils.md5(ACCOUNT_SID + AUTH_TOKEN + timestamp);

        /**
         * 要提交的post数据
         */
        String http_post_1 = "accountSid=" + ACCOUNT_SID + "&smsContent_validate=" + smsContent_validate + "&to=" + to
                + "&timestamp=" + timestamp + "&sig=" + sig + "&respDataType=" + RESP_DATA_TYPE;

        String http_post_2 = "accountSid=" + ACCOUNT_SID + "&smsContent_validate=" + smsContent_inform_seller + "&to="
                + to + "&timestamp=" + timestamp + "&sig=" + sig + "&respDataType=" + RESP_DATA_TYPE;

        String http_post_3 = "accountSid=" + ACCOUNT_SID + "&smsContent_validate=" + smsContent_inform_user + "&to="
                + to + "&timestamp=" + timestamp + "&sig=" + sig + "&respDataType=" + RESP_DATA_TYPE;

        OutputStreamWriter osw = null;

        switch (status) {
        case 1:
            try {
                URL url = new URL(Validate_URL);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setConnectTimeout(5000);
                conn.setReadTimeout(20000);
                osw = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
                osw.write(http_post_1);
                osw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        case 2:
            try {
                URL url = new URL(Inform_URL);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setConnectTimeout(5000);
                conn.setReadTimeout(20000);
                osw = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
                osw.write(http_post_2);
                osw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        case 3:
            try {
                URL url = new URL(Inform_URL);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setConnectTimeout(5000);
                conn.setReadTimeout(20000);
                osw = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
                osw.write(http_post_3);
                osw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        default:
            return "error";
        }
        return randNum.toString();

    }

    /**
     * 
     * @Title:getTimestamp
     * @Description:获取时间戳
     * @param:
     * @return:String
     */
    public static String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(new Date());
        return date;
    }

    /**
     * 
     * @Title:createRandNum
     * @Description:生成一个6位的随机码
     * @param:
     * @return:String
     */
    public static String createRandNum() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= 5; i++) {
            String s = random.nextInt(10) + "";
            sb.append(s);
        }
        return sb.toString();
    }

}