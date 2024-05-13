public class Person implements Comparable{
    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }


    @Override
    public int compareTo(Object o) {
        if (o == null) throw new IllegalArgumentException("parameter is null");

        Person p = (Person) o;//cast
        return this.name.compareTo(p.name) + this.age-p.age;//comparing
    }
}
