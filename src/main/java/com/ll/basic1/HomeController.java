package com.ll.basic1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class HomeController {
    private int cnt;
    private List<Person> people;
    HomeController(){
        cnt = -1;
        people = new ArrayList<>();
    }

    @GetMapping("/home/main")
    @ResponseBody
    public String showMain(){
        return "Hello, World!";
    }

    @GetMapping("/home/main2")
    @ResponseBody
    public String showMain2(){
        return "반갑습니다.";
    }

    @GetMapping("/home/main3")
    @ResponseBody
    public String showMain3(){
        return "즐거웠습니다.";
    }

    @GetMapping("/home/increase")
    @ResponseBody
    public Integer showIncrease(){
        return ++cnt;
    }

    @GetMapping("/home/plus")
    @ResponseBody
    public int showPlus(@RequestParam(defaultValue = "0") int x, @RequestParam int y) {
        return x + y;
    }

    @GetMapping("/home/addPerson")
    @ResponseBody
    public String addPerson(String name, int age) {
        Person p = new Person(name, age);
        people.add(p);
        return p.getId() + "번 사람이 추가되었습니다.";
    }

    @GetMapping("/home/people")
    @ResponseBody
    public List<Person> showPeople() {
        return people;
    }

    @GetMapping("/home/removePerson")
    @ResponseBody
    public String removePerson(int id) {
        for(Person p : people) {
            if(p.getId() == id) {
                people.remove(p);
                return id + "번 사람이 삭제되었습니다.";
            }
        }
        return id + "번 사람이 존재하지 않습니다.";
    }
}

@AllArgsConstructor
@Getter
class Person {
    private static int lastId;
    private int id;
    private String name;
    private int age;

    static {
        lastId = 0;
    }
    Person(String _name, int _age){
        this(++lastId, _name, _age);
    }
}
