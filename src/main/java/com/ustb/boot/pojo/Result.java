package com.ustb.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName com.xja.boot.pojo
 *
 * @author 你的名字
 * @version JDK 8
 * @className Result (此处以class为例)
 * @date 2024/10/8
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Boolean flag;
    private String message;
    private T data;
}