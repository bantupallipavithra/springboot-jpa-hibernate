package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;

	public Student saveStudent(Student s) {
		return repo.save(s);
	}

	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	public Optional<Student> findById(int id) {
		return repo.findById(id);
	}

	public Optional<Student> deleteById(int id) {
		Optional<Student>op=repo.findById(id);
		if(op.isPresent()) {
			repo.deleteById(id);
		}
		return op;
	}

	public Student updateStudent(Student s) {
		return repo.save(s);
	}

	public List<Student> findByCity(String city) {
		return repo.findByCity(city);
	}

	
	

	

}
