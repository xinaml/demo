package com.example.demo.act;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserAct {

    @Autowired
    private UserMapper userMapper;


    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(User user) {
        return user.getUsername().equals("admin") && user.getPassword().equals("123456");
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(HttpServletRequest request) {
        List<User> users = userMapper.getAll();
        return JSON.toJSONString(users);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request) {
        User user = new User();
        user.setCity("ree");
        user.setAddress("男女");
        user.setZipCode("xx");
        userMapper.insert(user);
        return "success";
    }

}
