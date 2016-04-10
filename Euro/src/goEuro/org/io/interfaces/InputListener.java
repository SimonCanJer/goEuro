package goEuro.org.io.interfaces;

import java.io.IOException;
import java.io.OutputStream;

public abstract class InputListener extends OutputStream {

	OutputStream m_os;
	void setExternalOutput(OutputStream os)
	{
		m_os=os;
	}
	
	@Override
	public
	void write(byte[] buff, int offset,int len)
	{
		try {
			m_os.write(buff, offset, len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
