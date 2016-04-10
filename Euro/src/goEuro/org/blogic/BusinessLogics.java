package goEuro.org.blogic;

import java.io.InputStream;
import java.io.OutputStream;

import goEuro.org.interfaces.IBusinessLogics;
import goEuro.org.io.interfaces.IGenericIO;

public class BusinessLogics implements IBusinessLogics {

	IGenericIO<InputStream> m_input;
	IGenericIO<OutputStream> m_output;
	int m_iSizeBuffer=1024;
	@Override
	public IBusinessLogics setInput(IGenericIO<InputStream> input) {
		m_input=input;
		return this;
		
	}

	@Override
	public IBusinessLogics setOutput(IGenericIO<OutputStream> out) {
		m_output=out;
		return this;
		
	}

	@Override
	public void go(String[] params) {
		try {
			InputStream is= m_input.openTarget(params[0]);
			OutputStream os= m_output.openTarget(params[0]+".json");
			byte[] arr= new byte[m_iSizeBuffer];
			int read =-1;
			while(0<(read=is.read(arr)))
			{
				os.write(arr, 0, read);
			}
			is.close();
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
