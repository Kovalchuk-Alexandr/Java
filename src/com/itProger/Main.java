package com.itProger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
     public static void main(String[] args){
        Study study = new Study("Изучение Java - это просто!");

        String course = study.printCourse();
        System.out.println(study.printCourse());
     }
}

class Study {
   private String course = "Java Programming";
   public Study(String name){
       this.course = name;
   }
    public String printCourse(){return this.course;}


}