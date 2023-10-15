package com.arias.kadai07.mapper;

import com.arias.kadai07.entity.Catalog_List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CatalogMapper {

    @Select("SELECT * FROM catalog_list")
    List<Catalog_List> findAll();

    @Insert({
            "<script>",
            "INSERT INTO catalog_list (productName, productPrice, productStock) VALUES ",
            "<foreach collection='list' item='item' separator=','>",
            "  (#{item.productName}, #{item.productPrice}, #{item.productStock})",
            "</foreach>",
            "</script>"
    })
    int insert(@Param("list") List<Catalog_List> catalogList);
}
