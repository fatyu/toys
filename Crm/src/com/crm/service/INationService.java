package com.crm.service;

import java.util.List;

import com.crm.entity.Nation;

public interface INationService {

	public List<Nation> list();

	public void update(Nation nation);

	public Nation findById(String id);
}
