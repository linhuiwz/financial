package com.imooc.manager.error;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class MyErrorController extends BasicErrorController {
    public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorProperties, errorViewResolvers);
    }


    /**
     *     "timestamp": "2018-05-23 14:53:46.370",
     *     "status": 500,
     *     "error": "Internal Server Error",
     *     "exception": "java.lang.IllegalArgumentException",
     *     "message": "编号不可为空",
     *     "path": "/manager/products"
     * @param request
     * @param includeStackTrace
     * @return
     */
    @Override
    protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        Map<String, Object> attrs = super.getErrorAttributes(request, includeStackTrace);
        attrs.remove("timestamp");
        attrs.remove("status");
        attrs.remove("error");
        attrs.remove("exception");
        attrs.remove("path");
        String errorCode = (String) attrs.get("message");
        ErrorEnum errorEnum = ErrorEnum.getByCode(errorCode);
        attrs.put("message", errorEnum.getMessage());
        attrs.put("code", errorEnum.getCode());
        attrs.put("canRetry", errorEnum.isCanRetry());
        return attrs;
    }
}
