package com.imooc.seller;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class HazelcastMapTest {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @PostConstruct
    public void put() {
        Map map = hazelcastInstance.getMap("imooc");
        map.put("name", "imooc");
    }
}
