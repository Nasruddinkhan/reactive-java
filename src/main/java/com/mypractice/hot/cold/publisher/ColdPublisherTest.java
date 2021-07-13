package com.mypractice.hot.cold.publisher;

import com.mypractice.util.Util;

public class ColdPublisherTest {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenveService revenveService = new RevenveService();
        InventoryService inventoryService = new InventoryService();
        System.out.println("ColdPublisherTest.main" +orderService);
        orderService.orderStream().subscribe(revenveService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

        inventoryService.inventoryStream().subscribe(Util.subscriber("inventory"));
        revenveService.revenueStream().subscribe(Util.subscriber("revenue"));

        Util.sleepSeconds(60);
    }
}
