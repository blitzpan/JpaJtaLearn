package com.channelsoft.apiplus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * 坐席信息实体对象
 *
 * @author yuanshun
 *
 */

@Entity(name = "test2")
@Table(name = "test2")
public class Test2 implements Serializable {

	private static final long serialVersionUID = -1864219649149618521L;


	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "name")
	private String name;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestOne{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
