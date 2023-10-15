package com.arias.kadai07.service;

import com.arias.kadai07.entity.Catalog_List;
import com.arias.kadai07.mapper.CatalogMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    private final CatalogMapper catalogMapper;

    CatalogService(CatalogMapper catalogMapper) {
        this.catalogMapper = catalogMapper;
    }

    public List<Catalog_List> findAll() {
        return catalogMapper.findAll();
    }

    public void insert(List<Catalog_List> catalogList) {
        catalogMapper.insert(catalogList);
    }

    public void update(List<Catalog_List> catalogList) {
        catalogMapper.update(catalogList);
    }
}
