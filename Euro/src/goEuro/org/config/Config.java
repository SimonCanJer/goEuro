package goEuro.org.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import goEuro.org.interfaces.IBusinessLogics;
import goEuro.org.io.interfaces.IGenericIO;

public class Config {
	IBusinessLogics m_IBusinessLogics;
	static class Container
	{
		Config m_host;
		
		
		
	}
	static Container sm_container=new Container();
	static public Config doConfig() throws Exception
	{
		if(sm_container.m_host==null)
		synchronized(sm_container)
		{
			if(sm_container.m_host==null)
			{
				initInstance(sm_container);
			}
			
		}
		return sm_container.m_host;
	}
	private static void initInstance(Container container) throws Exception {
		 container.m_host=new Config().load();
	}
	static protected <IO> IGenericIO<IO> createIO(JSONObject json, String  strKey,String strBaseDirectoryKey) throws Exception
	{
		return ((IGenericIO<IO>)(Class.forName((String) json.get(strKey)).newInstance())).setBaseDirectory((String) json.get(strBaseDirectoryKey));
	}
	
	
	private Config load() throws Exception {
		JSONObject json= (JSONObject) new JSONParser().parse(new FileReader(Constants.CONFIG_FILE));
		m_IBusinessLogics=createBusinessLogics(json).setInput(createIO(json,Constants.IMPLEMENTS_INPUT,Constants.HTTP_SERVER)).
		setOutput(createIO(json,Constants.IMPLEMENTS_OUTPUT,Constants.LOCAL_REPOSITORY));
		return this;
	}
	private IBusinessLogics createBusinessLogics(JSONObject json)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (IBusinessLogics)Class.forName((String) json.get(Constants.IMPLEMENTS_LOGIC)).newInstance();
	}
	public IBusinessLogics itsBuisnessLogics()
	{
		return m_IBusinessLogics;
	}
	

}
