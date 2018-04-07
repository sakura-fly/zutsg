package com.zutsg.controller;

import com.zutsg.dao.ScientificMapper;
import com.zutsg.pojo.Scientific;
import com.zutsg.pojo.User;
import com.zutsg.service.ScientificServiceImpl;
import com.zutsg.unti.PageBean;
import com.zutsg.unti.ReturnDatas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/scientfic")
public class ScientficController  {

    @Resource
    private ScientificServiceImpl scientificService;
    /*
    * 分页的查询
   * */
    @RequestMapping("/listPage")
    public @ResponseBody
    ReturnDatas listPage(Scientific scientific, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();

        try {
            if(pageBean!=null){
                List<Scientific> scientificList=scientificService.selectByScientfic(scientific);
                pageBean.setCount(scientificList.size());
                PageBean pageBeanResult=PageBean.pageBean(pageBean);
                scientific.setPageBean(pageBeanResult);
                returnDatas.setPageBean(pageBeanResult);
            }
            List<Scientific> scientificList=scientificService.selectByScientficPage(scientific);
            returnDatas.setData(scientificList);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    /*
   * 查询
  * */
    @RequestMapping("/list")
    public @ResponseBody
    ReturnDatas list(Scientific scientific,HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();

        try {
            List<Scientific> scientificList=scientificService.selectByScientfic(scientific);
            returnDatas.setData(scientificList);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    /*
     * 查询
     * */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody
    ReturnDatas add(Scientific scientific,HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();

        try {
            scientific.setCreateTime(new Date());
            scientificService.insertSelective(scientific);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    /*
    * 查询
    * */
    @RequestMapping(value = "/update",method= RequestMethod.POST)
    public @ResponseBody
    ReturnDatas update(Scientific scientific,HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage(" 成功！");
         if(scientific.getUserId()==null||scientific.getId()==null){
             return new ReturnDatas(ReturnDatas.ERROR,"请填写关键信息！");
         }

        try {
            scientificService.updateByPrimaryKeySelective(scientific);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    /*
    * 查询
    * */
    @RequestMapping( "/look")
    public @ResponseBody
    ReturnDatas look(Scientific scientific,HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage(" 成功！");
        if(scientific.getId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"请填写关键信息！");
        }
        try {
            scientificService.selectByPrimaryKey(scientific.getId());
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    /*
    * 查询
    * */
    @RequestMapping( "/delete")
    public @ResponseBody
    ReturnDatas delete(Scientific scientific,HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage(" 成功！");
        if(scientific.getId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"请填写关键信息！");
        }
        try {
            scientificService.deleteByPrimaryKey(scientific.getId());
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
}
