package com.wzwl.kt.common;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ValidParamsExceptionHandler
 * @Description TODO
 * @Author yangwu
 * @Date 2020/11/12 13:41
 * @Version 1.0
 */
@Component
@ControllerAdvice(annotations=RestController.class)
public class ValidParamsExceptionHandler {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public String validParams(BindException ex){
        BindingResult result =ex.getBindingResult();
        StringBuilder errorMessage = new StringBuilder(result.getFieldErrors().size()*16);
        errorMessage.append("Invalid Request:");
        for(int i=0;i<result.getFieldErrors().size();i++){
            if(i>0){
                errorMessage.append(",");
            }
            FieldError fieldError = result.getFieldErrors().get(i);
            errorMessage.append(fieldError.getDefaultMessage());
        }
        ResultEntity resultEntity  = new ResultEntity(ResultEnum.PARAMS_INVALID_ERROR);
        resultEntity.setMsgInfo(errorMessage.toString());
        return  resultEntity.toString();
    }
}
