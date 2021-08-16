package utils;

import groovy.json.StringEscapeUtils;

public class PayLoad {

	public static String invalidEmailData ="{\n\t\"email\":\"test\", \n\t\"password\":\"Test@123\"\n}";

	public static String invalidPasswordData ="{\n\t\"email\":\"test@gmail.com\", \n\t\"password\":\"Test123\"\n}";

	public static String unregisteredData ="{\n\t\"email\":\"test@gmail.com\", \n\t\"password\":\"Test@123\"\n}";

	public static String registeredInvalidEmailData = "{\n\t\"email\":\"test@gmail.com\", \n\t\"password\":\"@vinNIV123\"\n}";

	public static String registeredInvalidPasswordData = "{\n\t\"email\":\"vinay.aftermath@gmail.com\", \n\t\"password\":\"@Test123\"\n}";

	public static String registeredValidData = "{\n\t\"email\":\"vinay.aftermath@gmail.com\", \n\t\"password\":\"@vinNIV123\"\n}";

	public static String unescapePayload(String teString) {
		return StringEscapeUtils.unescapeJava(teString);
	}
}
