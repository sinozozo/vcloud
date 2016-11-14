package com.reachauto.common.entity;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	protected Date createDate;
	protected String delFlag;

	public BaseEntity(){
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	public Integer getId() {
		return id;
	}
	public BaseEntity<T> setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public BaseEntity<T> setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public BaseEntity<T> setDelFlag(String delFlag) {
		this.delFlag = delFlag;
		return this;
	}

	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	
}