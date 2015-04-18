package com.crm.service;

import java.util.List;

import com.crm.entity.Power;

public interface IPowerService {

	public List<Power> list();

	public Power findById(int id);
}
