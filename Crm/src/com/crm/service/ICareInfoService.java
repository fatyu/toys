package com.crm.service;

import java.util.List;

import com.crm.entity.CareInfo;

public interface ICareInfoService {

	public List<CareInfo> list();

	public void delete(Integer... ids);

	public CareInfo findById(int id);

	public void add(CareInfo careInfo);

}
