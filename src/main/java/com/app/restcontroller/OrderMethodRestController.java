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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@RestController
@RequestMapping("/rest/om")
public class OrderMethodRestController {
	 
	@Autowired
	private IOrderMethodService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> data(){
		ResponseEntity<?> message=null;
		List<OrderMethod> oms=service.getAllOrderMethods();
		if(oms==null || oms.isEmpty()) {
			message = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<List<OrderMethod>>(oms,HttpStatus.OK);
		}
		return message;
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> oneRow(@PathVariable Integer id){
		ResponseEntity<?> message=null;
		OrderMethod om=service.getOneOrderMethod(id);
		if(om==null) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<OrderMethod>(om,HttpStatus.OK);
		}
		return message;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		ResponseEntity<String> message=null;
		try {
			service.deleteOrderMethod(id);
			message=new ResponseEntity<String>("Oreder method '"+id+"' deleted",HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<String>("id not Found",HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody OrderMethod om){
		ResponseEntity<String> message=null;
		try {
			service.saveOrderMethod(om);
			message=new ResponseEntity<String>("OrderMethod '"+om.getId()+"' saved",HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<String>("sorry cant something went wrong",HttpStatus.OK);
		}
		return message;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody OrderMethod om){
		ResponseEntity<String> message=null;
	try {
		service.updateOrderMethod(om);
		message=new ResponseEntity<String>("updated '"+om.getId()+"'updated",HttpStatus.OK);
	}catch(Exception e) {
		message=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return message;
	}
}
