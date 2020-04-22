package com.legend.mine;

/**
 * @author wanglezhi
 * @date 2020/4/22 16:55
 * @discription
 */
public class InvokeTestClass {
    public String name;
    public Integer age;
    private String id;

    public InvokeTestClass() {
    }

    public InvokeTestClass(String name, Integer age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }
}
