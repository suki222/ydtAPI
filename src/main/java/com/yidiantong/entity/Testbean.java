package com.yidiantong.entity;

import org.springframework.stereotype.Component;

@Component
public class Testbean {
	private String SSZX00;
	private String DQMC00;
	public String getSSZX00() {
		return SSZX00;
	}

	public void setSSZX00(String SSZX00) {
		this.SSZX00 = SSZX00;
	}

	public String getDQMC00() {
		return DQMC00;
	}

	public void setDQMC00(String DQMC00) {
		this.DQMC00 = DQMC00;
	}

	@Override
	public String toString() {
		return "Testbean{" +
				"SSZX00='" + SSZX00 + '\'' +
				", DQMC00='" + DQMC00 + '\'' +
				'}';
	}
}
