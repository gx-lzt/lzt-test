package com.hd.controller;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hd.model.tsUser;
import com.hd.server.UserServer;
 

@Controller
@RequestMapping("/user")
public class UserContraller {
	
	@Resource
	private UserServer userServer;
	 
 
//	查询 
	@RequestMapping("/query")
	public String query(Model model,Integer id){
		tsUser user =userServer.selectByPrimaryKey(id);
		model.addAttribute("user", user); 
		return "userJson";
	}
	

	@RequestMapping("/delete")
	public String delete (int userid){
		userServer.deleteByPrimaryKey(userid)	;
//		如果返回字符串无效，则加上命名空间
		return "success";
	}
  
	
}
