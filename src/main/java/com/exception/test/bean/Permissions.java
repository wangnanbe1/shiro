package com.exception.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther wangnanbei♥liupei
 * @date 2020/11/26 18:02
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permissions {
    private String permission_id;
    private String permission_name;

}
