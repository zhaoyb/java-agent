# java-agent

-com.demo 可以理解为业务项目
-com.agent 是增强实现，主要解决的是如何增强，以及增强什么
-com.attach VirtualMachine.attach方法的调用， 主要传递增强类的jar包以及目标进程ID

最终实现的效果就是在 在业务项目已经运行的情况下，通过attach的方式，增强业务类，实现AOP的效果。核心实现 就是Instrumentation的addTransformer方法和retransformClasses方法，以及ASM的字节码增强
