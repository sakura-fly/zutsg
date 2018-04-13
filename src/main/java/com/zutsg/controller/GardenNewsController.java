package com.zutsg.controller;

import com.zutsg.pojo.GardenNews;
import com.zutsg.pojo.Interspace;
import com.zutsg.service.GardenNewsServiceImpl;
import com.zutsg.service.InterspaceServiceImpl;
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
 * Created by Administrator on 2018/4/7 0007.
 */
@Controller
@RequestMapping("/gardenNews")
public class GardenNewsController {
    @Resource
    private GardenNewsServiceImpl gardenNewsService;

    @RequestMapping("/listPage")
    public @ResponseBody
    ReturnDatas listPage(GardenNews gardenNews, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();

        try {
            if(pageBean!=null){
                List<GardenNews> gardenNewsList=gardenNewsService.selectByNews(gardenNews);
                pageBean.setCount(gardenNewsList.size());
                PageBean pageBeanResult=PageBean.pageBean(pageBean);
                gardenNews.setPageBean(pageBeanResult);
                returnDatas.setPageBean(pageBeanResult);
            }
            List<GardenNews> gardenNewsList=gardenNewsService.selectByNewsPage(gardenNews);
            returnDatas.setData(gardenNewsList);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    @RequestMapping("/list")
    public @ResponseBody
    ReturnDatas list(GardenNews gardenNews, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        try {
            List<GardenNews> gardenNewsList=gardenNewsService.selectByNews(gardenNews);
            returnDatas.setData(gardenNewsList);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }

    @RequestMapping("/look")
    public @ResponseBody
    ReturnDatas look(GardenNews gardenNews, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        try {
            if(gardenNews.getId()==null){
                return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
            }
          GardenNews gardenNewsResult=gardenNewsService.selectByPrimaryKey(gardenNews.getId());
            returnDatas.setData(gardenNewsResult);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public @ResponseBody
    ReturnDatas update(GardenNews gardenNews, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("成功！");
        try {
            if(gardenNews.getId()==null||gardenNews.getUserId()==null){
                return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
            }
           gardenNewsService.updateByPrimaryKeySelective(gardenNews);

        }catch (Exception e){
            e.printStackTrace();
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody
    ReturnDatas add(GardenNews gardenNews, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("成功！");
        if(gardenNews.getUserId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        try {
            gardenNews.setCreateTime(new Date());
            gardenNewsService.insertSelective(gardenNews);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }
    @RequestMapping("/delete")
    public @ResponseBody
    ReturnDatas delete(GardenNews gardenNews, PageBean pageBean, HttpServletRequest request, HttpServletResponse response){
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();
        returnDatas.setMessage("成功！");
        if(gardenNews.getId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        try {
            gardenNewsService.deleteByPrimaryKey(gardenNews.getId());
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnDatas(ReturnDatas.ERROR,"操作失败了");
        }
        return returnDatas;
    }


}
