package com.sample.im.common;

import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.im.model.value.BasicInfo;
import com.sample.im.repository.FeatureRepository;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;

@Component
public class Metrics {

	private final static String METRICS_NAME = "process.cpu.load";

	@Autowired
	private MeterRegistry meterRegistry;

	@Autowired
	private FeatureRepository featureRepository;
	
	@Autowired
	IMUtils utils;
	
	MBeanServer mbs;

	ObjectName name;

	@PostConstruct
	public void init() throws Exception {
		Gauge.builder(METRICS_NAME, this, Metrics::getProcessCpuLoad).baseUnit("%").description("CPU Load")
				.register(meterRegistry);
		this.mbs = ManagementFactory.getPlatformMBeanServer();
		name = ObjectName.getInstance("java.lang:type=OperatingSystem");
	}

	DecimalFormat df = new DecimalFormat("#.00");
	
	public Double getProcessCpuLoad() {
		try {
			
			AttributeList list = mbs.getAttributes(name, new String[] { "SystemCpuLoad" });
			Double value = Optional.ofNullable(list).map(l -> l.isEmpty() ? null : l).map(List::iterator).map(Iterator::next)
					.map(Attribute.class::cast).map(Attribute::getValue).map(Double.class::cast).orElse(null);
			return Double.parseDouble(df.format(value*1000))/10;

		} catch (Exception ex) {
			return null;
		}
	}

	public String getValue(String key) throws Exception {
		AttributeList list = mbs.getAttributes(name, new String[] { key });
		Object val = Optional.ofNullable(list).map(l -> l.isEmpty() ? null : l).map(List::iterator).map(Iterator::next)
				.map(Attribute.class::cast).map(Attribute::getValue).map(Object.class::cast).orElse(null);
		return String.valueOf(val);
	}
	
	public BasicInfo getBasicInfo() throws Exception {
		BasicInfo bs = new BasicInfo();
		bs.setIp(utils.getIpAddress());
		bs.setHostname(utils.getHostName());
		bs.setOs(utils.getOS());
		bs.setArch(utils.getArchType());
		bs.setFeature(featureRepository.findAll());
		bs.setFreePhysicalMemorySize(getValue("FreePhysicalMemorySize"));		  
		bs.setFreeSwapSpaceSize(getValue("FreeSwapSpaceSize"));		  
		bs.setProcessCpuTime(getValue("ProcessCpuTime"));		 
		bs.setSystemCpuLoad(getValue("SystemCpuLoad"));		  
		bs.setTotalPhysicalMemorySize(getValue("TotalPhysicalMemorySize"));		  
		bs.setTotalSwapSpaceSize(getValue("TotalSwapSpaceSize"));
		bs.setProcessCpuLoad(getValue("ProcessCpuLoad"));		  
		bs.setName(getValue("Name"));		  
		bs.setVersion(getValue("Version"));		  
		bs.setAvailableProcessors(getValue("AvailableProcessors"));		  
		bs.setSystemLoadAverage(getValue("SystemLoadAverage"));
		return bs;
	}
	public Double getMemory() {
		try {

			/*
			 * MBeanInfo info = mbs.getMBeanInfo(name); MBeanAttributeInfo[] attrInfo =
			 * info.getAttributes();
			 * 
			 * System.out.println("Attributes for object: " + name +":\n"); for
			 * (MBeanAttributeInfo attr : attrInfo) { System.out.println("  " +
			 * attr.getName() + "\n"); } CommittedVirtualMemorySize
			 * 
			 * FreePhysicalMemorySize
			 * 
			 * FreeSwapSpaceSize
			 * 
			 * ProcessCpuTime
			 * 
			 * SystemCpuLoad
			 * 
			 * TotalPhysicalMemorySize
			 * 
			 * TotalSwapSpaceSize
			 * 
			 * ProcessCpuLoad
			 * 
			 * Name
			 * 
			 * Version
			 * 
			 * AvailableProcessors
			 * 
			 * Arch
			 * 
			 * SystemLoadAverage
			 * 
			 * ObjectName
			 * 
			 */

			AttributeList list = mbs.getAttributes(name, new String[] { "TotalPhysicalMemorySize" });
			return Optional.ofNullable(list).map(l -> l.isEmpty() ? null : l).map(List::iterator).map(Iterator::next)
					.map(Attribute.class::cast).map(Attribute::getValue).map(Double.class::cast).orElse(null);

		} catch (Exception ex) {
			return null;
		}
	}
}