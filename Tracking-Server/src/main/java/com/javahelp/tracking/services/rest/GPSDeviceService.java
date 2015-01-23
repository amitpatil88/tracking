package com.javahelp.tracking.services.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javahelp.tracking.models.GPSDevice;

@RestController
@RequestMapping("/gpsdevices")
public class GPSDeviceService {
	Logger logger = LoggerFactory.getLogger("c.j.t.s.r.GPSDeviceService");
	
	public List<GPSDevice> getAllGPSDevice() throws Exception {
		try{
			if(logger.isDebugEnabled()) {
				logger.debug("Fetching all available GPS Device");
			}
			List<GPSDevice> devices = new ArrayList<>();
			return devices;
		} catch(Exception e){
			throw e;
		}
	}
}
