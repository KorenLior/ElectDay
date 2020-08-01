package Control;

import java.util.ArrayList;

import Entity.DbEmployee;
import Entity.Employee;

public class EmployeeCtrl {

	public ArrayList<Employee> getEmployees() {
		return ((new DbEmployee()).getEmployees());
	}

}
