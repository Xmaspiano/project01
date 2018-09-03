package com.xmasworking.project01.controller.system;

import com.xmasworking.project01.entity.UserInfo;
import com.xmasworking.project01.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/8/31 - 下午4:25
 * Created by IntelliJ IDEA.
 */
@Controller
@RequestMapping("/system/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView("system/DataGrid.Templates");

        String titleName = "用户管理";
        String dataUrl = "/system/user/getUserInfoData.json";

        String columns =
                "[[{field: 'id', title: 'ID', width: 60, hidden:true}," +
                        "{field: 'userno', title: '编号'}," +
                        "{field: 'name', title: '名称'}," +
                        "{field: 'tel', title: '电话'}," +
                        "{field: 'department', title: '部门'}]]";

        modelAndView.addObject("titleName", titleName);
        modelAndView.addObject("dataUrl", dataUrl);
        modelAndView.addObject("columns", columns);

        return modelAndView;
    }

    @PostMapping("getUserInfoData.json")
    @ResponseBody
    public List<UserInfo> getUserInfoData(){
        return userInfoService.findAll();
    }
}
