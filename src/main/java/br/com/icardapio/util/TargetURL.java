package br.com.icardapio.util;

public final class TargetURL {
	
	private static TargetURL uniqueInstance; 
	
	private static String defaultUrl;
	
	private TargetURL() {}
	
	public static synchronized TargetURL getInstance() {  
	      if (uniqueInstance == null)
	    	  uniqueInstance = new TargetURL();
	      
	      return uniqueInstance;  
	   }  
	
	public static void setDefaultUrl(String v){
		defaultUrl = "/"+v;
	}
	
	public static String getDefaultUrl(){
		return defaultUrl;
	}
	
}