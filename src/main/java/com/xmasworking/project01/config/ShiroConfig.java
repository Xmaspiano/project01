package com.xmasworking.project01.config;

import com.xmasworking.project01.filter.LoginFilter;
import com.xmasworking.project01.filter.TokenOverFilter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/8/31 - 下午5:07
 * Created by IntelliJ IDEA.
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        //配置登录的url和登录成功的url
        bean.setLoginUrl("/system/login");
        bean.setSuccessUrl("/system/loginSuccess");
//        bean.setUnauthorizedUrl("/system/index");

        //自定义拦截器
        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();

        LoginFilter authcFilter = new LoginFilter();

        filtersMap.put("ajaxLogin", new TokenOverFilter());
        filtersMap.put("authc", authcFilter);
        bean.setFilters(filtersMap);

        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<String, String>();
        //拦截器.

        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout*","logout");

        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/main**", "anon");
        filterChainDefinitionMap.put("/show**", "anon");
        filterChainDefinitionMap.put("/select**", "anon");
        filterChainDefinitionMap.put("/show**", "anon");
        filterChainDefinitionMap.put("/src/**", "anon");

        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
//        filterChainDefinitionMap.put("/**", "ajaxLogin, authc");

        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }


    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }
}