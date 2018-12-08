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

import com.app.model.Item;
import com.app.service.IItemService;

@RestController
@RequestMapping("/rest/item")
public class ItemRestController {
	
	@Autowired
	private IItemService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> data(){
		ResponseEntity<?> message=null;
		List<Item> itms=service.getAllItems();
		if(itms==null||itms.isEmpty()) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				message=new ResponseEntity<List<Item>>(HttpStatus.OK);
		}
		return message;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getRow(@PathVariable Integer id){
		ResponseEntity<?> message=null;
		Item itm=service.getOneItemById(id);
		if(itm==null) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<Item>(HttpStatus.OK);
		}
		return message;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		ResponseEntity<String> message=null;
		try {
			service.deleteItem(id);
			message=new ResponseEntity<String>("item '"+id+"' deleted",HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Item it){
		ResponseEntity<String> message=null;
		try {
			Integer id=service.saveItem(it);
			message=new ResponseEntity<String>("itemm saved with id: "+id,HttpStatus.OK);
		}catch(Exception e) {
			message =new ResponseEntity<String>("sorry Data you sent is not valid",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Item i){
		ResponseEntity<String> message=null;
		try {
			service.updateItem(i);
			message=new ResponseEntity<String>("Item with '"+i.getId()+"' updated sucessfully",HttpStatus.OK); 
		}catch(Exception e) {
			message=new ResponseEntity<String>("Item with '"+i.getId()+"' not found",HttpStatus.BAD_REQUEST); 
		}
		return message;
	}

}
