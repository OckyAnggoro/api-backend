package com.app.controller;

import com.app.base.Response;
import com.app.base.SearchCriteria;
import com.app.base.SearchOperation;
import com.app.model.Outlet;
import com.app.service.OutletService;
import com.app.specification.GeneralSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/outlet")
public class OutletController extends BaseController{

    @Autowired
    OutletService outletService;

    @GetMapping("/findAllOutlet")
    public ResponseEntity<Outlet> findAllOutlet(@RequestParam int page,
                                              @RequestParam int limit, @RequestParam(required = false) String search){
        Pageable pageable = PageRequest.of(page, limit, Sort.by("id").descending());
        GeneralSpecification<Outlet> specification = new GeneralSpecification<>(new SearchCriteria(search, SearchOperation.MATCH, "name"));
        Page<Outlet> outletPage = outletService.paging(specification, pageable);
        return new ResponseEntity(new Response<>(outletPage.getContent(), outletPage.getTotalElements()), HttpStatus.OK);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Outlet> edit(@PathVariable Integer id){

        Optional<Outlet> outlet = outletService.findById(id);
        if (!outlet.isPresent()){
            return new ResponseEntity(new Response("Record Not Found"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new Response(outlet.get()), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Outlet> save(@RequestBody Outlet outlet){

        try {
            outlet = outletService.save(outlet);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity(new Response(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new Response(outlet), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Outlet> update(@RequestBody Outlet outlet){

        try {
            outlet = outletService.save(outlet);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity(new Response(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new Response(outlet), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{ids}")
    public ResponseEntity delete(@PathVariable List<Integer> ids){
        try {
            outletService.deleteByIds(ids);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity(new Response(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new Response("Delete Successfully"), HttpStatus.OK);
    }
}
