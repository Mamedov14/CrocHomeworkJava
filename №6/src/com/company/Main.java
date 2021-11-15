package com.company;

public class Main {

    public static void main(String[] args) {

        String source = new String("" +
                "/*\n" +
                " * My first ever program in Java!\n" +
                " */\n" +
                "class Hello { // class body starts here \n" +
                "  \n" +
                "  /* main method */\n" +
                "  public static void main(String[] args/* we put command line arguments here*/) {\n" +
                "    // this line prints my first greeting to the screen\n" +
                "    System.out.println(\"Hi!\"); // :)\n" +
                "  }\n" +
                "} // the end\n" +
                "// to be continued...\n"
        );


        System.out.println(removeJavaComments(source));

    }

    private static String removeJavaComments(String source) {

        String noCommentPattern = ("/\\*(?:[^*]|\\*+[^*/])*\\*+/|//.*");
        source = source.replaceAll(noCommentPattern, "");

        return source;
    }
}
