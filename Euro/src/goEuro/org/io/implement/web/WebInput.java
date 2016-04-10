package goEuro.org.io.implement.web;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import goEuro.org.io.interfaces.IGenericIO;
import goEuro.org.io.interfaces.IGenericInput;

public class WebInput implements IGenericIO<InputStream>{

	private static final String DEFAULT_METHOD = "GET";
	private static final int    DEFAULT_PORTION_SIZE=1024;
	String m_strMethod=DEFAULT_METHOD;
	String m_strServer="";
	String m_strURL=m_strServer;
	OutputStream m_os;
	int m_iBufferSize=DEFAULT_PORTION_SIZE;
	@Override
	public IGenericIO<InputStream> setBaseDirectory(String str) {
		m_strServer=str;
		return this;
		
	}
	public WebInput()
	{
		
	}
	@Override
	public InputStream openTarget(String strSrc) {
		try
		{
		  m_strURL= String.format("%s/%s", m_strServer, strSrc);
		  HttpURLConnection conn= (HttpURLConnection) new URL(m_strURL).openConnection();
		  conn.setRequestMethod(m_strMethod);
		  int response=conn.getResponseCode();
		  InputStream is=conn.getInputStream();
		  return is;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
		
	}

	
}
