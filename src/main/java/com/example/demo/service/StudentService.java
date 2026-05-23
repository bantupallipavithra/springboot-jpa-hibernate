package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;

	public List<Integer> getIds(){
	    List<Student> list =repo.findAll();
	    List<Integer> ids =new ArrayList<>();
	    for(Student s : list){
	        ids.add(s.getId());
	    }
	    return ids;
	}

	public List<Student> getAll() {
		return repo.findAll();
	}

	public Optional<Student> getById(int id) {
		return repo.findById(id);
	}

	public List<Student> getByCity(String city) {
		  List<Student> list =repo.findAll();
		  List<Student>std=new ArrayList<>();
		  for(Student s:list) {
			  if(city.equals(s.getCity())) {
				  std.add(s);
			  }
		  }
		return std ;
	}

	public List<String> getNames() {
		List<Student>list=repo.findAll();
		List<String>name=new ArrayList<>();
		for(Student n:list) {
			name.add(n.getName());
		}
		return name;
	}

	public Long countData() {
		return repo.count();
	}

	public List<Student> searchData(String name, String city) {
		List<Student>li=repo.findAll();
		List<Student>lis=new ArrayList<>();
		for(Student s:li) {
			if(name.equals(s.getName()) && city.equals(s.getCity())) {
				lis.add(s);
			}
		}
		return lis;
	}

	public Set<String> getCities() {
		List<Student>l=repo.findAll();
		Set<String>s=new TreeSet<>();
		for(Student std:l) {
			s.add(std.getCity());
		}
		return s;
	}

	public Student insertData(Student std) {
		return repo.save(std);
	}

	public Optional<Student> updateById(int id, Student std) {
		Optional<Student>op=repo.findById(id);
		if(op.isPresent()) {
			Student oldstd=op.get();
			oldstd.setName(std.getName());
			oldstd.setCity(std.getCity());
			Student up=repo.save(oldstd);
			  return Optional.of(up);
		}
		 return Optional.empty();
	}

	public Optional<Student> updateCity(int id, Student std) {
		Optional<Student>op=repo.findById(id);
		if(op.isPresent()) {
			Student old=op.get();
			old.setCity(std.getCity());
			Student up=repo.save(old);
			return Optional.of(up);
		}
		
		return Optional.empty();
	}

	public void deleteById(int id) {
		repo.deleteById(id);
	}

	

	

	


	

}

