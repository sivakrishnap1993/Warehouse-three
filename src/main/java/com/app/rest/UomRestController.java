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

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
@RequestMapping("/rest/uomone")
public class UomRestController {

	@Autowired
	private IUomService service;

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> resp = null;
		List<Uom> list = service.getAllUoms();
		if (list != null && !list.isEmpty()) {
			resp = new ResponseEntity<List<Uom>>(list, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("No Data Found", HttpStatus.OK);

		}
		return resp;
	}

	@PostMapping("/save")
	public ResponseEntity<String> getSaveFile(@RequestBody Uom uom) {
		ResponseEntity<String> resp = null;
		try {
			Integer sid = service.saveUom(uom);
			String one = " Saved With id:" + sid;
			resp = new ResponseEntity<String>(one, HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<?> getDelete(@PathVariable Integer uid) {
		ResponseEntity<?> respone = null;
		try {
			service.deleteUom(uid);
			respone = new ResponseEntity<String>(uid + "Deletd Successfully With Id", HttpStatus.OK);
		} catch (Exception e) {
			respone = new ResponseEntity<String>(uid + "Deletd Successfully With Id", HttpStatus.BAD_REQUEST);
		}
		return respone;
	}

	@GetMapping("/getOne/{uid}")
	public ResponseEntity<?> getOneRow(@PathVariable Integer uid) {
		ResponseEntity<?> resp = null;
		try {
			Uom sh = service.getUomById(uid);
			if (sh != null) {
				resp = new ResponseEntity<Uom>(sh, HttpStatus.OK);

			} else {
				resp = new ResponseEntity<String>(uid + "Unable To Find In DB", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>(uid + "Cannot To Find In DB", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}

	@PutMapping("/update")
	public ResponseEntity<?> getUpdate(@RequestBody Uom uom) {
		ResponseEntity<?> response = null;
		try {
			service.updateUom(uom);
			response = new ResponseEntity<String>("Update Successfully With Id", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>("No Data Found With Id", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
