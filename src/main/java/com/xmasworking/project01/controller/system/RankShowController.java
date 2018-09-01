package com.xmasworking.project01.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/9/1 - 下午9:20
 * Created by IntelliJ IDEA.
 */
@Controller
@RequestMapping("/system/rankshow")
public class RankShowController {

    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/system/IframeShow.Templates");
        modelAndView.addObject("srcURL", "/rank");

        return modelAndView;
    }
}
