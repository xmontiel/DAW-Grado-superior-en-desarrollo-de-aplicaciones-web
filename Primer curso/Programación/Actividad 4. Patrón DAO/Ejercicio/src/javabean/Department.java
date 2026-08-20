package javabean;

import java.util.Objects;

public class Department {
	
	private int departmentId;
	private String departmentName;
	private int manager;
	private Location location;
	
	public Department(int departmentId, String departmentName, int manager, Location location) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.manager = manager;
		this.location = location;
	}

	public Department() {
		super();
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", manager="
				+ manager + ", location=" + location + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Department))
			return false;
		Department other = (Department) obj;
		return departmentId == other.departmentId;
	}
	
	
	
	

}
