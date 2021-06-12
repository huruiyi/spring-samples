package cn.itheima.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor {

	// 返回布尔值:如果返回true放行,返回false则被拦截住
	// 执行时机:controller方法没有被执行,ModelAndView没有被返回
	// 使用场景: 权限验证
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("======Interceptor1=======preHandle========");
		return true;
	}

	// 执行时机:Controller方法已经执行,ModelAndView没有返回
	// 使用场景: 可以在此方法中设置全局的数据处理业务
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("======Interceptor1=======postHandle========");

	}

	// 执行时机:controller已经执行,modelAndview已经返回
	// 使用场景: 记录操作日志,记录登录用户的ip,时间等.
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("======Interceptor1=======afterCompletion========");
	}
	
	/**
	 * 
	 * preHandle：预处理回调方法，实现处理器的预处理（如登录检查），第三个参数为响应的处理器返回值：
	 * true表示继续流程（如调用下一个拦截器或处理器）；
	 * false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
	 * 
	 * postHandle：后处理回调方法，实现处理器的后处理（但在渲染视图之前），
	 * 此时我们可以通过modelAndView（模型和视图对象）对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
	 * 
	 * afterCompletion：整个请求处理完毕回调方法，即在视图渲染完毕时回调，
	 * 如性能监控中我们可以在此记录结束时间并输出消耗时间，还可以进行一些资源清理，
	 * 类似于try-catch-finally中的finally，但仅调用处理器执行链中preHandle返回true的拦截器才会执行afterCompletion。
	 */

}
