package org.te.springmvc.service;

import java.util.List;

import org.te.springmvc.beans.EmployeeBean;

public interface EmployeeService {
	public EmployeeBean authenticate(int id, String password);

	public EmployeeBean getEmployee(int id);

	public boolean isdelete(int id);

	public List<EmployeeBean> getAllData();

	public boolean addEmployee(EmployeeBean bean);

	public boolean updateEmployee(EmployeeBean bean);
}
