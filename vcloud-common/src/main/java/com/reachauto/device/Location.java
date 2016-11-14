package com.reachauto.device;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Created by zouqiang on 23/10/2016.
 */
@DataObject(generateConverter = true)
public class Location {
    private Double lon;
    private Double lat;
    private Double ele;//高度
    
    public Location(){
    	
    }
    public Location(JsonObject json){
    	
    }
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getEle() {
		return ele;
	}
	public void setEle(Double ele) {
		this.ele = ele;
	}
    
    
}
