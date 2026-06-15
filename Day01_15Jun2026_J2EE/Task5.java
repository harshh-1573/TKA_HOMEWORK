class A{
    public B m1(){
        return new B();
    }
}

class B{
    public C m2(){
        return new C();
    }
}

class C{
    public int m3(){
        return 10;
    }
}


class Task5{
    public static void main(String[] args){
        //by using less lines of code
        System.out.println(new A().m1().m2().m3());     
    }
}