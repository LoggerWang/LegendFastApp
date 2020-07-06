package com.legend

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    /**
     * let --- kotlin 内联函数
     *
     * 返回最后一行的值
     */
    @Test
    fun testLet(){
        var t= 100

        t = t.let {

            println("====let===$t")
            200

        }
        println(t)
//        打印结果
//        ====run===100
//        200
    }


    /**
     * let --- kotlin 内联函数
     *
     * let 返回最后一行的值
     */
    @Test
    fun testRun(){
        var r= 100
        r = r.run {
            println("====run===$r")
            200

        }
        println(r)
//        打印结果
//        ====run===100
//        200
    }
    /**
     * also --- kotlin 内联函数
     *
     * 返回object本身
     */
    @Test
    fun testAlso(){
        var user =UserBean("美女",18,'m',100)
        var r= 100
        var u = user.also {
            println("====also===${user.toString()}")
            it.age = 19
            it.name = "美女改名了"

        }
        println(u.toString())
//        打印结果
//        ====also===UserBean(name=美女, age=18, set=m, id=100)
//        UserBean(name=美女改名了, age=19, set=m, id=100)
    }


    /**
     * also ---- kotlin 内联函数
     *
     * 返回object本身
     */
    @Test
    fun testApply(){
        var user =UserBean("美女",18,'m',100)
        var r= 100
        var u = user.apply {
            println("====apply===${user.toString()}")
            age = 19
            this.name = "美女改名了"
        }
        println(u.toString())

//        打印结果
//        ====apply===UserBean(name=美女, age=18, set=m, id=100)
//        UserBean(name=美女改名了, age=19, set=m, id=100)
    }


    /**
     * with ----- kotlin 内联函数
     *
     * 返回最后一行
     */
    @Test
    fun testWith(){
        var user =UserBean("美女",18,'m',100)
        var r= 100
        var w= with(user){
            name = "美女改名了"
            age = 19

            age
        }
        println("===with返回最后一行===$w")
        println(user.toString())
//      打印结果
//      ===with返回最后一行===19
//      UserBean(name=美女改名了, age=19, set=m, id=100)
    }
    /**
     * with ----- kotlin 内联函数
     *
     * 返回最后一行
     */
    @Test
    fun testCopy(){
        var score = Score(100, 99)
        var student =Student("美女",18,'m',100,score)
        println(student.toString())

        var copyStudent = student.copy()
        copyStudent.score.maths=59
        copyStudent.score.english=56

        println(student.toString())
        println(copyStudent.toString())


//      打印结果
//      ===with返回最后一行===19
//      UserBean(name=美女改名了, age=19, set=m, id=100)
    }
}
