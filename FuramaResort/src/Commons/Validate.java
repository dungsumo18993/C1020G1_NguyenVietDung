package Commons;

public class Validate {

    public static final String ID_VILLA_REGEX="SVVL-\\d{4}";
    public static final String ID_HOUSE_REGEX="SVHO-\\d{4}";
    public static final String ID_ROOM_REGEX="SVRO-\\d{4}";
    public static final String TENDICHVU_REGEX="(Spa|Pool|Bar|Casino|Golf)";
    public static final String DICHVUDIKEM_REGEX="(massage|karaoke|food|drink|car)";
    public static final String KIEUTHUE_REGEX="(Day|Month|Year|Hours)";
    public static final String TIEUCHUAN_REGEX="(Vip|Medium|Normal)";

    public static final String HOTEN_REGEX="([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}";
    public static final String EMAIL_REGEX="([\\w]+@[a-z]+.(com|vn))";
    public static final String GENDER_REGEX="(Male|Female|Unknow)";
    public static final String IDCARD_REGEX="([0-9]{3}-[0-9]{3}-[0-9]{3})";
    public static final String BIRTHDAY_REGEX="\\d{2}/\\d{2}/\\d{4}";
    public static final String PHONENUMBER_REGEX="(\\+84|0)[0-9]{9}";
    public static final String CUSTOMERTYPE_REGEX="(Diamond|Platinium|Gold|Silver|Member)";

    public static boolean checkIdVilla(String id){
        return id.matches(ID_VILLA_REGEX);
    }

    public static boolean checkIdHouse(String id){
        return id.matches(ID_HOUSE_REGEX);
    }

    public static boolean checkIdRoom(String id){
        return id.matches(ID_ROOM_REGEX);
    }

    public static boolean checkTenDichVu(String tenDichVu){
        return tenDichVu.matches(TENDICHVU_REGEX);
    }

    public static boolean checkDichVuDiKem(String dichVuDiKem){
        return dichVuDiKem.matches(DICHVUDIKEM_REGEX);
    }

    public static boolean checkKieuThue(String kieuThue){
        return kieuThue.matches(KIEUTHUE_REGEX);
    }

    public static boolean checkTieuChuan(String tieuChuan){
        return tieuChuan.matches(TIEUCHUAN_REGEX);
    }

    public static boolean checkHoTen(String hoTen){
        return hoTen.matches(HOTEN_REGEX);
    }

    public static boolean checkEmail(String email){
        return email.matches(EMAIL_REGEX);
    }

    public static boolean checkGenDer(String genDer){
        return genDer.matches(GENDER_REGEX);
    }

    public static boolean checkIdCard(String idCard){
        return idCard.matches(IDCARD_REGEX);
    }

    public static boolean checkPhoneNumber(String phoneNumber){
        return phoneNumber.matches(PHONENUMBER_REGEX);
    }

    public static boolean checkBirthDay(String birthDay){
        return birthDay.matches(BIRTHDAY_REGEX);
    }

    public static boolean checkCustomerType(String customerType){
        return customerType.matches(CUSTOMERTYPE_REGEX);
    }
}
