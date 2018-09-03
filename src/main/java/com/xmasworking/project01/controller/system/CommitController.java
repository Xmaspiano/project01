package com.xmasworking.project01.controller.system;

import com.xmasworking.project01.entity.Commit;
import com.xmasworking.project01.entity.ShowUserInfo;
import com.xmasworking.project01.entity.UserInfo;
import com.xmasworking.project01.service.CommitService;
import com.xmasworking.project01.service.ShowUserInfoService;
import com.xmasworking.project01.service.UserInfoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/9/1 - 下午8:47
 * Created by IntelliJ IDEA.
 */
@Controller
@RequestMapping("/system/commit")
public class CommitController {

    @Autowired
    CommitService commitService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    ShowUserInfoService showUserInfoService;

    @RequestMapping("")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView("system/DataGrid.Templates");

        String titleName = "投票管理";
        String dataUrl = "/system/commit/getCommitData.json";

        String columns =
                "[[{field: 'id', title: 'ID', width: 60, hidden:true}," +
                        "{field: 'userno', title: '编号'}," +
                        "{field: 'name', title: '名称'}," +
                        "{field: 'tel', title: '电话'}," +
                        "{field: 'username', title: '投选人'}," +
                        "{field: 'type', title: '类别'}," +
                        "{field: 'department', title: '部门'}]]";

        modelAndView.addObject("titleName", titleName);
        modelAndView.addObject("dataUrl", dataUrl);
        modelAndView.addObject("columns", columns);

        return modelAndView;
    }

    @PostMapping("getCommitData.json")
    @ResponseBody
    public List<PageVo> getCommitData(){
        List<PageVo> pageVos = new ArrayList<>();
        for(Commit commit:commitService.findAll()){
            pageVos.add(new PageVo(commit,userInfoService,showUserInfoService));
        }

        return pageVos;
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    @NoArgsConstructor
    class PageVo{
        Long id;
        Long userno;
        String name;
        String tel;
        String username;
        String type;
        String department;

        PageVo(Commit commit, UserInfoService userInfoService,ShowUserInfoService showUserInfoService){
            UserInfo userInfo = userInfoService.findById(commit.getUserid());
            ShowUserInfo showUserInfo = showUserInfoService.findById(commit.getShowid());

            this.id = commit.getId();
            this.userno = userInfo.getUserno();
            this.name = userInfo.getName();
            this.tel = userInfo.getTel();
            this.department = userInfo.getDepartment();
            this.username = showUserInfo.getUsername();
            this.type = showUserInfo.getType();

        }
    }
}
