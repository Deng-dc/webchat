package com.afk.response;

import com.afk.enums.ResultEnum;
import lombok.Data;

/**
 * @Author: dengcong
 * @Date: 2022/8/17 - 08 - 17 - 16:21
 * @Description: com.afk.response 定义响应消息
 */
@Data
public class ResponseMessage {
    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 响应消息 success
     * @param resultEnum
     * @return
     */
    public static ResponseMessage success(ResultEnum resultEnum) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(resultEnum.getCode());
        responseMessage.setMsg(resultEnum.getMsg());
        return responseMessage;
    }

    /**
     * 响应消息 success
     * @param code
     * @param msg
     * @return
     */
    public static ResponseMessage success(Integer code, String msg) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(code);
        responseMessage.setMsg(msg);
        return responseMessage;
    }

    /**
     * 响应消息  error
     * @param resultEnum
     * @return
     */
    public static ResponseMessage error(ResultEnum resultEnum) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(resultEnum.getCode());
        responseMessage.setMsg(resultEnum.getMsg());
        return responseMessage;
    }

    /**
     * 响应消息 error
     * @param code
     * @param msg
     * @return
     */
    public static ResponseMessage error(Integer code, String msg) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(code);
        responseMessage.setMsg(msg);
        return responseMessage;
    }
}
