package com.xmasworking.project01.controller;

import com.xmasworking.project01.entity.ShowUserInfo;
import com.xmasworking.project01.service.CommitService;
import com.xmasworking.project01.service.ShowUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

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


        ModelAndView modelAndView = new ModelAndView("rank");
        modelAndView.addObject("stringListMap", stringListMap);
        modelAndView.addObject("listKeySet", listKeySet);
        modelAndView.addObject("showCount", showCount);
        modelAndView.addObject("allCount", commitService.countAll()/10);
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
