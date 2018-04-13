package com.zutsg.controller;

import com.zutsg.pojo.GardenGeneral;
import com.zutsg.service.GardenGeneralServiceImpl;
import com.zutsg.unti.ReturnDatas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/4/7 0007.
 */
@Controller
@RequestMapping("/gardenGeneral")
public class GardenGeneralController {
     @Resource
      private GardenGeneralServiceImpl gardenGeneralService;


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public @ResponseBody
    ReturnDatas update(GardenGeneral gardenGeneral, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("成功！");
        try {
            gardenGeneral.setId(1);
            gardenGeneralService.updateByPrimaryKeySelective(gardenGeneral);
        }catch (Exception e){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }

    @RequestMapping("/look")
    public @ResponseBody
    ReturnDatas look(GardenGeneral gardenGeneral, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("成功！");
        try {
           GardenGeneral gardenGeneralResult= gardenGeneralService.selectByPrimaryKey(1);
           returnDatas.setData(gardenGeneralResult);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }

}
