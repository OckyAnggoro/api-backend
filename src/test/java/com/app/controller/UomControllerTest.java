package com.app.controller;


import com.app.base.RequestModel;
import com.app.model.Uom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UomControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testAddEdit() throws Exception {
        RequestModel requestModel = new RequestModel();
        requestModel.setCode("1010501008000099");
        requestModel.setAction("edit");
        ResponseEntity<Uom> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/api/uom/add-edit", requestModel, Uom.class);
        assertEquals("1010501008000099", responseEntity.getBody().getCode());
    }
}