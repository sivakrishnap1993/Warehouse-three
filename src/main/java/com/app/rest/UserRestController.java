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

import com.app.model.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/rest/userone")
public class UserRestController {

	@Autowired
	private IUserService service;

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> rrr = null;
		List<User> list = service.getAllUsers();
		if (list != null && !list.isEmpty()) {
			rrr = new ResponseEntity<List<User>>(list, HttpStatus.OK);
		} else {
			rrr = new ResponseEntity<String>("No Data Found", HttpStatus.OK);
		}
		return rrr;
	}

	@PostMapping("/save")
	public ResponseEntity<String> getSaveFile(@RequestBody User user) {
		ResponseEntity<String> res = null;
		try {
			Integer sid = service.saveUser(user);
			String body = " Saved With Id:" + sid;
			res = new ResponseEntity<String>(body, HttpStatus.OK);
		} catch (Exception e) {
			res = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;

	}

	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<?> getDelete(@PathVariable Integer uid) {
		ResponseEntity<?> resp = null;
		try {
			service.deleteUser(uid);
			resp = new ResponseEntity<String>(uid + "Deleted Successfully With Id", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(uid + "Unable to Delete With Id", HttpStatus.OK);
		}

		return resp;
	}

	@GetMapping("/getOne/{uid}")
	public ResponseEntity<?> getOne(@PathVariable Integer uid) {
		ResponseEntity<?> resp = null;

		try {
			User or = service.getUserById(uid);
			if (or != null) {
				resp = new ResponseEntity<User>(or, HttpStatus.OK);

			} else {
				resp = new ResponseEntity<String>(uid + "No Data Found In DB", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>(uid + "No Data Found In DB", HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return resp;
	}

	@PutMapping("/update")
	public ResponseEntity<?> getUpdate(@RequestBody User user) {
		ResponseEntity<?> resp = null;
		try {
			service.updateUser(user);
			resp = new ResponseEntity<String>("Update Successfully With Id", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("No Data Found With Id", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
}
