package com.kingfisher.shop.manager.mapper;

import com.kingfisher.shop.manager.model.Brand;
import com.kingfisher.shop.manager.model.BrandQuery;

import java.util.List;



/**
 * 查询
 * @author lx
 *
 */
public interface BrandDao {

	
	//查询结果集
	public List<Brand> selectBrandListByQuery(BrandQuery brandQuery);
	//查询总条数
	public Integer selectCount(BrandQuery brandQuery);
	//通过ID查询品牌
	public Brand selectBrandById(Long id);
}
