package com.ll.basic1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class HomeController {
    private int cnt;
    private int n;
    private ArrayList<Person> person;
    HomeController(){
        cnt = -1;
        n = 0;
        person = new ArrayList<>();
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
    public String showAddPerson(@RequestParam String name, @RequestParam int age) {
        person.add(new Person(++n, name, age));
        return n + "번 사람이 추가되었습니다.";
    }

    @GetMapping("/home/people")
    @ResponseBody
    public ArrayList<Person> showPeople() {
        return person;
    }
}

@AllArgsConstructor
@Getter
class Person {
    private int id;
    private String name;
    private int age;
}
