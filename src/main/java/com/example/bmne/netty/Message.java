package com.example.bmne.netty;

import com.alibaba.fastjson2.JSONObject;
import lombok.Data;

@Data
public class Message {
    /**
     * 数据长度
     */
    private Integer len;
 
    /**
     * 接收的通讯数据body
     */
    private String content;
 
    /**
     * 消息类型
     */
    private Integer msgType;
 
    public Message(Object object) {
        String str = object.toString();
        JSONObject jsonObject = JSONObject.parseObject(str);
        msgType = Integer.valueOf(jsonObject.getString("msg_type"));
        content = jsonObject.getString("body");
        len = str.length();
    }
 
    public String toJsonString() {
        return "{" +
                "\"msg_type\": " + msgType + ",\n" +
                "\"body\": " + content +
                "}";
    }
	// setter、getter 。。。。
}
