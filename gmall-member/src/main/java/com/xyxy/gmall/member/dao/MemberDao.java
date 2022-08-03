package com.xyxy.gmall.member.dao;

import com.xyxy.gmall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author jackyzou
 * @email jackyzou2510@gmail.com
 * @date 2022-08-03 11:38:32
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
