package com.example.test.chapter03;

public class Dog {
    String name;

    public static void main(String[] args) {
        // Dog 객체를 만들고 접근
        Dog dog = new Dog();
        dog.bark();
        // 문자열은 특별한 타입의 객체
        // 실제로는 레퍼런스지만 마치 원시 타입과 마찬가지로 생성하고 대입할 수 있음
        dog.name = "Bart";

        // Dog 배열 생성
        Dog[] myDogs = new Dog[3];
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog;

        // 배열 레퍼런스를 써서 Dog 객체에 접근
        myDogs[0].name = "Fred";
        myDogs[1].name = "Marge";

        System.out.print("마지막 개의 이름: ");
        System.out.println(myDogs[2].name);

        int x = 0;
        while (x < myDogs.length) {
            myDogs[x].bark();
            x += 1;
        }
    }

    public void bark() {
        System.out.println(name + "이(가) 왈! 하고 짖습니다.");
    }

    public void eat() {
        System.out.println(name + "이(가) 밥을 먹습니다.");
    }

    public void chaseCat() {
        System.out.println(name + "이(가) 고양이를 쫓습니다.");
    }
}
