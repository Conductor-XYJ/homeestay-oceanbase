package com.ustb.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * packageName com.xja.boot.pojo
 *
 * @author 你的名字
 * @version JDK 8
 * @className ChatMessage (此处以class为例)
 * @date 2024/10/11
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_chat_message")  // 指定对应的表名
public class ChatMessage {
    @TableId
    private String messageId;      // 消息编号
    private String senderId;       // 发送者用户编号
    private String receiverId;     // 接收者用户编号
    private String messageContent;  // 消息内容
    private LocalDateTime timestamp; // 消息发送时间
    private Boolean messageRead; //消息是否已读
}