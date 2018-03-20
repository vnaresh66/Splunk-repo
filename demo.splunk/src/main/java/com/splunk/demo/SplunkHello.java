package com.splunk.demo;

import java.util.HashMap;
import java.util.Map;

import com.splunk.Args;
import com.splunk.Receiver;
import com.splunk.Service;

public class SplunkHello {

	public static void main(String[] args) {
		Map<String, Object> connectionArgs = new HashMap<String, Object>();
		// connectionArgs.put("host", "10.114.53.108");
		connectionArgs.put("host", "localhost");
		connectionArgs.put("username", "admin");
		connectionArgs.put("password", "changeme");
		connectionArgs.put("port", 8000);
		connectionArgs.put("schema", "https");

		// HttpService.setSslSecurityProtocol(SSLSecurityProtocol.SSLv3);
		Service splunkService = Service.connect(connectionArgs);
		Receiver receiver = splunkService.getReceiver();
		Args logArgs = new Args();
		logArgs.put("sourcetype", "splunk_test_source");

		for (int i = 0; i <= 15; i++) {
			receiver.log("main_index", logArgs, "splunk_test_event");
		}

	}

}
