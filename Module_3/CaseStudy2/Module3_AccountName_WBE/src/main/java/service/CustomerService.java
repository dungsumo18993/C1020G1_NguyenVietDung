package service;

import model.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAllCustomer();

    public Customer findCustomer(int id);

    public void insertCustomer(Customer customer);

    public boolean updateCustomer(Customer customer);

    public boolean deleteCustomer(int id);
}
