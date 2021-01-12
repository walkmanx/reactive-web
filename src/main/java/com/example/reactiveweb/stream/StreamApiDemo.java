package com.example.reactiveweb.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>Title: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Version:zhuoyuan V2.0</p>
 *
 * @author gc
 * @description
 * @date 2021/1/12 下午 14:23
 */
public class StreamApiDemo {

    public static void main(String[] args) {
        test1();

//        test2();
    }

    public static void test1(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("欧阳雪",18,"中国",'F'));
        personList.add(new Person("Tom",24,"美国",'M'));
        personList.add(new Person("Harley",22,"英国",'F'));
        personList.add(new Person("向天笑",20,"中国",'M'));
        personList.add(new Person("李康",22,"中国",'M'));
        personList.add(new Person("小梅",20,"中国",'F'));
        personList.add(new Person("何雪",21,"中国",'F'));
        personList.add(new Person("李康",22,"中国",'M'));

        // 找到年龄大于18岁的人并输出；
        personList.stream().filter((p) -> p.getAge() > 18).forEach(System.out::println);

        System.out.println("-------------------------------------------");

        // 找出所有中国人的数量
        long chinaPersonNum = personList.stream().filter((p) -> p.getCountry().equals("中国")).count();
        System.out.println("中国人有：" + chinaPersonNum + "个");

        System.out.println("-------------------------------------------");

        // 从Person列表中取出两个女性
        personList.stream().filter((p) -> p.getSex() == 'F').limit(2).forEach(System.out::println);

        System.out.println("-------------------------------------------");

        // 从Person列表中从第2个女性开始，取出所有的女性
        personList.stream().filter((p) -> p.getSex() == 'F').skip(1).forEach(System.out::println);

        System.out.println("-------------------------------------------");

        personList.stream().filter((p) -> p.getSex() == 'M').distinct().forEach(System.out::println);

        System.out.println("-------------------------------------------");

        // 对前面的personList按年龄从小到大排序,年龄相同，则再按姓名排序
        final Stream<Person> sorted = personList.stream().sorted((p1, p2) -> {

            if (p1.getAge().equals(p2.getAge())) {
                return p1.getName().compareTo(p2.getName());
            } else {
                return p1.getAge().compareTo(p2.getAge());
            }
        });
        sorted.forEach(System.out::println);

        System.out.println("-------------------------------------------");

        final boolean adult = personList.stream().allMatch(p -> p.getAge() >= 18);
        System.out.println("是否都是成年人：" + adult);
        final boolean isChinese = personList.stream().allMatch(p -> p.getCountry().equals("中国"));
        System.out.println("是否都是中国人：" + isChinese);

        System.out.println("-------------------------------------------");
        final Optional<Person> maxAge = personList.stream().max((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
        System.out.println("年龄最大的人信息：" + maxAge.get());

        final Optional<Person> minAge = personList.stream().min((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
        System.out.println("年龄最小的人信息：" + minAge.get());

        System.out.println("-------------------------------------------");
        final Optional<Integer> reduce = personList.stream().map(Person::getAge).reduce(Integer::sum);
        System.out.println("年龄总和：" + reduce);

        System.out.println("-------------------------------------------");
        final List<String> collect = personList.stream().map(p -> p.getCountry()).distinct().collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("-------------------------------------------");
        final Double collect1 = personList.stream().collect(Collectors.averagingInt(p -> p.getAge()));
        System.out.println("平均年龄为：" + collect1);
    }

    public static void test2(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","ddd");

        final Stream<Stream<Character>> streamStream
                 = list.stream().map(StreamApiDemo::getCharacterByString);
        streamStream.forEach(sm -> sm.forEach(System.out::print));

        System.out.println("");

        final Stream<Character> characterStream = list.stream().flatMap(StreamApiDemo::getCharacterByString);
        characterStream.forEach(System.out::print);

    }

    public static Stream<Character> getCharacterByString(String str) {
        List<Character> characterList = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            characterList.add(character);
        }
        return characterList.stream();
    }


}
