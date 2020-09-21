package com.legend

/**
 * @author wanglezhi
 * @date   2020/7/1 17:26
 * @discription
 */
data class UserBean(var name:String,
                    var age:Int,
                    var set:Char,
                    var id:Int
)

data class Student(var name:String,
                    var age:Int,
                    var set:Char,
                    var id:Int,
                    var score:Score
)
data class Score(var maths:Int,var english:Int)
