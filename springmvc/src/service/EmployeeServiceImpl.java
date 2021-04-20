package org.te.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.te.springmvc.Dao.EmployeeDaoHibernateImpl;
import org.te.springmvc.beans.EmployeeBean;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDaoHibernateImpl dao;
	
	@Override
	public EmployeeBean authenticate(int id, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(id, password);
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployee(id);
	}

	@Override
	public boolean isdelete(int id) {
		// TODO Auto-generated method stub
		return dao.isdelete(id);
	}


	@Override
	public List<EmployeeBean> getAllData() {
		// TODO Auto-generated method stub
		return dao.getAllData();
	}

	@Override
	public boolean addEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return dao.addEmployee(bean);
	}

	@Override
	public boolean updateEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(bean);
	}

}
