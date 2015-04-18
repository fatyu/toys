package com.crm.service;

import java.util.List;

import com.crm.entity.Sex;

public interface ISexService {

	public List<Sex> list();

	public void update(Sex sex);

	public Sex findById(String sexId);

}
