package com.javahelp.tracking.services.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javahelp.tracking.models.GPSDevice;

@RestController
@RequestMapping("/gpsdevices")
public class GPSDeviceService {
	Logger logger = LoggerFactory.getLogger("c.j.t.s.r.GPSDeviceService");
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	public GPSDeviceService(){
		super();
	}
	
	@RequestMapping(method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<GPSDevice> getAllGPSDevice() throws Exception {
		try{
			if(logger.isDebugEnabled()) {
				logger.debug("Fetching all available GPS Device");
			}
			GPSDevice device = new GPSDevice("askjhsad83489dhbas", "Device-1");
			List<GPSDevice> devices = new ArrayList<>();
			devices.add(device);
			return devices;
		} catch(Exception e){
			throw e;
		}
	}
}
