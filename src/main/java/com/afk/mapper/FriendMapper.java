package com.afk.mapper;

import com.afk.pojo.Friend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: dengcong
 * @Date: 2022/8/17 - 08 - 17 - 14:40
 * @Description: com.afk.mapper
 */
@Repository
@Mapper
public interface FriendMapper extends BaseMapper<Friend> {
}
