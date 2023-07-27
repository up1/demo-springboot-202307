package com.example.day1.users;

import java.util.Objects;

public class CreateUserRequest{
	private String last_name;
	private String first_name;

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CreateUserRequest request = (CreateUserRequest) o;
		return Objects.equals(last_name, request.last_name) && Objects.equals(first_name, request.first_name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(last_name, first_name);
	}
}
