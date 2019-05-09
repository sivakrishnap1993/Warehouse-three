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

import com.app.model.Admin;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/rest/adminpage")
public class AdminRestController {

	@Autowired
	private IAdminService service;

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> res = null;

		List<Admin> list = service.getAllAdmins();
		if (list != null && !list.isEmpty()) {
			res = new ResponseEntity<List<Admin>>(list, HttpStatus.OK);
		} else {
			res = new ResponseEntity<String>("NO Data Found", HttpStatus.OK);
		}
		return res;
	}

	@PostMapping("/save")
	public ResponseEntity<String> getSaveFile(@RequestBody Admin admin) {
		ResponseEntity<String> ress = null;
		try {
			Integer sid = service.saveAdmin(admin);
			String body = " Saved With Id :" + sid;
			ress = new ResponseEntity<String>(body, HttpStatus.OK);
		} catch (Exception e) {
			ress = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return ress;
	}

	@DeleteMapping("/delete/{aid}")
	public ResponseEntity<?> getDelete(@PathVariable Integer aid) {
		ResponseEntity<?> response = null;
		try {
			service.deleteAdmin(aid);
			response = new ResponseEntity<String>(aid + " Deleted With Id", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>(aid + " Unable To Delete With Id", HttpStatus.OK);
		}

		return response;
	}

	@GetMapping("/getOne/{aid}")
	public ResponseEntity<?> getOneObje(@PathVariable Integer aid) {
		ResponseEntity<?> resp = null;

		try {
			Admin ad = service.getAdminById(aid);
			if (ad != null) {
				resp = new ResponseEntity<Admin>(ad, HttpStatus.OK);

			} else {
				resp = new ResponseEntity<String>(aid + "No Data Found in DB", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>(aid + "Unable To Find Found Object", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	@PutMapping("/update")
	public ResponseEntity<?> getUpdate(@RequestBody Admin admin) {
		ResponseEntity<?> response = null;
		try {
			service.updateAdmin(admin);
			response = new ResponseEntity<String>("Update Suddessfully With id", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>("No Data Found With id", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
