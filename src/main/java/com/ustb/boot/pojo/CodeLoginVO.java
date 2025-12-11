package com.ustb.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName com.xja.boot.pojo
 *
 * @author 你的名字
 * @version JDK 8
 * @className CodeLoginVO (此处以class为例)
 * @date 2024/10/8
 * @description TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeLoginVO {
    private String phone;
    private String code;
    private String newPassword;
}
