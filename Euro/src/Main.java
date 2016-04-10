import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import goEuro.org.blogic.BusinessLogics;
import goEuro.org.config.Config;
import goEuro.org.io.implement.file.FileOuput;
import goEuro.org.io.implement.web.WebInput;

public class Main {

	public static void main(String[] args) {
		
		args= new String[]{"Prague"};
		try {
			Config.doConfig().itsBuisnessLogics().go(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

}
