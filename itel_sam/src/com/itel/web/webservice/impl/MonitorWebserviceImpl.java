package com.itel.web.webservice.impl;

import javax.jws.WebService;

import com.itel.web.webservice.MonitorWebservice;


@WebService(endpointInterface = "com.itel.web.webservice.MonitorWebservice", targetNamespace = "http://itel.webservice.com")
public class MonitorWebserviceImpl implements MonitorWebservice {

	@Override
	public String demoTest(String jsonString) {
		System.out.println("jsonString = " + jsonString);
		return jsonString;
	}

}
