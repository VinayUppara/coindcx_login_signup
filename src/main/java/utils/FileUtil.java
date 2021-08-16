package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class FileUtil {

	//private FileUtil() {}

	private static final Logger log = LogManager.getLogger(FileUtil.class);
	public static RequestSpecification req;

	public static Properties getPropData() {
		Properties prop=new Properties();
		final File propertiesFile = new File("src/test/resources/user.properties");
		try(FileInputStream fileInputStream=new FileInputStream(propertiesFile)) {
			prop.load(fileInputStream);
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return prop;
	}

	public RequestSpecification getBaseURI() throws IOException
	{
		req=new RequestSpecBuilder().setBaseUri("https://api.coindcx.com/").build();
		return req;
	}


	public static String getJsonPath(String response,String key) throws IOException
	{
		
			JSONObject jsonObject = (JSONObject)JSONValue.parse(response);
			return jsonObject.get(key).toString();
		
	}



}

