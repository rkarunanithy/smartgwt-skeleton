package com.agilebees.meme.server.init;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class AppPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	private static Map<String,String> propertiesMap;
	
	private int springSystemPropertiesMode = SYSTEM_PROPERTIES_MODE_FALLBACK;
	
	@Override
	public void setSystemPropertiesMode(int systemPropertiesMode){
		super.setSystemPropertiesMode(systemPropertiesMode);
		springSystemPropertiesMode = systemPropertiesMode;
	}
	
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory,Properties props)throws BeansException{
		super.processProperties(beanFactory, props);
		
		propertiesMap = new HashMap<String,String>();
		for(Object key : props.keySet()){
			String keyStr = key.toString();
			String valueStr = resolvePlaceholder(keyStr,props,springSystemPropertiesMode);
			propertiesMap.put(keyStr, valueStr);
		}
		
	}
	
	
	public static String getProperty(String name){
		return propertiesMap.get(name);
	}
	
	public static String getProperty(String name,String defaultValue){
		String prop = propertiesMap.get(name);
		if(StringUtils.trimToNull(prop) == null){
			return defaultValue;
		}
		return prop;
	}
	
	public static Properties getProperties(){
		Properties properties = new Properties();
		properties.putAll(propertiesMap);
		return properties;
	}

}
