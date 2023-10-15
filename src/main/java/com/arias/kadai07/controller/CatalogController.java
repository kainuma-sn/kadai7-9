package com.arias.kadai07.controller;

import com.arias.kadai07.entity.Catalog_List;
import com.arias.kadai07.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogController {
    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/names")
    public List<Catalog_List> findAll() {
        return catalogService.findAll();
    }
}
