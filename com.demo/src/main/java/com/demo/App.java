package com.demo;

import java.lang.management.ManagementFactory;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        // 获取pid  供agent使用
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.split("@")[0];
        System.out.println("应用程序进程Id:" + pid);

        // 注意这里加载过一次， 之后没有再加载
        Service service = new Service();

        // 模拟操作， 键盘上输入任意值，执行操作
        Scanner scanner = new Scanner(System.in);
        System.out.println("按 F 执行程序");

        while (true) {
            String cmd = scanner.nextLine();
            if ("f".equalsIgnoreCase(cmd)) {
                service.dosome();
            }
        }

    }
}
