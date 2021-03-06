package com.example.JavaClassDesign.Listing_03;

class Shape {
    public double area() {
        return 0;
    }
}

class Circle extends Shape {
    private int radius;

    public Circle(int r) {
        radius = r;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    private int side;

    public Square(int a) {
        side = a;
    }

    public double area() {
        return side * side;
    }
}

public class TestShape {
    public static void main(String[] args) {
        Shape shape1 = new Circle(10);
        System.out.println(shape1.area());
        Shape shape2 = new Square(10);
        System.out.println(shape2.area());
    }
}
