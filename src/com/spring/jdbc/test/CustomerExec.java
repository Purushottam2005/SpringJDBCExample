/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.jdbc.test;

import com.spring.jdbc.Customer;
import com.spring.jdbc.CustomerDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jyo
 */
public class CustomerExec {
    
    public static void main(String args[]){
        
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("customer_jdbc.xml");
        CustomerDAO customerDAO =  (CustomerDAO) applicationContext.getBean("customerdao");
        
        
        Customer customer = new Customer();    
        customer.setAge(20);
        customer.setName("Roger Chick");
        
        Customer customer1 = new Customer();    
        customer1.setAge(30);
        customer1.setName("Stephen Hardy");
        
         Customer customer2 = new Customer();    
        customer2.setAge(30);
        customer2.setName("Kuldip Bajwa");
        
        //CREATE CUSTOMER RECORD EXAMPLE
        System.out.println("Rows affected: " + customerDAO.createCustomer(customer));
        System.out.println("Rows affected: " + customerDAO.createCustomer(customer1));
        
        //RETRIEVE CUSTOMER RECORDS EXAMPLE
        System.out.println("CUSTOMER TABLE RECORDS: "+customerDAO.retrieveAllCustomers().toString());
       
        //QUERYING A PARTICULAR RECORD FROM CUSTOMER TABLE - For e.g., by Customer ID
        System.out.println("Record Found: \n" + customerDAO.getCustomer(3).toString());
        
        
        
    }
}
