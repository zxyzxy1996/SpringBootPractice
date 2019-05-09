package com.imooc.exception;

import com.imooc.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author RockerBaozi
 * @date 2019/5/7 16:01
 */
@ControllerAdvice
public class IMoocExceptionHandler {

    public static final String IMOOC_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandle(HttpServletRequest request,
                              HttpServletResponse response, Exception e) throws Exception {

        e.printStackTrace();

        if (isAjax(request)) {
            return IMoocJSONResult.errorException(e.getMessage());
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("exception", e);
            modelAndView.addObject("url", request.getRequestURL());
            modelAndView.setViewName(IMOOC_ERROR_VIEW);
            return modelAndView;
        }
    }

    /**
     * @Description is Ajax?
     * @param httpRequest
     * @return
     */
    public static boolean isAjax(HttpServletRequest httpRequest) {

        String header = httpRequest.getHeader("X-Requested-With");
        boolean isAjax = "XMLHttpRequest".equals(header) ? true:false;
        return isAjax;
    }

//    public Object errorHandle(HttpServletRequest request,
//            HttpServletResponse response, Exception e) throws Exception {
//
//        e.printStackTrace();
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception", e);
//        modelAndView.addObject("url", request.getRequestURL());
//        modelAndView.setViewName(IMOOC_ERROR_VIEW);
//
//        return modelAndView;
//    }
}
