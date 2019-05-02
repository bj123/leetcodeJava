package com.example.effectivejava.builder;

/**
 * 利用builder模式设计的Java类
 *
 * @author qinxuewu
 * @version 1.00
 * @time  25/4/2019 下午 3:03
 * @email 870439570@qq.com
 */
public class Student {

    private String id;
    private String name;
    private String sex;
    private int age;

    public static class Builder {
        /**
         * 只能指定一次
         */
        private final String id;
        private String name = "";
        private String sex = "男";
        private int age = 20;


        /**
         * 非空属性，必须在构造器中指定。
         * @param id
         */
        public Builder(String id) {
            this.id = id;
        }

        /**
         * name,sex,age可选择属性，提供特殊的setter方法
         * @param name
         * @return
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }


        /**
         * Student对象创建器，想得到一个Student对象必须使用build 方法，
         * 在方法中增加对Builder参数的验证，并以异常的形式告诉给开发人员。
         * @return
         */
        public Student build() {
            /* 检查Builder对象中的数据是否合法。
             * 针对这个例子，就是检查主键冲突，外键制约等
             * 如果不满足我们可以抛出一个IllegalArgumentException
             */
            return new Student(this);

        }
    }

    private Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.sex = builder.sex;
        this.age = builder.age;

    }


    /**
     * 只提供getter方法
     * @return
     */
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }


    public static void main(String[] args) {
        Student.Builder builder = new Student.Builder("03041013");
        builder.name("李华");
        Student student = builder.build();


        student = new Student.Builder("03041013").name("李华").build();
    }

}
