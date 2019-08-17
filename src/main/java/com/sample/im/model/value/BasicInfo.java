package com.sample.im.model.value;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sample.im.model.Feature;

public class BasicInfo {
	@JsonProperty("ip")
	String ip;
	@JsonProperty("hostname")
	String hostname;
	@JsonProperty("os")
	String os;
	@JsonProperty("arch")
	String arch;
	@JsonProperty("feature")
	List<Feature> feature;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getArch() {
		return arch;
	}

	public void setArch(String arch) {
		this.arch = arch;
	}

	public List<Feature> getFeature() {
		return feature;
	}

	public void setFeature(List<Feature> feature) {
		this.feature = feature;
	}
	
}
