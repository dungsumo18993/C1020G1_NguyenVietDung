package repository.impl;

import model.Customer;
import repository.CustomerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_CUSTOMER = "select c.customer_id, c.customer_name, c.customer_birthday, c.customer_gender, c.customer_id_card, " +
            " c.customer_phone, c.customer_email, c.customer_address, ct.customer_type_name" +
            " from customer c" +
            " inner join customer_type ct on c.customer_type_id = ct.customer_type_id";
    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> customerList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_ALL_CUSTOMER);

            ResultSet rs = preparedStatement.executeQuery();

            Customer customer = null;
            while (rs.next()){
                customer = new Customer();
                customer.setId(Integer.parseInt(rs.getString("customer_id")));
                customer.setName(rs.getString("customer_name"));
                customer.setDateOfBirth(rs.getString("customer_birthday"));
                customer.setGender(rs.getString("customer_gender"));
                customer.setIdCard(rs.getString("customer_id_card"));
                customer.setPhone(rs.getString("customer_phone"));
                customer.setEmail(rs.getString("customer_email"));
                customer.setAddress(rs.getString("customer_address"));
                customer.setType(rs.getString("customer_type_name"));

                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer findCustomer(int id) {
        return null;
    }

    @Override
    public void insertCustomer(Customer customer) {

    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(int id) {
        return false;
    }
}
