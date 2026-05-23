package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/std")
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping("/getids")
	public ResponseEntity<List<Integer>>getIds(){
		List<Integer>ids=service.getIds();
		return ResponseEntity.ok(ids);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Student>>getAll(){
		List<Student> li=service.getAll();
		return ResponseEntity.ok(li);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<Student>getById(@PathVariable int id){
		Optional<Student>op=service.getById(id);
		if(op.isPresent()) {
			return ResponseEntity.ok(op.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("getcity")
	public ResponseEntity<List<Student>>getByCity(@RequestParam String city){
		List<Student>li=service.getByCity(city);
		return ResponseEntity.ok(li);
	}
	
	@GetMapping("getNames")
	public ResponseEntity<List<String>>getNames(){
		List<String> name=service.getNames();
		return ResponseEntity.ok(name);
	}
	
	@GetMapping("count")
	public ResponseEntity<Long>countData(){
		Long count=service.countData();
		return ResponseEntity.ok(count);
	}
	
	@GetMapping("search")
	public ResponseEntity<List<Student>>searchData(@RequestParam String name,@RequestParam String city){
		List<Student>li=service.searchData(name,city);
		return ResponseEntity.ok(li);
	}
	
	@GetMapping("getcities")
	public ResponseEntity<Set<String>> getCities(){
		Set<String>s=service.getCities();
		return ResponseEntity.ok(s);
	}
	
	@PostMapping("insert")
	public ResponseEntity<Student>insertData(@RequestBody Student std){
		Student s=service.insertData(std);
		return ResponseEntity.status(201).body(s);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Student>updateById(@PathVariable int id,@RequestBody Student std){
		Optional<Student>op=service.updateById(id,std);
		if(op.isPresent()) {
			return ResponseEntity.ok(op.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Student>updateCity(@PathVariable int id,@RequestBody Student std){
		Optional<Student>op=service.updateCity(id,std);
		if(op.isPresent()) {
			return ResponseEntity.ok(op.get());
			}else {
				return ResponseEntity.notFound().build();
			}	
		}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String>deleteById(@PathVariable int id){
	     service.deleteById(id);
	     return ResponseEntity.ok("Deleted Successfully");
	}
	
}
