package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SAMPLE")
public class Sample {
	/** 아이디 */
	@Id
	private String id;
	/** 이름 */
	private String name;
	/** 내용 */
	private String description;
	/** 사용여부 */
	private String useYn;
	/** 등록자 */
	private String regUser;

	public Sample() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Sample(String id, String name, String description, String useYn, String regUser) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.useYn = useYn;
		this.regUser = regUser;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getRegUser() {
		return regUser;
	}

	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sample other = (Sample) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sample [id=" + id + ", name=" + name + ", description=" + description + ", useYn=" + useYn
				+ ", regUser=" + regUser + "]";
	}
	
	
	
}
