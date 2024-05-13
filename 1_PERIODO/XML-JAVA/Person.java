public class Person {
    private String name; //name is the name plus the surname
    private int age;
    private String sex; // "m" for male --- "f" for female

    /*
     * constructor declaration
     * @param name the name
     * @param age the age
     * @param sex the sex
     */
    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /*
     * this method gets you the name of a person
     */
    public String getName() {
        return name;
    }

    /*
     * this method gets you the name of a person
     */
    public int getAge() {
        return age;
    }

    /*
     * this method gets you the sex of a person
     */
    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + getName() + getAge() + "yo" + "sex: " + getSex();
    }
}
