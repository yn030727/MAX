package com.example.max

import java.lang.RuntimeException

fun main(){
    //不同嵌套Kotlin中的max函数
    val largest=max(1,2,3,4,5,6,7,8)
    val largest2=max2(1.2,3.5,5.2,5.6)
    println(largest)
    println(largest2)
}
//通过vararg可以接收多个同等类型的参数
fun max(vararg nums:Int):Int{
    var maxNum=Int.MIN_VALUE
    for(num in nums){
        maxNum = kotlin.math.max(maxNum,num)
    }
    return maxNum
}
//如果想求N个浮点型或长整型的数字的最大值怎么办
fun <T:Comparable<T>> max2(vararg nums:T):T{
    //将泛型T的上界指定成了Comparable<T>,那么参数T必然是Comparable<T>的子类型
    if(nums.isEmpty())throw RuntimeException("Params can not be empty")
    var maxNum = nums[0]
    for(num in nums){
        if(num > maxNum){
            maxNum = num
        }
    }
    return maxNum
}
