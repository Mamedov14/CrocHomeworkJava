package com.company;

public class Main {

    public static void main(String[] args) {

        Annotation[] annotations = new Annotation[]{
                new Annotation(new Circle(100, 100, 10), "Tree"),
                new Annotation(new Rectangle(150, 200, 100, 100), "Car")
        };

        AnnotatedImage image = new AnnotatedImage("C::Users/...", annotations);

        for (Annotation annotation : image.getAnnotations()) {
            System.out.println(annotation);
        }

        System.out.println(image.findByPoint(101, 101));
        System.out.println(image.findByPoint(100, 200));
        System.out.println(image.findByLabel(("Car")));
        System.out.println(image.findByLabel(("Tree")));
    }
}
