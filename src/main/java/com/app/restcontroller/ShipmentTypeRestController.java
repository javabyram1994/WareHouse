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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("/rest/shipmenttype")
public class ShipmentTypeRestController {
	
	@Autowired
	private IShipmentTypeService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> get(){
		ResponseEntity<?> message=null;
		List<ShipmentType> shps=service.getAllShipmentTypes();
		if(shps==null||shps.isEmpty()) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<List<ShipmentType>>(HttpStatus.OK);
		}
		return message;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getRow(@PathVariable Integer id){
		ResponseEntity<?> message=null;
	    ShipmentType shp=service.getOneShipmentType(id);
	    if(shp==null) {
	    	message=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    	}else {
	    		message=new ResponseEntity<ShipmentType>(HttpStatus.OK);
	    }
	    return message;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		ResponseEntity<String> message=null;
		try {
			service.deleteShipmentType(id);
			message=new ResponseEntity<String>("ShipmentType '"+id+"' deleted",HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody ShipmentType sh){
		ResponseEntity<String> message=null;
		try {
			Integer id=service.saveShipmentType(sh);
			message=new ResponseEntity<String>("ShipmentType saved with id: "+id,HttpStatus.OK);
		}catch(Exception e) {
			message =new ResponseEntity<String>("sorry Data you sent is not valid",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody ShipmentType st){
		ResponseEntity<String> message=null;
		try {
			service.updateShipmentType(st);
			message=new ResponseEntity<String>("ShipmentType with '"+st.getId()+"' updated sucessfully",HttpStatus.OK); 
		}catch(Exception e) {
			message=new ResponseEntity<String>("ShipmentType with '"+st.getId()+"' not found",HttpStatus.BAD_REQUEST); 
		}
		return message;
	}

}
