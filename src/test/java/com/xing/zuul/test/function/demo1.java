package com.xing.zuul.test.function;


import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;

public class demo1 {
    public static void main(String... args) {
        Function<Integer, Integer> increase = e -> {
            int i = e + 7;
            return i;
        };  // lambda表达式




        // 用括号
        GreetingService greetService2 = (message) -> {System.out.println("Hello " + message);};


        greetService2.sayMessage("Google");


    }
        //System.out.println(increase.getClass());

    @Test
    public void test1() {
        Function<String, String> f=(x)->x;

        String result = funcPlus1("ee",ofFunction(((token)->token),"21"));
       // String result = funcPlus1("ee",f);
        System.out.println(result);
    }
    interface GreetingService {
        void sayMessage(String message);
    }



    public static <T,R> Function<T,R> ofFunction(TokenFunToken<T,R> funtion,R defaultR){
        Objects.requireNonNull(funtion);
        return (t)->{
            try {

                return funtion.apply(t);
            } catch (Exception e) {
                e.printStackTrace();
                return defaultR;
            }
        };
    }
    @FunctionalInterface
    public interface  TokenFunToken<T,R> {
        R apply(T t) throws Exception;
    }

    @FunctionalInterface
    public interface  TokenFunToken1{
        String apply(String t) throws Exception;
    }
    public static String execute(String t) {
         TokenFunToken1 k=x->x;
        try {
            return k.apply(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    };
    @Test
    public void test2(){
        String result = add1(token -> {
            System.out.println(token);
            return token;
        });
        System.out.println(result);
    }

    public static String add(Function<String,String> post){
      return   funcPlus2("2",ofFunction(token->{
          try {
              String url = post.apply(token);
              return url;
          }catch (Exception e){
              return null;
          }
        },"请求出错"));
    }

    public static String add1(Function<String,String> post){
        return   funcPlus2("2",(token)->post.apply(token));
    }

    public static String funcPlus1(String str,Function<String,String> func) {
        String result = func.apply(str);
        return result;
}


    public static String funcPlus2(String str,Function<String, String> func) {
       return func.apply(getUUId());
    }

    public static String getUUId(){
        return UUID.randomUUID().toString();
    }

    @Test
    public void test8() {
        Predicate<String> predicate = (x)->x.length()>5;
        System.out.println(predicate.test("12345678"));
        System.out.println(predicate.test("123"));
    }

    @Test
    public void test7() {
        Function<String, String> function = (x)->x.substring(0, 2);
        System.out.println(function.apply("我是中国人"));
    }



}
