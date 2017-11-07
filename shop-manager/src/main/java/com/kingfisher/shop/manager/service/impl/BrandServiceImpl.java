package com.kingfisher.shop.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kingfisher.shop.manager.mapper.BrandDao;
import com.kingfisher.shop.manager.model.Brand;
import com.kingfisher.shop.manager.service.BrandService;
import com.kingfisher.shop.manager.model.BrandQuery;
import com.kingfisher.shop.manager.vo.DataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 品牌管理
 * @author lx
 *
 */
@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;
	//查询分页对象
	public DataGridResult selectPaginationByQuery(String name, Integer isDisplay, Integer pageNo){
		BrandQuery brandQuery = new BrandQuery();
		//每页数
		brandQuery.setPageSize(3);
		
		StringBuilder params = new StringBuilder();
		
		//条件
		if(null != name){
			brandQuery.setName(name);
			params.append("name=").append(name);
		}
		if(null != isDisplay){
			brandQuery.setIsDisplay(isDisplay);
			params.append("&isDisplay=").append(isDisplay);
		}else{
			brandQuery.setIsDisplay(1);
			params.append("&isDisplay=").append(1);
		}

		//设置分页信息
		PageHelper.startPage(brandQuery.getPageNo(), brandQuery.getPageSize());

//		Pagination pagination = new Pagination(
//				brandQuery.getPageNo(),
//				brandQuery.getPageSize(),
//				brandDao.selectCount(brandQuery)
//				);
		List<Brand> list = brandDao.selectBrandListByQuery(brandQuery);
		//取查询结果
		PageInfo<Brand> pageInfo = new PageInfo<>(list);
		DataGridResult result = new DataGridResult();
		result.setRows(list);
		result.setTotal(brandDao.selectCount(brandQuery));
		//返回结果
		return result;
	}
	@Override
	public Brand selectBrandById(Long id) {
		// TODO Auto-generated method stub
		return brandDao.selectBrandById(id);
	}
}
