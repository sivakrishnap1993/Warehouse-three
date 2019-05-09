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

import com.app.model.Purchase;
import com.app.service.IPurchaseService;

@RestController
@RequestMapping("/rest/purchase")
public class PurchaseRestController {

	@Autowired
	private IPurchaseService service;

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> resp = null;

		List<Purchase> list = service.getAllPurchases();
		if (list != null && !list.isEmpty()) {
			resp = new ResponseEntity<List<Purchase>>(list, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("No Data Found", HttpStatus.OK);
		}
		return resp;
	}

	@PostMapping("/save")
	public ResponseEntity<String> getSaveDasta(@RequestBody Purchase purchase) {
		ResponseEntity<String> response = null;
		try {
			Integer sid = service.savePurchase(purchase);
			String body = " Saved With id:" + sid;
			response = new ResponseEntity<String>(body, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<?> getDeleteFile(@PathVariable Integer pid) {
		ResponseEntity<?> resp = null;
		try {
			service.deletePurchase(pid);
			resp = new ResponseEntity<String>(pid + "Deleted Successfully With Id", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(pid + "Unable To Delete  With Id", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@GetMapping("/getOne/{pid}")
	public ResponseEntity<?> getOneRow(@PathVariable Integer pid) {
		ResponseEntity<?> resp = null;
		try {
			Purchase p = service.getPurchaseById(pid);
			if (p != null) {
				resp = new ResponseEntity<Purchase>(p, HttpStatus.OK);

			} else {
				resp = new ResponseEntity<String>(pid + "Unable To Find in DB", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>(pid + "Can not Find in row Data", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@PutMapping("/update")
	public ResponseEntity<?> getUpdate(@RequestBody Purchase purchase) {
		ResponseEntity<?> resp = null;
		try {
			service.updatePurchase(purchase);
			resp = new ResponseEntity<String>("Updated Successfully With Id", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("No Data Found With Id", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
}
