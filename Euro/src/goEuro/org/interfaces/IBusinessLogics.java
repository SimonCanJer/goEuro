package goEuro.org.interfaces;

import java.io.InputStream;
import java.io.OutputStream;

import goEuro.org.io.interfaces.IGenericIO;

public interface IBusinessLogics {
	IBusinessLogics setInput(IGenericIO<InputStream> input);
	IBusinessLogics setOutput(IGenericIO<OutputStream> input);
	void go(String[] params);
}
