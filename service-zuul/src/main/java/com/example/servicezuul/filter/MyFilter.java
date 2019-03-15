package com.example.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

/**
 * zuul is not only have dynamic routes power, but also it have filter function
 * we can do it in security and data validation\
 * write business logic in @{run()}
 */
@Component
@Slf4j
public class MyFilter extends ZuulFilter {
    /**
     * return a type about filter, zuul define 4 types to display filter life cycle
     * pre : before route
     * routing : route  now
     * post : after route
     * error : send error message to call
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * the filter order
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * whether need to filter
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * if you want to do something when the filter is affective, do some business logic  in @{run()}
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // get request body and response body
        log.info("call run(), the filter is affective");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info("request url: " + request.getRequestURL().toString());
        Object token = request.getParameter("token");
        if (Objects.isNull(token)) {
            log.warn("token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("sorry, you dont have give me token, so i cant release fot you");
            } catch (IOException e) {
               log.error(e.getMessage(), e);
            }
        }
        log.info("the function run() have been executed");
        return null;
    }
}
