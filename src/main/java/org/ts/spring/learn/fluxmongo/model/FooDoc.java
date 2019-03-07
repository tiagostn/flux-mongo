package org.ts.spring.learn.fluxmongo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FooDoc {

	@Id
	private String id;
	private String name;
	private LocalDateTime lastUpdate;
	private byte[] data;

	public FooDoc() {
	}

	public FooDoc(String id, String name, LocalDateTime lastUpdate, byte[] data) {
		super();
		this.id = id;
		this.name = name;
		this.lastUpdate = lastUpdate;
		this.data = data;
	}

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

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "FooDoc [id=" + id + ", name=" + name + ", lastUpdate=" + lastUpdate + "]";
	}

}
