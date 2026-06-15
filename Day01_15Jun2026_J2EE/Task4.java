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


class Task4{
    public static void main(String[] args){
        A a1 = new A();
        B b1 = a1.m1();
        C c1 = b1.m2();
        System.out.println(c1.m3());

        
    }
}