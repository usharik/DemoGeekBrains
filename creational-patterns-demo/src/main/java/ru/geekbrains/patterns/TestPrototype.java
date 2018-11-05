package ru.geekbrains.patterns;

public class TestPrototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype("prototype");
        Prototype cloned = prototype.clone();
        System.out.println(cloned);
    }

    public static class Prototype implements Cloneable {
        private String tag;

        public Prototype(String tag) {
            this.tag = tag;
        }

        @Override
        public String toString() {
            return "Prototype{" +
                    "tag='" + tag + '\'' +
                    '}';
        }

        @Override
        public Prototype clone() throws CloneNotSupportedException {
            return (Prototype) super.clone();
        }
    }
}
