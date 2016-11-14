package com.reachauto.account;


import com.reachauto.common.entity.BaseEntity;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Created by zouqiang on 27/10/2016.
 */
@DataObject(generateConverter = true)
public class Account extends BaseEntity{
	private String username;
	private String password;
	

	public Account() {
	}

	public Account(Account other) {
		this.username = other.getUsername();
		this.password = other.getPassword();
	}

	public Account(JsonObject json) {
		AccountConverter.fromJson(json, this);
	}

	public Account(String jsonStr) {
		AccountConverter.fromJson(new JsonObject(jsonStr), this);
	}

	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		AccountConverter.toJson(this, json);
		return json;
	}

	

	public String getUsername() {
		return username;
	}

	public Account setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Account setPassword(String password) {
		this.password = password;
		return this;
	}

	

	@Override
	public String toString() {
		return toJson().encodePrettily();
	}
}
