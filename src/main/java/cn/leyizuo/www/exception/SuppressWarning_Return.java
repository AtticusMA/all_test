package cn.leyizuo.www.exception;

public class SuppressWarning_Return {
    public static void main(String[] args){
        int result;
        //返回的内容都是最后的finally,catch捕获到异常，之后抛出异常，但是被finally压制
        try{
            result=foo();
            System.out.println(result);
        }catch(Exception e){
            e.getMessage();
        }
        try{
            result = bar();
            System.out.println(result);
        }catch(Exception e){
            e.getMessage();
        }
    }

    @SuppressWarnings("finally")
        public static int foo()
        {
            try{
                int a = 5 / 0;
            } catch (ArithmeticException e){
                throw  new Exception("除数不能是0");
            } finally{
                return 100;
            }
        }

    @SuppressWarnings("finally")
        public static int bar()
        {
            try{
                int a = 5 / 0;
            } catch (ArithmeticException e){
                throw  new Exception("除数不能是0");
            } finally{
                return 100;
            }
        }
    }

