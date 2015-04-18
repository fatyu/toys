package com.crm.service;

import java.util.List;

import com.crm.entity.Complain;

public interface IComplainService {

	public List<Complain> list();

	public void delete(Integer... ids);

	public void update(Complain complain);

	public Complain findById(int id);

	public void add(Complain complain);

}
