package vn.nguyen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.nguyen.exception.UserException;
import vn.nguyen.response.BaseResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by quocnguyen on 29/12/2015.
 */
@ControllerAdvice
public class ErrorrHandlingController {
    @ExceptionHandler(UserException.class)
    @ResponseBody
    public BaseResponse<?> handlerRequestException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                                      Object handler, UserException ex){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("1");
        baseResponse.setMessageCode(ex.getErrorCode());
        baseResponse.setMessageInfo(ex.getErrorrMessage());
        return baseResponse;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse handlerRequestException500(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                                        Object handler, Exception ex){
        return new BaseResponse(ex);
    }
}
