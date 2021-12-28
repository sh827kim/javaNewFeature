package com.example.java9;

public interface PrivateMethodInterface {
    void multiply();

    /**
     * Java 9 이전에는 특정 작업을 수행하기 위한 내부 메서드임에도 불구하고 public으로 드러나 원치않는 상속, 오버라이딩이 가능한 문제가 존재하였음.
     */
    default void calculateLoggerBeforeJava9() {
        System.out.println("execute multiflux()");
        multiply();
    }

    /**
     * Java 9 이후에는 private 메서드, private static 메서드를 인터페이스 내에서 지원하여, 원치않는 상속, 오버라이딩에 대해서 방지할 수 있다.
     */
    private void calculateLoggerAfterJava9() {
        System.out.println("execute multiflux()");
        multiply();
    }
}
