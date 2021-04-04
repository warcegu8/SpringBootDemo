package com.spring.demo.mapper;

import com.spring.demo.entity.vo.UserVO;
import org.apache.ibatis.annotations.Param;

/**
 *
 */
public interface GUUserMapper extends TkMapper<UserVO> {

    /**
     *
     * @param cardNo
     * @return
     */
    public UserVO selectByCardNo(@Param("cardNo") int cardNo);

}
