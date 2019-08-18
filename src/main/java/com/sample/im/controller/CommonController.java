package com.sample.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.im.common.Metrics;
import com.sample.im.common.IMUtils;
import com.sample.im.model.value.BasicInfo;
import com.sample.im.repository.FeatureRepository;

@RestController
@RequestMapping({"/common"})
public class CommonController {

	@Autowired
	IMUtils utils;
	
	@Autowired
	Metrics cpuMetrics;
	
	@Autowired
	private FeatureRepository featureRepository;
	
	@GetMapping(path = {"/basic"})
	public ResponseEntity<BasicInfo> getBasicInfo() throws Exception{
		BasicInfo bs = new BasicInfo();
		bs.setIp(utils.getIpAddress());
		bs.setHostname(utils.getHostName());
		bs.setOs(utils.getOS());
		bs.setArch(utils.getArchType());
		bs.setFeature(featureRepository.findAll());
		return new ResponseEntity<BasicInfo>(bs,HttpStatus.OK);
	}
	
	@GetMapping(path = {"/os"})
	public ResponseEntity<String> getOS(){
		return new ResponseEntity<String>(utils.getOS(),HttpStatus.OK);
	}

	@GetMapping(path = {"/archtype"})
	public ResponseEntity<String> getArchType(){
		return new ResponseEntity<String>(utils.getArchType(),HttpStatus.OK);
	}
	
	@GetMapping(path = {"/hostname"})
	public ResponseEntity<String> getHostname() throws Exception{
		return new ResponseEntity<String>(utils.getHostName(),HttpStatus.OK);
	}
	
	@GetMapping(path = {"/ip"})
	public ResponseEntity<String> getIpAddress() throws Exception{
		return new ResponseEntity<String>(utils.getIpAddress(),HttpStatus.OK);
	}
	
	@GetMapping(path = {"/cpuload"})
	public ResponseEntity<Double> getCPULoad() {
		return new ResponseEntity<Double>(cpuMetrics.getProcessCpuLoad(),HttpStatus.OK);
	}
	
	@GetMapping(path = {"/memory"})
	public ResponseEntity<Double> getMemoryLoad() {
		return new ResponseEntity<Double>(cpuMetrics.getMemory(),HttpStatus.OK);
	}
}
