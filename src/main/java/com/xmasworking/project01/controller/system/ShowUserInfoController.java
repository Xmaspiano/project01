package com.xmasworking.project01.controller.system;

import com.xmasworking.project01.entity.ShowUserInfo;
import com.xmasworking.project01.service.ShowUserInfoService;
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
 * @date 2018/9/1 - 下午2:08
 * Created by IntelliJ IDEA.
 */
@Controller
@RequestMapping("/system/showuser")
public class ShowUserInfoController {

    @Autowired
    ShowUserInfoService showUserInfoService;

    @RequestMapping("")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView("/system/DataGrid.Templates");

        String titleName = "候选人管理";
        String dataUrl = "/system/showuser/getShowUserInfoData.json";
        String columns =
                "[[{field: 'id', title: 'ID', width: 60, hidden:true}," +
                        "{field: 'type', title: '类型'}," +
                        "{field: 'department', title: '部门'}," +
                        "{field: 'username', title: '姓名'}," +
                        "{field: 'company', title: '公司'}," +
                        "{field: 'age', title: '年龄'}," +
                        "{field: 'sex', title: '性别'}," +
                        "{field: 'addworktime', title: '参加工作时间'}," +
                        "{field: 'workage', title: '工龄'}," +
                        "{field: 'certificate', title: '证书'}," +
                        "{field: 'job', title: '职称'}," +
                        "{field: 'achievement', title: '事迹'}," +
                        "{field: 'glory', title: '荣誉'}]]";

        modelAndView.addObject("titleName", titleName);
        modelAndView.addObject("dataUrl", dataUrl);
        modelAndView.addObject("columns", columns);

        return modelAndView;
    }

    @PostMapping("getShowUserInfoData.json")
    @ResponseBody
    public List<ShowUserInfo> getShowUserInfoData(){
        return showUserInfoService.findAll();
    }
}
