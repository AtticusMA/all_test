package cn.leyizuo.www.aop.springaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author： qiusheng
 * @Date： 2019/4/26 14:50
 * @DESCRIPTION：
 * @EMAIL： atticusma@hotmail.com
 */
@Component
@Aspect
public class Aop {

    //这样的切点的表达式真的对哈哈哈哈哈哈哈哈哈哈哈 关键是两个点的时候就是使用orderDao和userImpl，换成.*.*这种方式就是只能使用uerImpl这可特么奇怪了
    //* cn.leyizuo.www.aop.*.*.*.*(..)这个路径对两个方法都可以
    //* cn.leyizuo.www.aop.*.*.*(..) 这个路径对userImplbean可以
    //奇怪
//    符号讲解：
//    ?号代表0或1，可以不写
//    “*”号代表任意类型，0或多
//    方法参数为..表示为可变参数
    @Before("execution(* cn.leyizuo.www.aop.*.*.*.*(..))")
    public void begin(){
        System.out.println("开始事务");
    }

    @After("execution(* cn.leyizuo.www.aop..*.*(..))")
    public void close(){
        System.out.println("事务结束");
    }

    @Pointcut("execution(* cn.leyizuo.www.aop..*.*(..))")
    public void pointCut(){

    }

    //为什么这个先执行的呢
    @Before("pointCut()")
    public void before(){
        System.out.println("Before");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("After");
    }

    @AfterReturning("pointCut()")
    public void afterReturn(){
        System.out.println("afterReturn");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }


    //这个ProceedingJoinPoint难道不加入就不执行了，节点的方法了么
    @Around("pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        proceedingJoinPoint.proceed();
        System.out.println("around");
    }
}
