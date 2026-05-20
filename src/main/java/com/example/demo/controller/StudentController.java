package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/std")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<Student>saveStudent(@RequestBody Student s){
		Student std=service.saveStudent(s);
		return ResponseEntity.status(201).body(std);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getallStudents(){
		List<Student>list=service.getAllStudents();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Student>findById(@PathVariable int id){
		Optional<Student> s=service.findById(id);
		if(s.isPresent()) {
			return ResponseEntity.ok(s.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		Optional<Student>op=service.deleteById(id);
		if(op.isPresent()) {
			return ResponseEntity.ok("Deleted Successfully");
		}else {
			return ResponseEntity.status(404).body("Not found");
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Student>updateStudent(@RequestBody Student s){
		Student std=service.updateStudent(s);
		return ResponseEntity.ok(std);
	}
	
	
	@GetMapping("/city/{city}")
	public ResponseEntity<List<Student>>findByCity(@PathVariable String city){
		List<Student>l=service.findByCity(city);
		return ResponseEntity.ok(l);
	}
	
	
	
}
