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

	@JsonProperty("freePhysicalMemorySize")
	String freePhysicalMemorySize;

	@JsonProperty("freeSwapSpaceSize")
	String freeSwapSpaceSize;

	@JsonProperty("processCpuTime")
	String processCpuTime;

	@JsonProperty("systemCpuLoad")
	String systemCpuLoad;

	@JsonProperty("totalPhysicalMemorySize")
	String totalPhysicalMemorySize;

	@JsonProperty("totalSwapSpaceSize")
	String totalSwapSpaceSize;

	@JsonProperty("processCpuLoad")
	String processCpuLoad;

	@JsonProperty("name")
	String name;

	@JsonProperty("version")
	String version;

	@JsonProperty("availableProcessors")
	String availableProcessors;

	@JsonProperty("systemLoadAverage")
	String systemLoadAverage;

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

	public String getFreePhysicalMemorySize() {
		return freePhysicalMemorySize;
	}

	public void setFreePhysicalMemorySize(String freePhysicalMemorySize) {
		this.freePhysicalMemorySize = freePhysicalMemorySize;
	}

	public String getFreeSwapSpaceSize() {
		return freeSwapSpaceSize;
	}

	public void setFreeSwapSpaceSize(String freeSwapSpaceSize) {
		this.freeSwapSpaceSize = freeSwapSpaceSize;
	}

	public String getProcessCpuTime() {
		return processCpuTime;
	}

	public void setProcessCpuTime(String processCpuTime) {
		this.processCpuTime = processCpuTime;
	}

	public String getSystemCpuLoad() {
		return systemCpuLoad;
	}

	public void setSystemCpuLoad(String systemCpuLoad) {
		this.systemCpuLoad = systemCpuLoad;
	}

	public String getTotalPhysicalMemorySize() {
		return totalPhysicalMemorySize;
	}

	public void setTotalPhysicalMemorySize(String totalPhysicalMemorySize) {
		this.totalPhysicalMemorySize = totalPhysicalMemorySize;
	}

	public String getTotalSwapSpaceSize() {
		return totalSwapSpaceSize;
	}

	public void setTotalSwapSpaceSize(String totalSwapSpaceSize) {
		this.totalSwapSpaceSize = totalSwapSpaceSize;
	}

	public String getProcessCpuLoad() {
		return processCpuLoad;
	}

	public void setProcessCpuLoad(String processCpuLoad) {
		this.processCpuLoad = processCpuLoad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAvailableProcessors() {
		return availableProcessors;
	}

	public void setAvailableProcessors(String availableProcessors) {
		this.availableProcessors = availableProcessors;
	}

	public String getSystemLoadAverage() {
		return systemLoadAverage;
	}

	public void setSystemLoadAverage(String systemLoadAverage) {
		this.systemLoadAverage = systemLoadAverage;
	}

}
