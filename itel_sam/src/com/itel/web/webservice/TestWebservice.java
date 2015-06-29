package com.itel.web.webservice;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class TestWebservice {

	public static void main(String[] args) {

		 JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
		 bean.getInInterceptors().add(new LoggingInInterceptor());
		 bean.getInFaultInterceptors().add(new LoggingOutInterceptor());
		 bean.setServiceClass(MonitorWebservice.class);
		 bean.setAddress("http://localhost:8089/itel/webservice/monitor");
		 MonitorWebservice helloWorldService =
		 (MonitorWebservice)bean.create();
		 String result = helloWorldService.demoTest("Kevin");
		 System.out.println(result);

	}
}
