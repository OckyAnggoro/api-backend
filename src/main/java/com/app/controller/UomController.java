package com.app.controller;

import com.app.base.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.AppConstant;
import com.app.model.Uom;
import com.app.service.UomService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/uom")
public class UomController extends BaseController{
	
	@Autowired
	UomService uomService;
	
	@GetMapping("/findUom")
	public ResponseEntity<Page<Uom>> findUom(@RequestParam int page,
											 @RequestParam int limit,
											 @RequestParam(required = false) String search){
		// TableRequest tableRequest =  null;
		Pageable pageable = PageRequest.of(page, limit, Sort.by("name"));

		GeneralSpecification specificationMatch = new GeneralSpecification(new SearchCriteria(search, SearchOperation.MATCH, "name", "code"));
		Page<Uom> uomPage = uomService.findUom(specificationMatch, pageable);
		return new ResponseEntity<>(uomPage, HttpStatus.OK);
	}
//
//	@PostMapping("/add-edit")
//	public ResponseEntity<Uom> addEdit(@RequestBody RequestModel requestModel){
//
//		Uom findUom = null;
//		if(requestModel.getAction().equalsIgnoreCase("edit")) {
//			findUom = uomService.findByCode(requestModel.getCode());
//			// findUom = new Uom("Lembar", "1010501008000099");
//		}
//
//		return new ResponseEntity<Uom>(findUom, HttpStatus.OK);
//
//	}
//
//	@PostMapping("/save")
//	public ResponseEntity<Uom> save(@RequestBody Uom uom){
//		try {
//			uom = uomService.save(uom);
//		}catch (Exception e) {
//			logger.error(e.getMessage());
//		}
//
//		return new ResponseEntity<Uom>(uom, HttpStatus.OK);
//
//	}
//
//	@PostMapping("/delete")
//	public ResponseEntity<Uom> delete(@RequestBody Uom uom){
//		try {
//			uom.setIsDelete(AppConstant.FLAG_IS_DELETED);
//			uom = uomService.save(uom);
//		}catch (Exception e) {
//			logger.error(e.getMessage());
//			e.printStackTrace();
//		}
//
//		return new ResponseEntity<Uom>(uom, HttpStatus.OK);
//
//	}
//
//
//	 @GetMapping("/checkAlreadyCode")
//	 protected boolean checkAlreadyCode(@RequestBody String code) {
//		 Boolean isAlreadyCode = uomService.checkAlreadyCode(code);
//		 return isAlreadyCode;
//	 }
	
}
