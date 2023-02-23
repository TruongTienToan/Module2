package OOP;

public class Student {
    public int id;
    public String name;
    public int age;
    public String address;

    public Student() {

    }

    public Student(int id , String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student(int id , String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getInfo() {
        return "id: " + this.id + " name: " + this.name + " age: " + this. age + " address: " + this.address;
    }

    public static void main(String[] args) {
        Student student0;
        student0 = new Student();
        System.out.println(student0.getInfo());

        Student student1 = new Student();
        System.out.println(student1.getInfo());
        Student student2 = new Student(1, "Toan", 20, "28 NTP");
        System.out.println(student2.getInfo());
        Student student3 = new Student(1, "Nhat", 30);
        System.out.println(student3.getInfo());
    }
}
