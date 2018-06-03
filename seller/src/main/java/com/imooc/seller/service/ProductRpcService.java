package com.imooc.seller.service;

import com.imooc.api.ProductRpc;
import com.imooc.api.domain.ProductRpcReq;
import com.imooc.api.events.ProductStatusEvent;
import com.imooc.entity.Product;
import com.imooc.entity.enums.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRpcService implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger LOG = LoggerFactory.getLogger(ProductRpcService.class);

    private static final String MQ_DESTINATION = "Consumer.cache.VirtualTopic.PRODUCT_STATUS";

    @Autowired
    private ProductRpc productRpc;

    @Autowired
    private ProductCache productCache;


    public Product findOne(String id) {
        Product result = productCache.readCache(id);
        if (result == null) {
            productCache.removeCache(id);
        }
        return result;
    }

    public List<Product> findAll() {
        return productCache.readAllCaches();
    }

    //@PostConstruct
    public void testFindAll() {
        findAll();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Product> products = findAll();
        LOG.warn("初始化所有销售中的产品到缓存:{}", products);
        products.forEach(product -> productCache.putCache(product));
    }

    @JmsListener(destination = MQ_DESTINATION)
    public void updateCache(ProductStatusEvent event) {
        LOG.warn("receive event:{}", event);
        productCache.removeCache(event.getId());
        if (ProductStatus.IN_SELL.equals(event.getProductStatus())) {
            productCache.readCache(event.getId());
        }
    }

}
