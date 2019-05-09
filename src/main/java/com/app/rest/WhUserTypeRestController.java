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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@RestController
@RequestMapping("/rest/whuser")
public class WhUserTypeRestController {

	@Autowired
	private IWhUserTypeService service;

	@GetMapping("/all")
	public ResponseEntity<?> showAll() {
		ResponseEntity<?> reso = null;
		List<WhUserType> list = service.getAllWhUserTypes();
		if (list != null && !list.isEmpty()) {
			reso = new ResponseEntity<List<WhUserType>>(list, HttpStatus.OK);
		} else {
			reso = new ResponseEntity<String>("NO Data Found", HttpStatus.OK);

		}

		return reso;
	}

	@PostMapping("/save")
	public ResponseEntity<String> showSavedData(@RequestBody WhUserType whUserType) {
		ResponseEntity<String> resp = null;

		try {
			Integer sid = service.saveWhUserType(whUserType);
			String data = " Saved With id:" + sid;
			resp = new ResponseEntity<String>(data, HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@DeleteMapping("/delete/{whu}")
	public ResponseEntity<?> getDelete(@PathVariable Integer whu) {
		ResponseEntity<?> respone = null;
		try {
			service.deleteWhUserType(whu);
			respone = new ResponseEntity<String>(whu + "Deletd Successfully With Id", HttpStatus.OK);
		} catch (Exception e) {
			respone = new ResponseEntity<String>(whu + "Deletd Successfully With Id", HttpStatus.BAD_REQUEST);
		}
		return respone;
	}

	@GetMapping("/getOne/{whu}")
	public ResponseEntity<?> getOneRow(@PathVariable Integer whu) {
		ResponseEntity<?> resp = null;
		try {
			WhUserType sh = service.getWhUserTypeById(whu);
			if (sh != null) {
				resp = new ResponseEntity<WhUserType>(sh, HttpStatus.OK);

			} else {
				resp = new ResponseEntity<String>(whu + "Unable To Find In DB", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>(whu + "Cannot To Find In DB", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}

	@PutMapping("/update")
	public ResponseEntity<?> getUpdate(@RequestBody WhUserType whUserType) {
		ResponseEntity<?> response = null;
		try {
			service.updateWhUserType(whUserType);
			response = new ResponseEntity<String>("Update Successfully With Id", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>("No Data Found With Id", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
