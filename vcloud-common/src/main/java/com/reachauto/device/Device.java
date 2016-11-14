package com.reachauto.device;

import java.util.List;

import com.reachauto.common.entity.BaseEntity;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Created by zouqiang on 23/10/2016.
 */

@DataObject(generateConverter = true)
public class Device extends BaseEntity{
	private String id;
	private String title;
	private String desc;
	private List<String> tags;
	private ProtocolType protocol;
	private Location location;
	private Boolean privat;
	private String authInfo;
	private String other;

	public Device() {
	}

	public Device(JsonObject json) {
		DeviceConverter.fromJson(json, this);
	}

	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		DeviceConverter.toJson(this, json);
		return json;
	}


	public String getTitle() {
		return title;
	}

	public Device setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public Device setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public List<String> getTags() {
		return tags;
	}

	public Device setTags(List<String> tags) {
		this.tags = tags;
		return this;
	}

	public ProtocolType getProtocol() {
		return protocol;
	}

	public Device setProtocol(ProtocolType protocol) {
		this.protocol = protocol;
		return this;
	}

	public Location getLocation() {
		return location;
	}

	public Device setLocation(Location location) {
		this.location = location;
		return this;
	}

	public Boolean getPrivat() {
		return privat;
	}

	public Device setPrivat(Boolean privat) {
		this.privat = privat;
		return this;
	}

	public String getAuthInfo() {
		return authInfo;
	}

	public Device setAuthInfo(String authInfo) {
		this.authInfo = authInfo;
		return this;
	}

	public String getOther() {
		return other;
	}

	public Device setOther(String other) {
		this.other = other;
		return this;
	}

	@Override
	public String toString() {
		return toJson().encodePrettily();
	}
}
