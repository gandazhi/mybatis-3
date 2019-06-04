package com.gandazhi.test.mapper;

import com.gandazhi.test.pojo.MsgType;

import java.util.List;

/**
 * @Auther: gandazhi
 * @Date: 2019-05-16 15:45
 */
public interface MsgTypeMapper {
  List<MsgType> selectAll(int id);
}
