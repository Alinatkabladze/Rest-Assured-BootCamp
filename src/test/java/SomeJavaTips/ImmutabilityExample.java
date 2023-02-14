package SomeJavaTips;

public class ImmutabilityExample {
    public static void main(String[] args) {
        String str1 = "Value1";
        String str2=str1;
        str2="Value2";
        System.out.println(str1);
        System.out.println(str2);
        //you don't need new keyword to have two different values, because Strings
        //are immutable. The original value will not be modified
    }
}
