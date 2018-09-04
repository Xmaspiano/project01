package com.xmasworking.project01.controller;

import com.xmasworking.project01.entity.UserInfo;
import com.xmasworking.project01.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/8/30 - 上午10:23
 * Created by IntelliJ IDEA.
 */
@Controller
@RequestMapping("/main")
public class MainController {
    private UserInfo userInfo;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("")
    public String index(){
        return "main";
    }

    @RequestMapping("/checkcode")
    public ModelAndView checkcode(@RequestParam("invite_code") String inviteCode, HttpSession httpSession){
        if(isRealCode(inviteCode)){
            UUID token = UUID.randomUUID();
            System.out.println(token);
            httpSession.setAttribute("token", token);
            httpSession.setAttribute("userInfo", userInfo);
            ModelAndView modelAndView = new ModelAndView("redirect:/select");
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("main");
            modelAndView.addObject("msg", "您不是被邀请用户！！！");
            return modelAndView;
        }
    }

    private boolean isRealCode(String submit_code){
        userInfo = userInfoService.findUserInfoByTel(submit_code);
        if(userInfo != null) {
            String code = userInfo.getTel();
            return code.equals(submit_code);
        }
        return Boolean.FALSE;
    }

}
