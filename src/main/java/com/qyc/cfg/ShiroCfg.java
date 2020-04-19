package com.qyc.cfg;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qyc
 * @time 2020/4/19 - 16:00
 */
@Configuration
public class ShiroCfg {

//    创建安全管理器
    @Bean
    public SecurityManager getSecurityManager(Realm realm,CacheManager cacheManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //注入realm
        securityManager.setRealm(realm);
        securityManager.setCacheManager(cacheManager);
        return securityManager;
    }

//    设置filter
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //配置资源受限表
        Map<String,String> map = new HashMap<String,String>();

        map.put("/**","anon");  //游客
        map.put("/home","anon");  //需要认证
        map.put("/user/**","authc");


//        自定义认证页面位置
        shiroFilterFactoryBean.setLoginUrl("/userlogin");
//      添加
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //创建自定义realm 领域
    @Bean
    public Realm getRealm(CredentialsMatcher credentialsMatcher){
        CustomerReals customerReals = new CustomerReals();
        //注入凭证匹配器
        customerReals.setCredentialsMatcher(credentialsMatcher);
        return customerReals;
    }

    //创建凭证匹配器 MD5
    @Bean
    public CredentialsMatcher getCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(10);
        return credentialsMatcher;
    }

    //配置缓存
    @Bean
    public CacheManager getcacheManager(){
        return new EhCacheManager();
    }

    //配置shiro标签
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
