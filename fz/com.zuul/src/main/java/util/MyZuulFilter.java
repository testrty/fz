package  util;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

//参考网页 https://blog.didispace.com/spring-cloud-starter-dalston-6-3/
public class MyZuulFilter extends ZuulFilter {


   // private static Logger log = LoggerFactory.getLogger(MyZuulFilter.class);

    @Override
    public String filterType() {

        System.out.println("filterType");
        //filterType：过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。这里定义为pre，代表会在请求被路由之前执行。

        return "pre";
    }

    @Override
    public int filterOrder() {
        System.out.println("filterOrder");
        //filterOrder：过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        System.out.println("shouldFilter");
        //判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效。实际运用中我们可以利用该函数来指定过滤器的有效范围。
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        /**
         * run：过滤器的具体逻辑。这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，
         * 然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，当然我们也可以进一步优化我们的返回，
         * 比如，通过ctx.setResponseBody(body)对返回body内容进行编辑等。
         */
        System.out.println("run");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String accessToken = String.valueOf(request.getParameter("Token"));
        if(!accessToken.equals("mytoken") || StringUtils.isEmpty(accessToken)) {
            ctx.setSendZuulResponse( false );
            ctx.setResponseStatusCode( 401 ); // 设置其返回代码
            return null;
        }
        return null;
    }
}