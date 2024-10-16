package day02;

public class Method02 {

    public static void main(String[] args) {
        Method02 m = new Method02();
        
        System.out.println(m.sum(100, 200));
        System.out.println(m.sub(100, 200));
        System.out.println(m.mul(100, 20));
        System.out.println(m.div(100, 2));
        System.out.println(m.div(100, 0)); 
        System.out.println(m.mod(6, 2));
        System.out.println(m.mod(6, 0)); 
    }
    
    public int sum(int num1, int num2) {
        return num1 + num2;
    }
    
    public int sub(int num1, int num2) {
        return num1 - num2;
    }
    
    public int mul(int num1, int num2) {
        return num1 * num2;
    }
    
    public double div(int num1, int num2) {
        if(num2 == 0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return 0; 
        }
        return num1 / (double)num2;
    }
    
    public double mod(int num1, int num2) {
        if(num2 == 0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return 0; 
        }
        return num1 % num2;
    }
}
