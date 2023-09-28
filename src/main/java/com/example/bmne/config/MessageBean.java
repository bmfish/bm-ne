package com.example.bmne.config;

import com.alibaba.fastjson2.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.nio.charset.StandardCharsets;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageBean {
    /**
     * 数据长度
     */
    private Integer len;
    /**
     * 通讯数据
     */
    private byte[] content;
 
    public MessageBean(Object object) {
        content = JSON.toJSONBytes(object);
        len = content.length;
    }
}
 
