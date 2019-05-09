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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("/rest/ship")
public class ShipmentTypeRestController {

	@Autowired
	private IShipmentTypeService service;

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> resp = null;

		List<ShipmentType> list = service.getAllShipmentTypes();
		if (list != null && !list.isEmpty()) {
			resp = new ResponseEntity<List<ShipmentType>>(list, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("No Data Found", HttpStatus.OK);
		}

		return resp;
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody ShipmentType shipmentType) {
		ResponseEntity<String> resp = null;
		try {
			Integer sid = service.saveShipmentType(shipmentType);
			String body = " Saved With id:" + sid;
			resp = new ResponseEntity<String>(body, HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@DeleteMapping("/delete/{sid}")
	public ResponseEntity<?> getDelete(@PathVariable Integer sid) {
		ResponseEntity<?> respone = null;
		try {
			service.deleteShipmentType(sid);
			respone = new ResponseEntity<String>(sid + "Deletd Successfully With Id", HttpStatus.OK);
		} catch (Exception e) {
			respone = new ResponseEntity<String>(sid + "Deletd Successfully With Id", HttpStatus.BAD_REQUEST);
		}
		return respone;
	}

	@GetMapping("/getOne/{sid}")
	public ResponseEntity<?> getOneRow(@PathVariable Integer sid) {
		ResponseEntity<?> resp = null;
		try {
			ShipmentType sh = service.getShipmentById(sid);
			if (sh != null) {
				resp = new ResponseEntity<ShipmentType>(sh, HttpStatus.OK);

			} else {
				resp = new ResponseEntity<String>(sid + "Unable To Find In DB", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>(sid + "Cannot To Find In DB", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}

	@PutMapping("/update")
	public ResponseEntity<?> getUpdateData(@RequestBody ShipmentType shipmentType) {
		ResponseEntity<?> resp = null;
		try {
			service.updateShipementType(shipmentType);
			resp = new ResponseEntity<String>("Updated Successfully With Id", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("NO Data Found", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}

}
