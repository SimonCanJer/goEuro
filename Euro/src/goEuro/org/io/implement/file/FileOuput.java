package goEuro.org.io.implement.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import goEuro.org.io.interfaces.IGenericIO;
import goEuro.org.io.interfaces.IGenericOutput;

public class FileOuput implements IGenericIO<OutputStream> {

	File m_base;
	@Override
	public IGenericIO<OutputStream> setBaseDirectory(String str) {
		m_base= new File(str);
		if(!m_base.exists())
			m_base.mkdirs();
		return this;
		
	}

	@Override
	public OutputStream openTarget(String strTarget) throws Exception {
		
		return new FileOutputStream(new File(m_base,strTarget));
		
		
	}
	public FileOuput()
	{
		
	}

	

}
