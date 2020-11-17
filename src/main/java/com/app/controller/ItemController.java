package com.app.controller;

import com.app.base.*;
import com.app.dto.ItemDTO;
import com.app.service.ItemService;
import com.app.service.UomService;
import com.app.specification.GeneralSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.Item;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("api/item")
public class ItemController extends BaseController{
	
	@Autowired
	ItemService itemService;
	@Autowired
	UomService uomService;

	@GetMapping("/findAllItem")
	public ResponseEntity<Response<Item>> findAllItem(@RequestParam int page,
											 @RequestParam int limit,
											 @RequestParam(required = false) String search){
		// TableRequest tableRequest =  null;
		Pageable pageable = PageRequest.of(page, limit, Sort.by("id"));
		GeneralSpecification specificationMatch = null;
		Specification specification = null;

		if (search != null && !search.isEmpty()){
			specificationMatch = new GeneralSpecification(
					new SearchCriteria(search, SearchOperation.MATCH, "name", "code"));

			GeneralSpecification uomSpecification = new GeneralSpecification();
			specification = Specification.where(specificationMatch).or(uomSpecification.joinUom(search));
		}

		Page<Item> itemPage = itemService.paging(specification, pageable);
		return new ResponseEntity(new Response(itemPage.getContent(), itemPage.getTotalElements()), HttpStatus.OK);
	}
	
	@GetMapping("/edit/{id}")
	public ResponseEntity<ItemDTO> edit(@PathVariable Integer id) {

		ItemDTO itemDTO = new ItemDTO();

		Optional<Item> item = itemService.findById(id);
		if (!item.isPresent()) {
			return new ResponseEntity(new Response("Record Not Found"), HttpStatus.BAD_REQUEST);
		}
		itemDTO.setItem(item.get());
		itemDTO.setUomList(uomService.findAllList());

		return new ResponseEntity(new Response(itemDTO), HttpStatus.OK);
	}

	@GetMapping("/add")
	public ResponseEntity<ItemDTO> add() {

		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setUomList(uomService.findAllList());
		return new ResponseEntity(new Response(itemDTO), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Item> save(@RequestBody Item item){
		try {
			Optional<Item> itermAlready = itemService.findByCode(item.getCode());
			if(itermAlready.isPresent()){
				return new ResponseEntity(new Response("Code already exists"), HttpStatus.BAD_REQUEST);
			}
			item = itemService.save(item);
		}catch(Exception e){
			logger.error(e.getMessage());
			return new ResponseEntity(new Response(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Response(item), HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<Item> update(@RequestBody Item item){
		try {
			item = itemService.update(item);
		}catch (Exception e){
			logger.error(e.getMessage());
			return new ResponseEntity(new Response(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Response<>(item), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{ids}")
	public ResponseEntity<Item> delete(@PathVariable List<Integer> ids){
		try {
			itemService.deleteByIds(ids);
		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity(new Response<>(e.getMessage()), HttpStatus.OK);
		}

		return new ResponseEntity(new Response("Delete Successfully"), HttpStatus.OK);
		
	}

}
