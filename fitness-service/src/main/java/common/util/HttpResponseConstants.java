package common.util;

/**
 * ClassName	: HttpResponseConstants
 * Function		: TODO
 * date 		: 2017年9月22日下午3:51:36
 * @author 		: taofeng
 * @version		: 1.0
 * @since   JDK 1.7
 */
public interface HttpResponseConstants {
	/**
	 * 公共
	 */
	public static class Public {
		//response code
		/**0**/
		public static final Integer SUCCESS_CODE = 0;
		/**1**/
		public static final Integer ERROR_CODE = 1;
		/**success**/
		public static final String SUCCESS = "success";
		/**保存成功**/
		public static final String SUCCESS_100 = "保存成功";
		/**新增成功**/
		public static final String SUCCESS_200 = "新增成功";
		/**修改成功**/
		public static final String SUCCESS_300 = "修改成功";
		/**删除成功**/
		public static final String SUCCESS_400 = "删除成功";
		/**操作成功**/
		public static final String SUCCESS_500 = "操作成功";
		/**error**/
		public static final String ERROR = "error";
		/**查询失败 **/
		public static final String ERROR_100 = "查询失败";
		/**新增失败 **/
		public static final String ERROR_200 = "新增失败";
		/**修改失败**/
		public static final String ERROR_300 = "修改失败"; 
		/**删除失败 **/
		public static final String ERROR_400 = "删除失败";
		/**导入失败**/
		public static final String ERROR_500 = "文件格式错误，导入失败";	
		/**操作失败**/
		public static final String ERROR_600 = "操作失败";
		/**参数错误**/
		public static final String ERROR_700 = "参数错误";
		/**未知异常**/
		public static final String ERROR_800 = "未知异常";
		/**账号或密码错误**/
		public static final String ERROR_900 = "账号或密码错误";

		public static final String BUY_COURSE_SUCCESS="购买成功";
		public static final String RESERVE_COURSE_SUCCESS="预约成功";
		public static final String BUY_COURSE_EXISTING="您已有该课程正在进行中";
	}
	
}
