package com.attach;

import com.sun.tools.attach.VirtualMachine;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception {

        String targetJvmPid = "912";
        if (args != null) {
            if (args.length > 0) {
                targetJvmPid = args[0];
            }
        }

        if (targetJvmPid != null) {
            VirtualMachine vmObj = null;
            try {
                vmObj = VirtualMachine.attach(targetJvmPid);
                if (vmObj != null) {
                    // 加载agent的jar包， 需要现在agent项目中执行 maven package命令生成
                    vmObj.loadAgent("D:\\jar\\agent-1.0-jar-with-dependencies.jar");
                }

            } finally {
                if (null != vmObj) {
                    vmObj.detach();
                }
            }
        }
    }
}
