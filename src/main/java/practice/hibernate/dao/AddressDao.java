package practice.hibernate.dao;

import practice.hibernate.basics.Address;

public class AddressDao extends Dao<Address> {

    private AddressDao() {
        super(Address.class);
    }

    private static final AddressDao INSTANCE = new AddressDao();

    public static AddressDao getInstance() {
        return INSTANCE;
    }
}
