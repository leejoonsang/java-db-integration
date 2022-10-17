package com.dbexercise;

import java.util.Map;

// DB_HOST, DB_USER, DB_PASSWORD 등의 정보가 잘 넘어왔는지 확인하는 방법
public class SystemEnv {
    public static void main(String[] args) {
        Map<String, String> env = System.getenv();

        for(String key : env.keySet()){
            System.out.printf("key:%s value:%s\n", key, env.get(key));
        }
    }
}
