package com.example.webday7.service;

import java.util.List;

import com.example.webday7.entity.Student;

public interface StudentService {

	List<Student> findAll();

	Student findById(long id);

	void insert(Student s);

	void update(Student s);

	void delete(long id);
}
