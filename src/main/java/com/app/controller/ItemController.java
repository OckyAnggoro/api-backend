package com.app.controller;

import com.app.base.*;
import com.app.service.ItemService;
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
import com.app.model.Item;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("api/item")
public class ItemController extends BaseController{
	
	@Autowired
	ItemService itemService;
//	@Autowired
//	UomService uomService;

	@GetMapping("/findItem")
	public ResponseEntity<Page<Item>> findItem(@RequestParam int page,
											 @RequestParam int limit,
											 @RequestParam(required = false) String search){
		// TableRequest tableRequest =  null;
		Pageable pageable = PageRequest.of(page, limit, Sort.by("name"));

		GeneralSpecification specificationMatch = new GeneralSpecification(
				new SearchCriteria(search, SearchOperation.MATCH, "name", "code"));

		GeneralSpecification generalSpecification = new GeneralSpecification();
		Specification specification = Specification.where(specificationMatch).or(generalSpecification.joinUom(search));
		Page<Item> itemPage = itemService.findItem(specification, pageable);
		return new ResponseEntity<>(itemPage, HttpStatus.OK);
	}
	
//	@PostMapping("/add-edit")
//	public ResponseEntity<ItemDTO> addEdit(@RequestBody RequestModel requestModel) {
//
//		ItemDTO itemDTO = new ItemDTO();
//		if(requestModel.getAction().equalsIgnoreCase("edit")) {
//			itemDTO.setItem(itemService.findByCode(requestModel.getCode()));
//		}
//		itemDTO.setUomList(uomService.findList());
//		return new ResponseEntity<>(itemDTO, HttpStatus.OK);
//	}
	
	@PostMapping("/save")
	public ResponseEntity<Item> save(@RequestBody Item item){
		item = itemService.save(item);
		return new ResponseEntity<Item>(item, HttpStatus.OK);	
	}
	
	@PostMapping("/delete")
	public ResponseEntity<Item> delete(@RequestBody Item item){
		try {
			item.setIsDelete(AppConstant.FLAG_IS_DELETED);
			item = itemService.save(item);
		}catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return new ResponseEntity<Item>(item, HttpStatus.OK);
		
	}

}
