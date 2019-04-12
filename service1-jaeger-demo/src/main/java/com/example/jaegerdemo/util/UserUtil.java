package com.example.jaegerdemo.util;

import com.example.jaegerdemo.model.vo.es.UserVO;
import com.example.jaegerdemo.table.es.User; /**
 * @description:
 * @author: zhoufengen
 * @create at: 2019-04-12 14:11
 **/
public class UserUtil {

    public static UserVO modelToVO(User model) {
        if (null == model){
            return null;
        }
        UserVO vo = new UserVO();
        vo.setId(model.getId());
        vo.setName(model.getName());
        vo.setAge(model.getAge());
        vo.setCreateTime(model.getCreateTime());
        return vo;
    }
}
