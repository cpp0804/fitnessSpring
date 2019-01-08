package common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * ClassName	: CommonUtils
 * Function		: TODO
 * date 		: 2017年5月7日下午6:09:01
 *
 * @author dean
 * @version        :
 * @since JDK 1.7
 */
public class CommonUtils {

    /**
     * 首字母大写，in:deleteDate，out:DeleteDate
     */
    public static String upperHeadChar(String in) {
        String head = in.substring(0, 1);
        String out = head.toUpperCase() + in.substring(1, in.length());
        return out;
    }

    /**
     * 将字符串 "1,2,3" 转为 List<Integer>
     *
     * @return
     */
    public static List<Integer> idsArrayToList(String ids) {

        List<Integer> list = new ArrayList<Integer>();

        for (String id : ids.split(",")) {
//		System.out.println(roleId);
            if (!StringUtils.isEmpty(id))
                list.add(Integer.parseInt(id));
        }
        return list;

    }

    /**
     * 生成随即6位密码
     *
     * @param length
     * @return
     */

    public static String getRandomPassword(int length) {

        String randString = "0123456789";// ésaeoeo"ao§c”"Ycs"a-—cnot|"a,^2 ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
        Random random = new Random();
        // c>>~a^Pésaeoeoa-—cnot|
        String randomPassword = "";
        for (int i = 1; i <= length; i++) {
            randomPassword += String.valueOf(randString.charAt(random.nextInt(randString.length())));

        }

        return randomPassword;
    }

    //
    public static String generateQRCode() {

        return Integer.toString(new Random().nextInt(89999999) + 10000000);
    }

    //
    public static String generateQRCodeFileName() {

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        /*	return df.format(new Date()) + new Random().nextInt(1000)+".jpg";*/
        return df.format(new Date()) + (new Random().nextInt(899999) + 100000) + ".jpg";
    }

    public static String QRCODE_BASE_PATH = "/bspheis-admin/upload/Qrimages/";
    public static String EQUIPMENT_QRCODE_BASE_PATH = "/bspheis-admin/upload/equipmentQrcode/";

}
