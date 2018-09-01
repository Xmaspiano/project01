package com.xmasworking.project01.controller;

import com.xmasworking.project01.entity.Commit;
import com.xmasworking.project01.entity.ShowUserInfo;
import com.xmasworking.project01.entity.UserInfo;
import com.xmasworking.project01.service.CommitService;
import com.xmasworking.project01.service.ShowUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/8/30 - 上午10:23
 * Created by IntelliJ IDEA.
 */
@Controller
@RequestMapping("/select")
public class SelectController {
    @Autowired
    ShowUserInfoService showUserInfoService;
    @Autowired
    CommitService commitService;

    @RequestMapping("")
    public ModelAndView index(HttpSession httpSession){
        UUID token = (UUID) httpSession.getAttribute("token");
        UserInfo sessionUserInfo = (UserInfo) httpSession.getAttribute("userInfo");

        if(sessionUserInfo ==null || token == null){
            ModelAndView modelAndView = new ModelAndView("redirect:/main");
            return modelAndView;
        }

        int count = commitService.countByUserid(sessionUserInfo.getId());

        if(count>0){
            ModelAndView modelAndView = new ModelAndView("redirect:/rank");
            return modelAndView;
        }

        List<ShowUserInfo> showUserInfos = showUserInfoService.findAll();

        List<ShowUserInfo> type1 = new ArrayList<>();
        List<ShowUserInfo> type2 = new ArrayList<>();
        List<ShowUserInfo> type3 = new ArrayList<>();
        List<ShowUserInfo> type4 = new ArrayList<>();
        List<ShowUserInfo> type5 = new ArrayList<>();
        List<ShowUserInfo> type6 = new ArrayList<>();
        List<ShowUserInfo> type7 = new ArrayList<>();

        String type = "";

        for(ShowUserInfo userInfo:showUserInfos) {
            type = userInfo.getType();
            if ("公司领导班子".equals(type)) {
                type1.add(userInfo);
            } else if ("项目经理部".equals(type)) {
                type2.add(userInfo);
            } else if ("工程技术类".equals(type)) {
                type3.add(userInfo);
            } else if ("桥梁核心类".equals(type)) {
                type4.add(userInfo);
            } else if ("经营类".equals(type)) {
                type5.add(userInfo);
            } else if ("工、料、机、财、安类".equals(type)) {
                type6.add(userInfo);
            } else if ("党群、纪检、人事类".equals(type)) {
                type7.add(userInfo);
            }
        }

        Map<String, List<ShowUserInfo>> stringListMap = new LinkedHashMap();
        stringListMap.put("公司领导班子",type1);
        stringListMap.put("项目经理部",type2);
        stringListMap.put("工程技术类",type3);
        stringListMap.put("桥梁核心类",type4);
        stringListMap.put("经营类",type5);
        stringListMap.put("工、料、机、财、安类",type6);
        stringListMap.put("党群、纪检、人事类",type7);

        Iterator it = stringListMap.keySet().iterator();
        List listKeySet = new ArrayList();
        while(it.hasNext()){
            listKeySet.add(it.next());
        }

        ModelAndView modelAndView = new ModelAndView("/select");
        modelAndView.addObject("stringListMap", stringListMap);
        modelAndView.addObject("listKeySet", listKeySet);
        return modelAndView;
    }

    @RequestMapping("commit")
    public String commit(@RequestParam(value = "ids[]") Long[] ids,HttpSession httpSession,
                         HttpServletRequest request, HttpServletResponse response){
        UUID token = (UUID) httpSession.getAttribute("token");
        UserInfo sessionUserInfo = (UserInfo) httpSession.getAttribute("userInfo");

        List<Commit> commitList = new ArrayList<>();
        Commit commit;
        for(Long x:ids){
            commit = new Commit();
            commit.setShowid(x);
            commit.setUserid(sessionUserInfo.getId());
            commitList.add(commit);
        }
        commitService.save(commitList);
        return "redirect:/rank/forword";
    }

}
