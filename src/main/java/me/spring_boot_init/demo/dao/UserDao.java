package me.spring_boot_init.demo.dao;

import me.spring_boot_init.demo.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
//repository 는 보통 db랑 연결할 때 respository를 쓰는데 component 어노테이션 bean 어노테이션도 있는데.
@Repository
public class UserDao {
//빈에 등록된 내용들을 내가 쓰겠다. autowired 자동으로 맵핑ㄹ시켜줘
    @Autowired
    private static final String Mapper= "userMapper.";
    private SqlSession sqlSession;

    public List<User> getUser(){
        return sqlSession.selectList(Mapper+"getUser");
      //  return sqlSession.selectList("userMapper."+"getUser");
        //문자열을 더하는 이유는 userdao 안에서 쓸거는 usermapper 뿐. usermapper.은 변동이 없어
        //
    }

}