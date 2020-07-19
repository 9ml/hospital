package com.litbo.hospitalzj.zk.controller;

import com.litbo.hospitalzj.zk.domian.DcsjhyTemplate;
import com.litbo.hospitalzj.zk.service.DcsjhyTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/zk")
public class DcsjhyTemplateController {

	@Autowired
	private DcsjhyTemplateService dcsjhyTemplateService;
	
	@RequestMapping("/insert")
	public String insert(){
		DcsjhyTemplate dt=new DcsjhyTemplate();
		dt.setDcTemplateid(UUID.randomUUID().toString());
		dt.setXlTest1(20);
		dt.setXlWc("10");
		dcsjhyTemplateService.insert(dt);
		return "success";
	}
	
	@RequestMapping("/delete")
	public String delete(){
		String id="f1f98c86-e26d-4b8d-85bc-154b67f5ffee";
		dcsjhyTemplateService.delete(id);
		return "deleteSuccess";
	}
	
	@RequestMapping("/findAll")
	public List<DcsjhyTemplate> findAll(){
		return dcsjhyTemplateService.findAll();
	}
	
	@RequestMapping("/findAll1")
	public String findAll1(Model model){
		List<DcsjhyTemplate> dataList=dcsjhyTemplateService.findAll();
		model.addAttribute("dataList", dataList);
		return "show";
	}
	
	
}
