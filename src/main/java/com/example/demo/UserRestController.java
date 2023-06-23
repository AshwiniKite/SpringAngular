package com.example.demo;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")//for all the external communication we can allow the data to enter and retrive 
public class UserRestController {
@Autowired
UserRepo repo;


//insert user 
@PostMapping("/register")
public String register(@RequestBody User user) {
	repo.save(user);
	return "Hi "+user.getName()+" you are registered successfully";
}


//list of users 
@GetMapping("/getAllusers")
public List<User> findAllusers(){
	return repo.findAll();
}


//delete a record 
@DeleteMapping("/cancel/{id}")
public List<User> cancelregistration(@PathVariable int id){
repo.deleteById(id);
return repo.findAll();
}


//update -self task 




//search with email
@GetMapping("/findbyemail/{email}")
public List<User> findbyemail(@PathVariable String email){
	return repo.findByemail(email);
}
	
}
