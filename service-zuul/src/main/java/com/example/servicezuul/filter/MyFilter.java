package com.example.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName MyFilter
 * @Author pyt
 * @Date 2019/1/2 14:04
 */
@Component
public class MyFilter extends ZuulFilter {
    private static Logger logger = LogManager.getLogger(MyFilter.class);
    @Override
    public String filterType() {
       /*
        filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
        pre：路由之前
        routing：路由之时
        post： 路由之后
        error：发送错误调用
        */
        return "pre";
    }

    @Override
    public int filterOrder() {
        /*
        filterOrder：过滤的顺序
        如果有多个过滤器，则数字越小越先执行
        */
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        /*这里可以写逻辑判断，是否要过滤，true,永远过滤。*/
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        /*
        过滤器的具体逻辑。
        可用很复杂，包括查sql，nosql
        去判断该请求到底有没有权限访问。*/
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            logger.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        logger.info("ok");

        return null;
    }
}
