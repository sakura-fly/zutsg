package com.zutsg.controller;

import com.zutsg.pojo.User;
import com.zutsg.service.UserServiceImpl;
import com.zutsg.unti.PageBean;
import com.zutsg.unti.ReturnDatas;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/6 0006.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceImpl userSerive;

        /*
        * 分页的查询
       * */
    @RequestMapping("/listPage")
    public @ResponseBody
    ReturnDatas listPage(User user,PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();

        try {
            if(pageBean!=null){
                List<User> userList=userSerive.selectByUser(user);
                pageBean.setCount(userList.size());
                PageBean pageBeanResult=PageBean.pageBean(pageBean);
                user.setPageBean(pageBeanResult);
                returnDatas.setPageBean(pageBeanResult);
            }
            List<User> userList=userSerive.selectByUserPage(user);
            for (User data:userList){
                if (data!=null){
                    data.setPassword("***********");
                }
            }
            returnDatas.setData(userList);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }

        return returnDatas;
    }
    /*
     * 不分页的查询
    * */
    @RequestMapping("/list")
    public @ResponseBody
    ReturnDatas list(User user, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        try {
            List<User> userList=userSerive.selectByUser(user);
            for (User data:userList){
                if (data!=null){
                    data.setPassword("***********");
                }
            }
            returnDatas.setData(userList);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    /*
    * 新增接口
    * */
    @RequestMapping("/add")
    public @ResponseBody
    ReturnDatas add(User user, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("成功！");
        try {
            if(StringUtils.isBlank(user.getPhone())||StringUtils.isBlank(user.getPassword())||user.getRole()==null){
                return new ReturnDatas(ReturnDatas.ERROR,"注册失败，请你完善信息！");
            }
            List<User>  users=userSerive.selectByPhone(user.getPhone());
            if(users.size()>0&&users!=null){
                users.get(0).setPassword("");
                return new ReturnDatas(ReturnDatas.ERROR,"该手机号已被注册！");
            }
            user.setTime(new Date());
            user.setStatus(1);
            userSerive.insertSelective(user);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
     /*
      * 修改用户信息接口
     * */
    @RequestMapping("/update")
    public @ResponseBody
    ReturnDatas update(User user, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("修改成功！");
        if(user.getId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        try {
            userSerive.updateByPrimaryKeySelective(user);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    /*
    * 登录接口
    * */
    @RequestMapping("/login")
    public @ResponseBody
    ReturnDatas login(User user, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("登录成功！");
        if(StringUtils.isBlank(user.getPassword())||StringUtils.isBlank(user.getPhone())){
            return new ReturnDatas(ReturnDatas.ERROR,"请输入登录信息！");
        }
        try {
           List<User> userList=userSerive.selectByPhone(user.getPhone());
           if(userList.size()>0&&userList!=null){
               List<User> users=userSerive.selectByUser(user);
               if (users.size()>0&&users!=null){
                          users.get(0).setPassword("");
                       if (users.get(0).getStatus() == 2) {
                           request.getSession().setAttribute("userSession", users.get(0));
                           returnDatas.setData(users.get(0));
                       } else if (users.get(0).getStatus() == 1) {
                           return new ReturnDatas(ReturnDatas.ERROR, "你的账号还在申请中！");
                       } else if (users.get(0).getStatus()==3) {
                           return new ReturnDatas(ReturnDatas.ERROR, "你的账号还在申请中！\r\n"+users.get(0).getReason()==null?"":users.get(0).getReason());
                       } else if (users.get(0).getStatus()==0){
                           return new ReturnDatas(ReturnDatas.ERROR, "非法用户！");
                       }
               }else {
                   return new ReturnDatas(ReturnDatas.ERROR,"用户名或密码错误！");
               }
           }else {
               return new ReturnDatas(ReturnDatas.ERROR,"该用户未注册！");
           }
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    /*
    退出接口
    */
    @RequestMapping("/exit")
    public @ResponseBody
    ReturnDatas exit(User user, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("退出成功！");
        try {
            request.getSession().invalidate();
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    /*
    * 同意注册接口
    * */
    @RequestMapping("/agree")
    public @ResponseBody
    ReturnDatas agree(User user, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("审核成功！");
        if(user.getId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        try {
            user.setStatus(2);
            userSerive.updateByPrimaryKeySelective(user);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
   /*
   * 拒绝注册接口
   * */
    @RequestMapping("/refuse")
    public @ResponseBody
    ReturnDatas refuse(User user, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("拒绝成功！");
        if(user.getId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        try {
            user.setStatus(3);
            userSerive.updateByPrimaryKeySelective(user);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }

    @RequestMapping("/look")
    public @ResponseBody
    ReturnDatas look(User user, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        if(user.getId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        try {
            User userResult=userSerive.selectByPrimaryKey(user.getId());
            returnDatas.setData(userResult);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    @RequestMapping("/delete")
    public @ResponseBody
    ReturnDatas delete(User user, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        if(user.getId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        try {
            userSerive.deleteByPrimaryKey(user.getId());
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }




}
