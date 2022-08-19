package com.afk.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: dengcong
 * @Date: 2022/8/17 - 08 - 17 - 15:13
 * @Description: com.afk.bo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBO {
    private String username;

    private String faceImg;

    private String nickname;
}
