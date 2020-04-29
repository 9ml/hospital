package com.litbo.hospitalzj.sf.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.sf.service.UserService;
import com.litbo.hospitalzj.sf.vo.UserRoleVo;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public ResponseResult<User> login
            (@RequestParam("userName") String userName,
             @RequestParam("userPwd") String userPwd,
             HttpSession session) {
        UserRoleVo data=userService.login(userName,userPwd);
        // 将相关信息存入到Session
        session.setAttribute("uid", data.getUserId());
        session.setAttribute("userName", data.getUserName());
        return new ResponseResult<User>(SUCCESS,data.getRoleName());
    }
    @RequestMapping("/{userId}")
    public ResponseResult<UserRoleVo> getByCode(@PathVariable("userId") String userId) {
        UserRoleVo data=userService.select(userId);
        return new ResponseResult<UserRoleVo>(SUCCESS,data);
    }

    @RequestMapping("/all")
    public ResponseResult<List<UserRoleVo>> getAll() {
        List<UserRoleVo> data=userService.findAll();
        return new ResponseResult<List<UserRoleVo>>(SUCCESS,data);
    }
    @RequestMapping("/insert")
    public ResponseResult<Void> insert(User user) {
        userService.insert(user);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/delete")
    public ResponseResult<Void> delete(String userId) {
        userService.delete(userId,1);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/update")
    public ResponseResult<User> update(User user) {
        System.out.println(user.getUserId());
        System.out.println(user);
        System.out.println(user.getRoleId());
        userService.update(user);
        return new ResponseResult<User>(SUCCESS);
    }
    @RequestMapping("/findByLike")
    public ResponseResult<List<UserRoleVo>> getAll(String userName) {
        List<UserRoleVo> data=userService.findByNameLike(userName);
        return new ResponseResult<List<UserRoleVo>>(SUCCESS,data);
    }
    @RequestMapping("/updateRole")
    public ResponseResult<Void> updateRole(@RequestParam("roleId") String roleId, @RequestParam("userId")String userId) {
        userService.updateRole(roleId,userId);
        return new ResponseResult<Void>(SUCCESS);
    }
}
