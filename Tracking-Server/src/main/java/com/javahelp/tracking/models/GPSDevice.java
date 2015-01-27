package com.javahelp.tracking.models;

import java.util.Date;
/**
 * 
 * @author GS-0714
 *
 */
public class GPSDevice {
	private String gpsDeviceId;
	private String gpsDeviceName;
	private Date activationDate;
	private Date expirationDate;
	private boolean isEnabled;
	
	public GPSDevice(){
		
	}
	
	public GPSDevice(String gpsDeviceId,String gpsDeviceName){
		this(gpsDeviceId,gpsDeviceName,null,null,false);
	}
	
	public GPSDevice(String gpsDeviceId,String gpsDeviceName,Date activationDate,Date expirationDate,boolean isEnabled) {
		this.gpsDeviceId = gpsDeviceId;
		this.gpsDeviceName = gpsDeviceName;
		this.activationDate = activationDate;
		this.expirationDate = expirationDate;
		this.isEnabled = isEnabled;
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

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
}
