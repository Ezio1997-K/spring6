package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class TestSanji {
    @Component
    public class A {
        @Autowired
        private B b;

        @Transactional // 需要代理
        public void test() {}
    }

    @Component
    public class B {
        @Autowired
        private A a;
    }
}
