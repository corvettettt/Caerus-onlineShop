package com.laioffer.onlineShop.service;


import com.laioffer.onlineShop.entity.Cart;
import com.laioffer.onlineShop.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laioffer.onlineShop.dao.CustomerDao;


@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        //precheck （spring security）
        customer.getUser().setEnabled(true);
//      其他field会在对应的register.jsp中被传回后端，只有cart的信息没有，所以这里需要创建一个新的
        Cart cart = new Cart();
        customer.setCart(cart);

        customerDao.addCustomer(customer);
    }

    public Customer getCustomerByUserName(String userName) {
        return customerDao.getCustomerByUserName(userName);
    }
}
