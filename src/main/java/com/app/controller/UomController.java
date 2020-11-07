package com.app.controller;

import com.app.base.*;
import com.app.specification.GeneralSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.Uom;
import com.app.service.UomService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/uom")
public class UomController extends BaseController{
	
	@Autowired
	UomService uomService;

	@GetMapping("/findAllUom")
	public ResponseEntity<Response<Uom>> findAllUom(@RequestParam String page,
											 @RequestParam String limit,
											 @RequestParam(required = false) String search){
		// TableRequest tableRequest =  null;
		Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit), Sort.by("name"));

		GeneralSpecification specificationMatch = new GeneralSpecification(new SearchCriteria(search, SearchOperation.MATCH, "name", "code"));
		Page<Uom> uomPage = uomService.paging(specificationMatch, pageable);
		return new ResponseEntity(new Response(uomPage.getContent(), uomPage.getTotalElements()), HttpStatus.OK);
	}

	@GetMapping("/edit/{id}")
	public ResponseEntity<Uom> edit(@PathVariable Integer id){

		Optional<Uom> findUom = uomService.findById(id);
		if (!findUom.isPresent()){
			return new ResponseEntity(new Response("Record Not Found"), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(new Response(findUom.get()), HttpStatus.OK);

	}

	@PostMapping("/save")
	public ResponseEntity<Uom> save(@RequestBody Uom uom){
		try {
			Optional<Uom> uomAlready = uomService.findByCode(uom.getCode());
			if (uomAlready.isPresent()) {
				return new ResponseEntity(new Response("Code " + uomAlready.get().getCode()+ " already exists"), HttpStatus.BAD_REQUEST);
			}
			uom = uomService.save(uom);
		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity(new Response(e.getMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(new Response(uom), HttpStatus.OK);

	}

	@PostMapping("/update")
	public ResponseEntity<Uom> update(@RequestBody Uom uom){
		try {
			uom = uomService.update(uom);
		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity(new Response<Uom>(e.getMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(new Response(uom), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{ids}")
	public ResponseEntity<Uom> delete(@PathVariable List<Integer> ids){
		try {
			uomService.deleteByIds(ids);
		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity(new Response(e.getMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(new Response("Delete Successfully"), HttpStatus.OK);

	}
	
}
