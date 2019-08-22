package com.sample.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.im.common.IMUtils;
import com.sample.im.common.Metrics;
import com.sample.im.model.value.BasicInfo;
import com.sample.im.repository.FeatureRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping({"/common"})
@Api(value="/common", description="Operations pertaining to common")
public class CommonController {

	@Autowired
	IMUtils utils;
	
	@Autowired
	Metrics metrics;
	
	@Autowired
	private FeatureRepository featureRepository;
	
	@ApiOperation(value = "View a list of available Basic Information", response = BasicInfo.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path = {"/basic"})
	public ResponseEntity<BasicInfo> getBasicInfo() throws Exception{
		BasicInfo bs = new BasicInfo();
		bs.setIp(utils.getIpAddress());
		bs.setHostname(utils.getHostName());
		bs.setOs(utils.getOS());
		bs.setArch(utils.getArchType());
		bs.setFeature(featureRepository.findAll());
		bs.setFreePhysicalMemorySize(metrics.getValue("FreePhysicalMemorySize"));		  
		bs.setFreeSwapSpaceSize(metrics.getValue("FreeSwapSpaceSize"));		  
		bs.setProcessCpuTime(metrics.getValue("ProcessCpuTime"));		 
		bs.setSystemCpuLoad(metrics.getValue("SystemCpuLoad"));		  
		bs.setTotalPhysicalMemorySize(metrics.getValue("TotalPhysicalMemorySize"));		  
		bs.setTotalSwapSpaceSize(metrics.getValue("TotalSwapSpaceSize"));
		bs.setProcessCpuLoad(metrics.getValue("ProcessCpuLoad"));		  
		bs.setName(metrics.getValue("Name"));		  
		bs.setVersion(metrics.getValue("Version"));		  
		bs.setAvailableProcessors(metrics.getValue("AvailableProcessors"));		  
		bs.setSystemLoadAverage(metrics.getValue("SystemLoadAverage"));
		
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
		return new ResponseEntity<Double>(metrics.getProcessCpuLoad(),HttpStatus.OK);
	}
	
	@GetMapping(path = {"/metric/{key}"})
	public ResponseEntity<Object> getMemoryLoad(@PathVariable String key) throws Exception {
		return new ResponseEntity<Object>(metrics.getValue(key),HttpStatus.OK);
	}
}
