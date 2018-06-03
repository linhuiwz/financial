package com.imooc.manager.service;

import com.imooc.api.events.ProductStatusEvent;
import com.imooc.entity.enums.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ProductStatusManager {

    private static Logger LOG = LoggerFactory.getLogger(ProductStatusManager.class);

    private static final String MQ_DESTINATION = "VirtualTopic.PRODUCT_STATUS";

    @Autowired
    private JmsTemplate jmsTemplate;

    public void changeStatus(String id, ProductStatus productStatus) {
        ProductStatusEvent productStatusEvent = new ProductStatusEvent(id, productStatus);
        LOG.warn("send message:{}", productStatusEvent);
        jmsTemplate.convertAndSend(MQ_DESTINATION, productStatusEvent);
    }

    @PostConstruct
    public void init() {
        changeStatus("002", ProductStatus.FINISHED);
    }
}
