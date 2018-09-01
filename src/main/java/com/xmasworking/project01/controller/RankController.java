package com.xmasworking.project01.controller;

import com.xmasworking.project01.entity.ShowUserInfo;
import com.xmasworking.project01.service.CommitService;
import com.xmasworking.project01.service.ShowUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/8/30 - 上午10:23
 * Created by IntelliJ IDEA.
 */
@Controller
@RequestMapping("/rank")
public class RankController {

    @Autowired
    ShowUserInfoService showUserInfoService;

    @Autowired
    CommitService commitService;

    @RequestMapping("")
    public ModelAndView index(){
        Map<Long, Integer> showCount = new HashMap<>();
        List<ShowUserInfo> showUserInfos = showUserInfoService.findAll();

        int count = 0;
        for(ShowUserInfo userinfo:showUserInfos){
            count = commitService.countByShowid(userinfo.getId());
            showCount.put(userinfo.getId(),count);
        }

        ModelAndView modelAndView = new ModelAndView("/rank");
        modelAndView.addObject("showUserInfos", showUserInfos);
        modelAndView.addObject("showCount", showCount);
        modelAndView.addObject("allCount", commitService.countAll());
        return modelAndView;
    }

    @RequestMapping(value = "/forword")
    @ResponseBody
    public Map forword() {
        Map map = new HashMap(16);
        map.put("forword", "/rank");
        map.put("status", true);
        map.put("error", "登录成功");
        return map;
    }
}
