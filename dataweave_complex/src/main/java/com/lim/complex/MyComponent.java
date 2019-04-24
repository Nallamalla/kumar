package com.lim.complex;

import java.util.ArrayList;
import java.util.List;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.lim.tranforms.Employees;
import com.lim.tranforms.Employee;

public class MyComponent implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		Employees originalpayload=(Employees)eventContext.getMessage().getPayload();
	Employees emp=new Employees();
	ArrayList<Employee> list=new ArrayList<Employee>();
	for(Employee employee:originalpayload.getListOfEmployee())
	{
		employee.setSalary(employee.getSalary()+2000);
		list.add(employee);
	}
	emp.setListOfEmployee(list);
			return emp;
	
	}

}
