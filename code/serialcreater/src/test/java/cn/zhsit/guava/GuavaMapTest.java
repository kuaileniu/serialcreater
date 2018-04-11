package cn.zhsit.guava;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * http://blog.csdn.net/foreverling/article/details/52204493
 */
public class GuavaMapTest {

    //1.1 转化后具有唯一Key
    @Test
    public void testUniqueIndex() {
        List<Person> persons = Arrays.asList(
                new Person("zhang", 15),
                new Person("wang", 16),
                new Person("lee", 18)
        );
        /**
         * 转换后的Map具有唯一键
         */
        Map<String, Person> map = Maps.uniqueIndex(persons, new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getName();
            }
        });

        System.out.println(map);
        System.out.println(map.get("zhang"));
        if (map.get("zhang") instanceof Person) {
            System.out.println("value 是Person对象");
        } else {
            System.out.println("value 不是Person对象");
        }
    }

    //1.2 转化后的Key不唯一
    @Test
    public void testIndex() {
        List<Person> persons = Lists.newArrayList(
                new Person("zhang", 15),
                new Person("zhang", 16),
                new Person("lee", 18)
        );
        /**
         * 转换后的Map有重复键
         */
        Multimap<String, Person> multiMap = Multimaps.index(persons, new Function<Person, String>() {
            public String apply(Person person) {
                return person.getName();
            }
        });

        System.out.println(multiMap);
        Map mm = multiMap.asMap();
        System.out.println(mm);
    }

    //2 将Set转化为Map
    @Test
    public void testSetAsMap() {
        Set<Person> persons = Sets.newHashSet(
                new Person("zhang", 15),
                new Person("zhang", 16),
                new Person("lee", 18)
        );
        /**
         * 以Set的值为Key，计算出一个Value
         */
        Map<Person, String> map = Maps.asMap(persons, new Function<Person, String>() {
            public String apply(Person person) {
                return person.getName();
            }
        });
        System.out.println(map);
    }

    //3 转换Map的值
    @Test
    public void test2Map() {
        List<Person> persons = Lists.newArrayList(
                new Person("zhang", 15),
                new Person("wang", 15),
                new Person("lee", 18)
        );
        Map<String, Person> map = Maps.uniqueIndex(persons, new Function<Person, String>() {
            public String apply(Person person) {
                return person.getName();
            }
        });

        System.out.println("map:" + map);
        /**
         * 使用Key和Value作为输入，计算出一个新的Value
         */
        Map<String, Integer> map2 = Maps.transformEntries(map, new Maps.EntryTransformer<String, Person, Integer>() {
            @Override
            public Integer transformEntry(String s, Person person) {
                return person.getAge();
            }
        });
        System.out.println("map2:" + map2);
        /**
         * 使用Function计算出一个新的Value
         */
        Map<String, Double> map3 = Maps.transformValues(map, new Function<Person, Double>() {
            @Override
            public Double apply(Person person) {
                return (double) person.getAge();
            }
        });
        System.out.println("map3:" + map3);

    }

    //4 筛选Map中符合条件的映射
    @Test
    public void testFilter() {
        List<Person> persons = Lists.newArrayList(
                new Person("zhang", 15),
                new Person("wang", 15),
                new Person("lee", 18)
        );
        Map<String, Person> map = Maps.uniqueIndex(persons, new Function<Person, String>() {
            public String apply(Person person) {
                return person.getName();
            }
        });

        map = Maps.filterEntries(map, new Predicate<Map.Entry<String, Person>>() {
            @Override
            public boolean apply(Map.Entry<String, Person> stringPersonEntry) {
                return stringPersonEntry.getKey() != null && stringPersonEntry.getValue() != null;
            }
        });

        map = Maps.filterKeys(map, new Predicate<String>() {
            @Override
            public boolean apply(String s) {
                return s != null && s.length() > 2;
            }
        });

        map = Maps.filterValues(map, new Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                return person != null && person.getAge() > 15;
            }
        });


        for (Map.Entry<String, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
