package org.te.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.te.springmvc.beans.EmployeeBean;
import org.te.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@InitBinder
	public void initBiinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

//	@PersistenceUnit
//	public LocalEntityManagerFactoryBean  

	@Autowired
	private EmployeeService service;

	@GetMapping("/login5")
	public String getlogin() {
		return "emplogin";
	}// end of getLogin

	@PostMapping("/login5")
	public String authenticate(int id, String password, HttpServletRequest request, ModelMap map) {
		EmployeeBean employeeBean = service.authenticate(id, password);
		if (employeeBean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emp", employeeBean);
			return "homePage";
		} else {
			map.addAttribute("errMsg", "Invalid Credentials");
			return "emplogin";
		}
	}// end of Authenticate

	@GetMapping("/searchForm")
	public String getSearchForm(ModelMap map, HttpSession session) {
		if (session.getAttribute("emp") != null) {
			return "searchForm";
		} else {
			map.addAttribute("errMsg", "Please login first");
			return "emplogin";
		} // end of getSearchForm

	}

	@GetMapping("/search")
	public String SearchEmp(int id, ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			EmployeeBean employeeBean2 = service.getEmployee(id);
			if (employeeBean2 != null) {
				map.addAttribute("data", employeeBean2);
			} else {
				map.addAttribute("msg", "data not found" + id);
			}
			return "searchForm";
		} else {
			map.addAttribute("errMsg", "please Login First");
			return "emplogin";

		}

	}// end of searchEmp

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "Logout Successfull");
		return "emplogin";
	}// end of logout

	@GetMapping("/getdeleteForm")
	public String getdeleteForm(@SessionAttribute(name = "emp") EmployeeBean bean, ModelMap map) {
		if (bean != null) {
			return "deleteForm";
		}
		map.addAttribute("msg", "please login first");
		return "emplogin";
	}// end of delete

	@GetMapping("/delete")
	public String deleteEmployee(@SessionAttribute(name = "emp", required = false) EmployeeBean bean, ModelMap map,
			int id) {
		if (bean != null) {
			boolean deleted = service.isdelete(id);
			if (deleted == true) {
				map.addAttribute("msg", "deleted Successfully");
				return "deleteForm";
			} else {
				map.addAttribute("errmsg", "user not found ");
				return "deleteForm";
			}
		}
		return null;
	}// end of deleteEmployee

	@GetMapping("/viewall")
	public String viewAllEmployee(ModelMap map, @SessionAttribute(name = "emp", required = false) EmployeeBean bean) {
		if (bean != null) {
			List<EmployeeBean> employeeBeans = service.getAllData();
			map.addAttribute("empdata", employeeBeans);
			return "allData";
		} else {
			map.addAttribute("msg", "no employees found");
			return "allData";
		} // end of viewall

	}

	@GetMapping("/add")
	public String getAddEmployee(@SessionAttribute(name = "emp", required = false) EmployeeBean bean, ModelMap map) {
		if (bean != null) {
			return "addEmp";
		}
		map.addAttribute("msg", "please login first");
		return "emplogin";
	}// end of getAddEmployee

	@PostMapping("/add")
	public String addEmployee(@SessionAttribute(name = "emp", required = false) EmployeeBean bean, ModelMap map,EmployeeBean empdata) {
		if (bean != null) {
			if (service.addEmployee(empdata)) {
				map.addAttribute("msg", "added successfully");
				return "addEmp";
			} else {
				map.addAttribute("errmsg", "something went wrong");
				return "addEmp";
			}
		} else {
			map.addAttribute("msg", "please login first");
			return "emplogin";
		}
		
	
	}// end of the addEmployee

	@GetMapping("/update")
	public String getUpdateForm(@SessionAttribute(name = "emp", required = false) EmployeeBean bean, ModelMap map) {
		if (bean != null) {
			map.addAttribute("id", bean.getId());
			return "updateEmp";
		}
		map.addAttribute("msg", "please login first");
		return "emplogin"; 
 
	}

	@PostMapping("/update")
	public String getUpdate(@SessionAttribute(name = "emp", required = false) EmployeeBean bean, ModelMap map,EmployeeBean empdata) {
		if(bean != null) {
			if(service.updateEmployee(empdata)) {
				map.addAttribute("id", bean.getId());
				map.addAttribute("msg"," update SuccessFully");
				return "updateEmp";
			}
			else {
				map.addAttribute("errMsg", "Not able to update");
			 return "updateEmp";
			}
		}else {
		map.addAttribute("msg","please login first");
		
		 return "emplogin";
		}
	}

}
// end of Controller
