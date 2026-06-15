class Teacher{

}

class Student{
    public void show(){
        System.out.println("From the student object");
    }
}

class Demo{
    public Student s1(Teacher t1){
        return new Student();
    }
}

class Task3{
    public static void main(String[] args){
        Demo obj = new Demo();
        Teacher obj1 = new Teacher();
        Student s2 = obj.s1(obj1);
        s2.show();
    }
}