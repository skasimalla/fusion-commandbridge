package com.as.cb.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CommandUtil {
    final static Logger logger = Logger.getLogger(CommandUtil.class);

    public static String commandExecutor(String cmd) {
	String res = "";
	try {
	    res = extractFromCommand(cmd);
	} catch (Exception e1) {
	    e1.printStackTrace();
	}
	return res;
    }
    
    public static String extractFromCommand(String cmd) {
	String s;
	StringBuffer sb = new StringBuffer();
	Process p = null;
	try {
	    p = Runtime.getRuntime().exec(cmd);
	    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
	    while ((s = stdInput.readLine()) != null)
		sb.append(s);
	    while ((s = stdError.readLine()) != null)
		sb.append(s);
	    p.waitFor();
	    p.destroy();
	} catch (Exception e) {
	    logger.error(e);
	}
	// System.out.println(sb.toString());
	return sb.toString();
    }
}
