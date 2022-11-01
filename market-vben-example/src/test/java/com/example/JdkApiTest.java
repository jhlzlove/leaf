package com.example;

import com.example.domain.test.Address;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jhlz
 * @time 2022/8/29 9:50
 * @desc: JdkApiTest
 */
public class JdkApiTest {
    private static final Logger logger = LoggerFactory.getLogger(JdkApiTest.class);

    /**
     * test：测试获取操作系统信息
     */
    @Test
    public void testOs() {
        // System.out.println(System.getenv());
        String username = System.getProperty("user.name");
        String os = System.getProperty("os.name");
        System.out.println("系统名称：" + os);
        System.out.println("系统架构：" + System.getProperty("os.arch"));
        System.out.println("系统版本：" + System.getProperty("os.version"));
        System.out.println(os.toLowerCase().contains("linux") ? "D:/market/logs" : "/home/" + username + "/logs");
    }

    /**
     * test：Time convert用例
     */
    @Test
    public void testTime() {
        System.out.println(Date.from(LocalDateTime.now().toInstant(ZoneOffset.ofHours(8))));
    }

    /**
     * test: List distinct example
     */
    @Test
    public void testListDistinct() {
        // 去重，只保留重复的地址，不要经纬度
        List<Address> list = Arrays.asList(
                new Address("石南村", "110.234", "23.456"),
                new Address("安南村", "110.234", "23.456"),
                new Address("天平村", "120.234", "96.732"),
                new Address("金雷村", "130.673", "23.456"),
                new Address("海境", "150.123", "23.456"),
                new Address("灵界", "150.123", "23.456")
        );
        // 找到集合中所有的经纬度，不会重复
        List<Address> distinctClass = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getLatitude() + ";" + o.getLongitude()))), ArrayList::new));
        System.out.println(distinctClass);

        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> save = new ArrayList<>();

        //    双层循环遍历，Address 集合与 distinctClass 的经纬度属性比较，处理相等的值，不可能出现不等的值
        for (int i = 0; i < distinctClass.size(); i++) {
            Address hasAddr = distinctClass.get(i);
            String hasAddrLongitude = hasAddr.getLongitude();
            String hasAddrLatitude = hasAddr.getLatitude();
            String name = hasAddr.getAddress();
            // 唯一键
            String key = hasAddrLongitude + "," + hasAddrLatitude;
            List<String> tempList = new ArrayList<>();
            tempList.add(name);
            result.put(key, tempList);


            for (int j = 0; j < list.size(); j++) {
                Address tempAddr = list.get(j);
                // 相等数据
                if (hasAddrLongitude.equals(tempAddr.getLongitude()) && hasAddrLatitude.equals(tempAddr.getLatitude()) &&
                        !name.equals(tempAddr.getAddress())) {
                    Object o = result.get(key);
                    List<String> stringList = (List<String>) o;
                    stringList.add(tempAddr.getAddress());
                    // 放入新的集合
                    result.put(key, stringList);
                    // result.put("longitude", hasAddrLongitude);
                    // result.put("latitude", hasAddrLatitude);
                    // save.add(result);
                }
            }
        }
        System.out.println(result);
    }

    /**
     * test: map.put() example
     */
    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>();
        String hahahha = map.put("123", "hahahha");
        System.out.println(hahahha);

    }
}
