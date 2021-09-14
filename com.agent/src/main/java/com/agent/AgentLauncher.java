package com.agent;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * Hello world!
 */
public class AgentLauncher {

    public static void premain(String featureString, Instrumentation inst) {
        System.out.println("pre main");
    }

    /**
     * 通过attach的方式
     */
    public static void agentmain(String featureString, Instrumentation inst) throws UnmodifiableClassException {
        System.out.println("agent！！！ 增强业务方法");
        // 自定会增强类
        MyClassFileTransformer myClassFileTransformer = new MyClassFileTransformer();
        // 添加到Instrumentation
        inst.addTransformer(myClassFileTransformer, true);

        // 找到需要重新加载的类
        Class<?>[] loadeds = inst.getAllLoadedClasses();
        Class<?> targetClass = null;
        for (Class<?> loaded : loadeds) {
            if (loaded.getName().equals("com.demo.Service")) {
                targetClass = loaded;
            }
        }
        // 重新加载类， 保证动态的增强类生效
        inst.retransformClasses(targetClass);
        System.out.println("增强完毕，请重新执行业务方法");

    }


}
