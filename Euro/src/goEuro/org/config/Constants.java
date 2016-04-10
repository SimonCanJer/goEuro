package goEuro.org.config;

import java.io.File;

public class Constants {

	static public final String IMPLEMENTS_INPUT="implementsInput";
	static public final String IMPLEMENTS_OUTPUT=  "implementsOutput";
	static public final String IMPLEMENTS_LOGIC=  "implementLogic";
	static public final String MAX_READ_BUFFER_SIZE=   "maxReadBufferSize";
	static public final String HTTP_SERVER=   "httpServer";
	static public final File    CONFIG_FILE=  new File( "config.json");
	static public final int   CONFIG_READ_BUFFER_SIZE=  1024;
	static public final String LOCAL_REPOSITORY="localRepository";
}
