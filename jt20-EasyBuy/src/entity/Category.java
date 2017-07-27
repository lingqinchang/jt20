package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Category implements Serializable{
	private static final long serialVersionUID = 4422749591262128816L;
	private Integer id;
	private String name;
	private Integer parentId;
	private Integer type;
	private String iconClass;
	private String parentName;
	private Set<Category> cs = new HashSet<Category>();
	private Set<Product> ps = new HashSet<Product>();
      
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public Set<Product> getPs() {
		return ps;
	}
	public void setPs(Set<Product> ps) {
		this.ps = ps;
	}
	public Set<Category> getCs() {
		return cs;
	}
	public void setCs(Set<Category> cs) {
		this.cs = cs;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getIconClass() {
		return iconClass;
	}
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
}
