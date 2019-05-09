package com.app.rest;

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
@RequestMapping("/rest/ordero")
public class OrderMethodRestController {

	@Autowired
	private IOrderMethodService service;

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> respp = null;
		List<OrderMethod> list = service.getAllOrderMethods();
		if (list != null && !list.isEmpty()) {
			respp = new ResponseEntity<List<OrderMethod>>(list, HttpStatus.OK);
		} else {
			respp = new ResponseEntity<String>("No Data Found", HttpStatus.OK);
		}
		return respp;
	}

	@PostMapping("/save")
	public ResponseEntity<String> getSaveFiles(@RequestBody OrderMethod orderMethod) {
		ResponseEntity<String> ress = null;
		try {
			Integer sid = service.saveOrderMethod(orderMethod);
			String data = "Saved With id:" + sid;
			ress = new ResponseEntity<String>(data, HttpStatus.OK);
		} catch (Exception e) {
			ress = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ress;
	}

	@DeleteMapping("/delete/{ord}")
	public ResponseEntity<?> getDlete(@PathVariable Integer ord) {
		ResponseEntity<?> res = null;
		try {
			service.deleteOrderMethod(ord);
			res = new ResponseEntity<String>(ord + "Deleted Successfully With id", HttpStatus.OK);
		} catch (Exception e) {
			res = new ResponseEntity<String>(ord + " Unablde To Delete  With id", HttpStatus.BAD_REQUEST);
		}
		return res;
	}

	@GetMapping("/getOne/{ord}")
	public ResponseEntity<?> getOneObj(@PathVariable Integer ord) {
		ResponseEntity<?> resp = null;
		try {
			OrderMethod o = service.getOrderMethodById(ord);
			if (o != null) {
				resp = new ResponseEntity<OrderMethod>(o, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<String>(ord + "Unable To Find in DB", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>(ord + "Can not Find ", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@PutMapping("/update")
	public ResponseEntity<?> getUpdate(@RequestBody OrderMethod orderMethod) {
		ResponseEntity<?> res = null;
		try {
			service.updateOrderMethod(orderMethod);
			res = new ResponseEntity<String>("Updated Successfully With Id", HttpStatus.OK);
		} catch (Exception e) {
			res = new ResponseEntity<String>("No Data Found With Id in DB", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}

}
