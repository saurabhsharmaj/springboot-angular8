package com.sample.im.common;

import java.net.InetAddress;

import org.springframework.stereotype.Component;

@Component
public class IMUtils {

	public String getHostName() throws Exception {
		return InetAddress.getLocalHost().getHostName();
	}

	public String getIpAddress() throws Exception {
		return InetAddress.getLocalHost().getHostAddress();
	}

	public String getOS() {
		return System.getProperty("os.name");
	}

	public String getArchType() {
		return System.getProperty("os.arch");
	}
}
