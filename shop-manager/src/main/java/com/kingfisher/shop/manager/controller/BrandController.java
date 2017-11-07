package com.kingfisher.shop.manager.controller;

import com.github.pagehelper.PageInfo;
import com.kingfisher.shop.manager.model.Brand;
import com.kingfisher.shop.manager.service.BrandService;
import com.kingfisher.shop.manager.util.R;
import com.kingfisher.shop.manager.vo.DataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 品牌管理
 * 列表
 * 删除
 * 修改
 * 添加
 * 删除（单）
 * @author lx
 *
 */
@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	//查询
	@RequestMapping(value = "/brand/list.do")
	@ResponseBody
	public R list(String name, Integer isDisplay, Integer pageNo){
		
		//Pagination pagination = brandService.selectPaginationByQuery(name, isDisplay, pageNo);
		//model.addAttribute("pagination", pagination);
		if(null != isDisplay){
			R.ok().put("isDisplay", isDisplay);
		}else{
			R.ok().put("isDisplay", 1);
		}

		DataGridResult result = brandService.selectPaginationByQuery(name, isDisplay, pageNo);
		//return result;
		/////////
		 //= brandService.selectPaginationByQuery(name, isDisplay, pageNo);
		return R.ok().put("pagination", new PageInfo<Brand>(result)).put("name", name).put("data", result);

	}
	//去修改页面
	@RequestMapping(value = "/brand/toEdit.do")
	public String toEdit(Long id,Model model){
		Brand brand = brandService.selectBrandById(id);//Shift+Alt +L
		model.addAttribute("brand", brand);
		
		return "brand/edit";
	}
}
