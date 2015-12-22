package cn.ifengkou.gaia.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Sloong on 2015/12/1.
 */
@EnableWebMvc
@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleIOException(NullPointerException ex) {
        //String className = ClassUtils.getShortName(ex.getClass());
        return  "there is a null pointer exception";
    }

    /*@ExceptionHandler(AccessForbidException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public String handleAccessForbidException(){
        return "access token is invalidation";
    }*/

    @ExceptionHandler(ResourceIsNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleResourceIsNotExistException(ResourceIsNotExistException ex){
        //return new JsonDto(false,ex.getMessage());
        return ex.getMessage();
    }

    @ExceptionHandler(IllegalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleIllegalException(IllegalException ex){
        //return new JsonDto(false,ex.getMessage());
        return ex.getMessage();
    }
}
