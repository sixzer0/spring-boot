package me.spring_boot_init.demo.conzip;

import me.spring_boot_init.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.spring_boot_init.demo.domain.User;

import java.util.List;
//controller는 jsp나 html 파일 자체를 매핑시켜주고
//rest api를 데이터 자체를 매핑시켜준다.
@RestController
public class UserController {

    //디비에 있는 것을 긁어오기 위해 쓴느것
    @Autowired
    UserDao userDao;

    @GetMapping("/a")
    public List<User> a(){
        return userDao.getUser();
        //브라우저로 리턴
    }
}