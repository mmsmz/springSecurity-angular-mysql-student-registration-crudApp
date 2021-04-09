package com.student.reg.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "JoinTableUserEntity")
@Table(name = "users")
public class UserEntity {

	@Id
	@Column(name = "Id")
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "usertype")
	private String userType;

	@Column(name = "password")
	private String password;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="studentcourses",
			         joinColumns={@JoinColumn(name="userid", referencedColumnName="id")}
			, inverseJoinColumns={@JoinColumn(name="courseid", referencedColumnName="courseid")})
	private Set<CourseEntity> courses;

	public Set<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseEntity> courses) {
		this.courses = courses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
