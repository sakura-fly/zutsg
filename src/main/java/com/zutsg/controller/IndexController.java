package com.zutsg.controller;


import com.zutsg.pojo.User;
import com.zutsg.service.UserSeriveImpl;
import com.zutsg.unti.PageBean;
import com.zutsg.unti.ReturnDatas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {

@Resource
private UserSeriveImpl userSerive;
    @RequestMapping("/test")
    public @ResponseBody ReturnDatas  test(User user){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
         List<User> userList=userSerive.selectByUser(user);
        returnDatas.setData(userList);
        return returnDatas;
    }
}
