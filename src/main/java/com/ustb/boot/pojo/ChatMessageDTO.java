package com.ustb.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * packageName com.xja.boot.pojo
 *
 * @author 你的名字
 * @version JDK 8
 * @className ChatMessageDTO (此处以class为例)
 * @date 2024/10/14
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDTO {
    private String messageId;
    private String senderId;
    private String senderName;      // 发送者姓名
    private String receiverId;
    private String receiverName;    // 接收者姓名
    private String messageContent;
    private LocalDateTime timestamp;
}