package service.validate;

public class Validate {

    public static final String ID_CUSTOMER_REGEX = "KH-\\d{4}";
    public static final String ID_SERVICE_REGEX = "DV-\\d{4}";
    public static final String PHONE_REGEX = "(090|091|([(][+]84[)])[+]90|([(][+]84)[)][+]91)[0-9]{7}";
    public static final String IDCARD_REGEX = "([0-9]{3}-[0-9]{3}-[0-9]{3}|[0-9]{3}-[0-9]{3}-[0-9]{3}-[0-9]{3})";
    public static final String EMAIL_REGEX = "([\\w]+@[a-z]+.[\\w]+)";

    public static boolean idCustomerCheck(String id){
        return id.matches(ID_CUSTOMER_REGEX);
    }

    public static boolean idServiceCheck(String id){
        return id.matches(ID_SERVICE_REGEX);
    }

    public static boolean phoneCheck(String phone){
        return phone.matches(PHONE_REGEX);
    }

    public static boolean idCardCheck(String idCard){
        return idCard.matches(IDCARD_REGEX);
    }

    public static boolean emailCheck(String email){
        return email.matches(EMAIL_REGEX);
    }

}
