package com.xmasworking.project01.controller;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/8/30 - 上午10:23
 * Created by IntelliJ IDEA.
 */

import com.xmasworking.project01.entity.ShowUserInfo;
import com.xmasworking.project01.service.ShowUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowUserInfoService showUserInfoService;

    @RequestMapping("")
    public ModelAndView index(){
        List<ShowUserInfo> showUserInfos = showUserInfoService.findAll();
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("showUserInfos", showUserInfos);
        return modelAndView;
    }

    @RequestMapping("/user")
    public ModelAndView getShowUser(@RequestParam("id")Long id){
        ShowUserInfo showUserInfo = showUserInfoService.findById(id);
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("showUserInfo",showUserInfo);
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping("/showuser")
    public List<ShowUserInfo> getAllUser(){
        return showUserInfoService.findAll();
    }
}
