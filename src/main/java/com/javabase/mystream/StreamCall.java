package com.javabase.mystream;

import com.javabase.mystream.pojo.Pestu;
import com.javabase.mystream.pojo.Pestus;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.TestOnly;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@Data

public class StreamCall {
    //@Autowired
    @Resource(name = "pestus")
    private Pestus pestus;

    public StreamCall() {
    }

    @TestOnly
    public StreamCall(Pestus pestus) {
        this.pestus = pestus;
    }

    public void ShowPersons() {
        System.out.println(pestus);
    }

    public void show1() {
        System.out.println("StreamCall.CallPetus");
        List<Integer> list = Arrays.asList(1,7,9,5,3,2,8);
        list.stream().filter(x->x>3).forEach(System.out::println);
        Optional<Integer> find = list.stream().findFirst();
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().findAny();
        System.out.println("find = " + find);
        System.out.println("findAny = " + findAny);

        // 是否包含符合特定条件的元素
        boolean bl = list.stream().anyMatch(x->x>3);
        System.out.println("bl = " + bl);
    }
    public void show2() {
        List<Pestu> list = pestus.getPestuList();
        List<String> l1 = list.stream()
                .filter(elm->elm.getSalary()>7999)
                .map(Pestu::getName)
                .collect(Collectors.toList());
        System.out.println("l1 = " + l1);
        List<Integer> l2 = list.stream()
                .filter(elm->elm.getSalary()>7999)
                //.mapToInt(elm->elm.getSalary())
                .map(elm->elm.getSalary())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("l2 = " + l2);

    }
    public void show3() {
        List<String> ls = Arrays.asList("sfa","dddddd","wrqqr","oiu;j;","sdfaj;lfja;lf","dsfdfef");
        Optional<String> max = ls.stream().max(Comparator.comparing(String::length));
        System.out.println("max = " + max);
        System.out.println("max = " + max.get());
    }
}
