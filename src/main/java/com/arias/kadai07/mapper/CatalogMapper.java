package com.arias.kadai07.mapper;

import com.arias.kadai07.entity.Catalog_List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CatalogMapper {

    @Select("SELECT * FROM catalog_list")
    List<Catalog_List> findAll();
}
