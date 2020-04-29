package com.litbo.hospitalzj.sf.service.lmpl;

import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.sf.mapper.UserMapper;
import com.litbo.hospitalzj.sf.service.UserService;
import com.litbo.hospitalzj.sf.vo.UserRoleVo;
import com.litbo.hospitalzj.supplier.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserMapper userMapper;
    //删除用户
    @Override
    public void delete(String userId,Integer isDelete) {
        UserRoleVo data=userMapper.select(userId);
        if(data==null){
            throw new DeleteException("用户不存在");
        }
        userMapper.delete(userId,isDelete);
    }
    //插入用户
    @Override
    public User insert(User user) {
        // 根据尝试注册的用户名查询用户数据
        UserRoleVo data = userMapper.findByName(user.getUserName());
        // 判断查询到的数据是否为null
        if (data == null) {
            user.setIsDelete(0);
            add(user);
            // 返回注册的用户对象
            return user;
        } else {
            // 否：用户名已被占用，抛出DuplicateKeyException异常
            throw new DuplicateKeyException(
                    "插入失败！尝试插入的用户名(" + user.getUserName() + ")已经被占用！");
        }
    }
    private void add(User user) {
        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException(
                    "增加用户数据时出现未知错误！");
        }
    }
    //通过用户id查询用户信息
    @Override
    public UserRoleVo select(String userId) {
        UserRoleVo data=userMapper.select(userId);
        return data;
    }
    //修改用户信息
    @Override
    public void update(User user) {
        /*UserRoleVo data=userMapper.select(user.getUserId());
        if(data==null){
            throw new UpdateException("用户不存在");
        }*/
        user.setIsDelete(0);
        System.out.println(user);
        userMapper.update(user);
    }
    //修改用户角色
    @Override
    public void updateRole(String roleId, String userId) {
        userMapper.updateRole(roleId, userId);
    }

    @Override
    public String findNameById(String userId) {
        return userMapper.findNameById(userId);
    }

    //用户登录
    @Override
    public UserRoleVo login(String userName, String userPwd) {
        // 根据参数username查询用户数据
        UserRoleVo data = userMapper.findByName(userName);
        // 判断用户数据是否为null
        if (data == null) {
            // 是：为null，用户名不存在，则抛出UserNotFoundException
            throw new UserNotFoundException(
                    "登录失败！您尝试登录的用户名不存在！");}
        if(userPwd.equals(data.getUserPwd())){
            //是：匹配，密码正确，则判断是否被删除
            if (data.getIsDelete() == 1) {
                // 是：已被删除，则抛出UserNotFoundException或自定义“用户被删除异常”
                throw new UserNotFoundException(
                        "登录失败！您尝试登录的用户数据已经被删除！");
            }
            // 否：没被删除，则登录成功，将第1步查询的用户数据中的盐值和密码设置为null
            data.setUserPwd(null);
            return data;
        }else {
            // 否：不匹配，密码错误，则抛出PasswordNotMatchException
            throw new PasswordNotMatchException(
                    "登录失败！密码错误！");
        }

    }
    //查询所有用户信息
    @Override
    public List<UserRoleVo> findAll() {
        return userMapper.findAll();
    }
    //模糊查询用户信息
    @Override
    public List<UserRoleVo> findByNameLike(String userName) {
        return userMapper.findByNameLike(userName);
    }

    @Override
    public List<String> findRoleName() {
        return userMapper.findRoleName("超级管理员");
    }
}
