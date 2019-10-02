package com.github.grishberg.aspectjprofiler

import android.os.SystemClock
import android.util.Log
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut

private const val TAG = "IOC"

@Aspect
class ConstructorsTraceAspect {
    @Pointcut("execution(com.grishberg.*..*.new(..))")
    fun anyAppConstructor() { /* */
    }

    @Around("anyAppConstructor()")
    @Throws(Throwable::class)
    fun logConstructors(joinPoint: ProceedingJoinPoint): Any? {
        val className = joinPoint.signature.declaringType.name
        val start = SystemClock.uptimeMillis()
        val proceed = joinPoint.proceed()
        val duration = SystemClock.uptimeMillis() - start
        Log.i(TAG, "$className , $duration")
        return proceed
    }
}