package com.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@RestController 
@RequestMapping("/rest/whuser")
public class WhUserTypeRestController {
	
	@Autowired
	private IWhUserTypeService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getall(){
		ResponseEntity<?> message=null;
		List<WhUserType>whs=service.getAllWhUsers();
		if(whs==null||whs.isEmpty()) {
		 message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<List<WhUserType>>(whs,HttpStatus.OK);
		}
		return message;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getRow(@PathVariable Integer id){
		ResponseEntity<?> message=null;
		WhUserType wh=service.getOneWhuser(id);
		if(wh==null) {
			message=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			message=new ResponseEntity<WhUserType>(HttpStatus.OK);
		}
		return message;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		ResponseEntity<String> message=null;
		try {
			service.deleteWhuser(id);
			message=new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody WhUserType wh){
		ResponseEntity<String> message=null;
		try {
			Integer id=service.saveWhUser(wh);
			message=new ResponseEntity<String>("WHuserType saved with id: "+id,HttpStatus.OK);
		}catch(Exception e) {
			message =new ResponseEntity<String>("sorry Data you sent is not valid",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody WhUserType wh){
		ResponseEntity<String> message=null;
		try {
			service.updateWhUser(wh);
			message=new ResponseEntity<String>("Whuser with '"+wh.getId()+"' updated sucessfully",HttpStatus.OK); 
		}catch(Exception e) {
			message=new ResponseEntity<String>("Whuser with '"+wh.getId()+"' not found",HttpStatus.BAD_REQUEST); 
		}
		return message;
	}

}
