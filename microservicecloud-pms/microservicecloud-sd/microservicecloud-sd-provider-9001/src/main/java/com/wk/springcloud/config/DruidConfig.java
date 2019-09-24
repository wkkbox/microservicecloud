package com.wk.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Configuration :指明当前类是一个配置类就是来替代之前的spring配置文件
 * 在配置文件中用<bean></bean>来添加组件
 * 在配置类中用@bean来添加组件
 * 将  方法的返回值 （DataSource是一个接口）添加到容器中也就是添加了bean组件，容器中这个组件默认的id就是方法名druidDataSource
 */
@Configuration
public class DruidConfig {

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean(destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //配置Druid的监控
    //1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();
        /*initParams.put("loginUsername", "admin");// 用户名
        initParams.put("loginPassword", "123456");// 密码*/
        initParams.put("loginUsername", username);// 用户名
        initParams.put("loginPassword", password);// 密码
        //initParams.put("allow", "127.0.0.1,192.168.43.67");// IP白名单(没有配置或者为空，则允许所有访问)
        //initParams.put("deny", "192.168.43.67");// 禁止谁访问，IP黑名单 (存在共同时，deny优先于allow)，如果满足deny的页面即提示：Sorry, you are not permitted to view this page.
        bean.setInitParameters(initParams);
        return bean;
    }

    //2、配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
