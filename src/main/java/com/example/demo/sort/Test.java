package com.example.demo.sort;

import com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("UserB"));
        list.add(new User("UserA"));
        list.add(new User("UserC"));
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getUsername().compareTo(o2.getUsername());
            }
        });
        Collections.sort(list, (User a, User b) -> b.getUsername().compareTo(a.getUsername()));
        Comparator<User> comparator =  (User a, User b) -> b.getUsername().compareTo(a.getUsername());
        System.out.println(list);
    }
}
