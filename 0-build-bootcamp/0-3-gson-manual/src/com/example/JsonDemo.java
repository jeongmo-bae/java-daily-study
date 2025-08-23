package com.example;
import com.google.gson.Gson;

public class JsonDemo {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = "{\"name\":\"ChatGPT\",\"age\":3}";
        Person p = gson.fromJson(json, Person.class);
        System.out.println(p.name + " is " + p.age + " years old");
    }

    static class Person {
        String name;
        int age;
    }
}
