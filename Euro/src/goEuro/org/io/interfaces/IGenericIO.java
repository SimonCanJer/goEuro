package goEuro.org.io.interfaces;

public interface IGenericIO<AccessObject> {
	IGenericIO<AccessObject> setBaseDirectory(String str);
	AccessObject openTarget(String strSrc) throws Exception;
}
