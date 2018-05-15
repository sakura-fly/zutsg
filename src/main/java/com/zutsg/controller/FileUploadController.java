package com.zutsg.controller;

import com.zutsg.pojo.User;
import com.zutsg.unti.ReturnDatas;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * Created by Administrator on 2018/5/12 0012.
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    @RequestMapping(value="/upload",method= RequestMethod.POST)
    private @ResponseBody
    ReturnDatas fildUpload( @RequestParam(value="file",required=false) MultipartFile file,
                           HttpServletRequest request)throws Exception{
        //基本表单
        ReturnDatas returnDatas= ReturnDatas.getSuccessReturnDatas();

          try {
              //获得物理路径webapp所在路径
              String pathRoot = request.getSession().getServletContext().getRealPath("");

              String path="";
              if(!file.isEmpty()){
                  //生成uuid作为文件名称
                  String uuid = UUID.randomUUID().toString().replaceAll("-","");
                  //获得文件类型（可以判断如果不是图片，禁止上传）
                  String contentType=file.getContentType();
                  //获得文件后缀名称
                  String imageName=contentType.substring(contentType.indexOf("/")+1);
                  path="/img/"+uuid+"."+imageName;
                  file.transferTo(new File(pathRoot+path));
              }
              System.out.println(path);
              JSONObject jsonObject=new JSONObject();
              jsonObject.put("url",path);
              returnDatas.setData(jsonObject);
          }catch (Exception e){
              e.printStackTrace();
              return new ReturnDatas(ReturnDatas.ERROR,"上传出错！");
          }
        return returnDatas ;
    }
    //因为我的JSP在WEB-INF目录下面，浏览器无法直接访问
    @RequestMapping(value="/forward")
    private String forward(){
        return "index";
    }
}
