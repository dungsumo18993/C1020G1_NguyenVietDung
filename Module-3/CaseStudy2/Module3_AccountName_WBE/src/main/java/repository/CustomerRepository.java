package repository;

import model.Customer;
import model.Employee;

import java.util.List;

public interface CustomerRepository {

    public List<Customer> findAllCustomer();

    public Customer findCustomer(int id);

    public void insertCustomer(Customer customer);

    public boolean updateCustomer(Customer customer);

    public boolean deleteCustomer(int id);
}
