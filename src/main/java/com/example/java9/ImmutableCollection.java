package com.example.java9;

import java.util.*;

public class ImmutableCollection {

    /***
     * Java 9 이전에는 Immutable Collection으로 선언하기 위해서는 Collections API 를 활용해야 했다.
     */
    void beforeJava9() {
        List<String> list = Arrays.asList("kim", "lee", "park");
        list = Collections.unmodifiableList(list);

        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        set = Collections.unmodifiableSet(set);

        Map<String, Integer> map = new HashMap<>();
        map.put("kim", 123);
        map.put("lee", 234);
        map = Collections.unmodifiableMap(map);

    }

    /***
     * Java 9 이후로는 XXX.of 메서드를 이용하여 Immutable Collection 활용이 가능해졌다.
     */
    void afterJava9() {
        List<String> list = List.of("kim", "lee", "park");
        Set<Integer> set = Set.of(1,2,3);
        Map<String, Integer>map = Map.of("kim", 123, "lee", 234);
    }
}
