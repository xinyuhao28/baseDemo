package com.javabase.base.myexception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class UniformReponseHandler<T> {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        log.info("binder.getFieldDefaultPrefix {}",binder.getFieldDefaultPrefix());
        log.info("binder.getFieldMarkerPrefix {}",binder.getFieldMarkerPrefix());
    }
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "harry");
    }

    @ResponseStatus(HttpStatus.OK)
    public CallResultMsg sendSuccessResponse() {
        return new CallResultMsg(true, CodeAndMsg.SUCCESS.getCode(), CodeAndMsg.SUCCESS.getMsg(), null);
    }

    @ResponseStatus(HttpStatus.OK)
    public CallResultMsg sendSuccessResponse(T data) {
        return new CallResultMsg(true, CodeAndMsg.SUCCESS.getCode(), CodeAndMsg.SUCCESS.getMsg(), data);
    }
    @ExceptionHandler(MyTestException.class)
    public void  sendErrorResponse_MyTestException(Exception exception) {
        System.out.println("MyTestException"+((MyTestException)exception).getException());
    }
    @ExceptionHandler(UserDefinedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CallResultMsg sendErrorResponse_UserDefined(Exception exception) {
        return new CallResultMsg(false,
                ((UserDefinedException) exception).getException().getCode(),
                ((UserDefinedException) exception).getException().getMsg(),
                null);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CallResultMsg paramErrorResponse_System(Exception exception) {
        /*//这个判断应该是没有定义过的都按照未知处理
        if (exception instanceof UserDefinedException) {
            return this.sendErrorResponse_UserDefined(exception);
        }*/

        return new CallResultMsg(false, CodeAndMsg.ERRPARAME.getCode(), exception.getMessage(), null);
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CallResultMsg sendErrorResponse_System(Exception exception) {if (exception instanceof UserDefinedException) {
            return this.sendErrorResponse_UserDefined(exception);
        }

        return new CallResultMsg(false, CodeAndMsg.UNKNOWEXCEPTION.getCode(), CodeAndMsg.UNKNOWEXCEPTION.getMsg(), null);
    }
}