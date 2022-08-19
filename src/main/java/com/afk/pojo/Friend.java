package com.afk.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: dengcong
 * @Date: 2022/8/17 - 08 - 17 - 14:35
 * @Description: com.afk.pojo 定义实体类 Friend
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_friend")
public class Friend {
    /**
     * id
     */
    private String id;

    /**
     * 我的userId
     */
    private String myUsername;

    /**
     * 好友的userId
     */
    private String myFriendUsername;
}
