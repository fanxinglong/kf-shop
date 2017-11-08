package com.kingfisher.shop.manager.service;


import com.github.pagehelper.PageInfo;
import com.kingfisher.shop.manager.model.Brand;
import com.kingfisher.shop.manager.vo.DataGridResult;

import java.util.List;

public interface BrandService {
	
	//查询分页对象
	public PageInfo<Brand> selectPaginationByQuery(String name, Integer isDisplay, Integer pageNo);
	//通过ID查询品牌
	public Brand selectBrandById(Long id);

}
