package collection;

import entity.Order;

import java.util.*;

public class IteratorMain {
    public static void main(String[] args) {

        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order(231, 12.));
        orders.add(new Order(389, 2.9));
        orders.add(new Order(747, 32.));
        orders.add(new Order(517, 1.7));
        orders.add(new Order(414, 17.));

        System.out.println(orders);

        float bigAmount = 10;
        int percent = 5;

        orders.removeIf(order -> order.getAmount() <= bigAmount);
        orders.forEach(order -> order.setAmount(order.getAmount() * (100 - percent) / 100.0));

//        OrderAction orderAction = new OrderAction();
//        System.out.println(orders.hashCode());
//        orderAction.discountAction(bigAmount, orders, percent);

        System.out.println(orders);

    }
}
