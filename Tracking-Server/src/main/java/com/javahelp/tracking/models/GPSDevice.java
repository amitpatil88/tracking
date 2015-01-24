package com.javahelp.tracking.models;

public class GPSDevice {
	private String gpsDeviceId;
	private String gpsDeviceName;
	public GPSDevice(){
		
	}
	
	public GPSDevice(String gpsDeviceId,String gpsDeviceName) {
		this.gpsDeviceId = gpsDeviceId;
		this.gpsDeviceName = gpsDeviceName;
	}
	public String getGpsDeviceId() {
		return gpsDeviceId;
	}
	public void setGpsDeviceId(String gpsDeviceId) {
		this.gpsDeviceId = gpsDeviceId;
	}
	public String getGpsDeviceName() {
		return gpsDeviceName;
	}
	public void setGpsDeviceName(String gpsDeviceName) {
		this.gpsDeviceName = gpsDeviceName;
	}
	
	
}
