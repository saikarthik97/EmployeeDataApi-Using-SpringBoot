package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(path="/demo")
public class MainController {

	@Autowired
	private UserRepository empRepo;


	@PostMapping(path="/add")
	public  String addNewUser (@RequestBody User d){
		empRepo.save(d);
		return "Saved Data";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return empRepo.findAll();
	}

	@GetMapping(path="/emp/{id}")
	public @ResponseBody Iterable<User> getUser(@PathVariable Integer id) {
		return empRepo.findAllById(id);

	}

	@PutMapping("/update")
	public String updateEmpDetails(@RequestBody User d)
	{
//		  if(d.getId()!=nul
		empRepo.save(d);
		return "Updated Data";
	}

	@DeleteMapping("/del/{id}")
	public String deleteEmpDetails(@PathVariable int id)
	{
		empRepo.deleteById(id);
		return "Deleted Data";
	}
}