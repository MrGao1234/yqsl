package com.zgjt.yqsl.execption;
import com.zgjt.yqsl.response.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseApi error(Exception e){
        e.printStackTrace();
        return ResponseApi.error().message("全局异常。。");
    }

    //特定异常处理
    @ExceptionHandler(MyExecption.class)
    @ResponseBody
    public ResponseApi error(MyExecption e){
        //log.error(ExceptionUtils.getExceptionStackTrace(e));
        e.printStackTrace();
        return ResponseApi.error().message(e.getMsg()).code(e.getCode());
    }

}
