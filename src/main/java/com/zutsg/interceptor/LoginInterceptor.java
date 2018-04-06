package com.zutsg.interceptor;

import com.zutsg.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOJO on 2017/7/27.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    //在控制器处理请求之前被调用
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
/*        User user =  (User)request.getSession().getAttribute("userinfo");
        if(user == null){
            //当管理员用户没有登录时，除了处理登录请求之外，其余都应该拦截
            String uri = request.getRequestURI();
            System.out.println(uri+"------------------------");
            if("/selectall.spring".equals(uri)||"/selectbyid.spring".equals(uri)||"/selectdim.spring".equals(uri)
                    ||"/addcar.spring".equals(uri)||"/removecar.spring".equals(uri)||"/removeallcar.spring".equals(uri)||"/updatecar.spring".equals(uri)
                    ||"/login.spring".equals(uri)||"/register.spring".equals(uri)||"/check.spring".equals(uri)||"/fogetpassword.spring".equals(uri)
                    ||"/checkfoget.spring".equals(uri)||"/zutsg/test.spring".equals(uri)
                    ){
                return true;
            }else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return false;
            }

        }*/
        return true;
    }

    @Override
    //在控制器处理请求之后被调用
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    //在控制器处理请求之后被调用,可用于销毁资源等
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
