package com.sample.im.common;

import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;

@Component
public class Metrics {

	private final static String METRICS_NAME = "process.cpu.load";

	@Autowired
	private MeterRegistry meterRegistry;

	MBeanServer mbs;
	
	ObjectName name;
	
	@PostConstruct
	public void init() throws Exception {
		Gauge.builder(METRICS_NAME, this, Metrics::getProcessCpuLoad).baseUnit("%").description("CPU Load")
		.register(meterRegistry);
		this.mbs = ManagementFactory.getPlatformMBeanServer();
		name = ObjectName.getInstance("java.lang:type=OperatingSystem");
	}

	public Double getProcessCpuLoad() {
		try {			
			AttributeList list = mbs.getAttributes(name, new String[] { "ProcessCpuLoad" });
			return Optional.ofNullable(list).map(l -> l.isEmpty() ? null : l).map(List::iterator).map(Iterator::next)
					.map(Attribute.class::cast).map(Attribute::getValue).map(Double.class::cast).orElse(null);

		} catch (Exception ex) {
			return null;
		}
	}
	
	public Double getMemory() {
		try {			
			AttributeList list = mbs.getAttributes(name, new String[] { "ProcessCpuLoad" });
			return Optional.ofNullable(list).map(l -> l.isEmpty() ? null : l).map(List::iterator).map(Iterator::next)
					.map(Attribute.class::cast).map(Attribute::getValue).map(Double.class::cast).orElse(null);

		} catch (Exception ex) {
			return null;
		}
	}
}