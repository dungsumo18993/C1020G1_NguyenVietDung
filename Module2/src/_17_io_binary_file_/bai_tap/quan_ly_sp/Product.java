package _17_io_binary_file_.bai_tap.quan_ly_sp;

import java.io.Serializable;

public class Product implements Serializable {
    private int productId;
    private String productName;
    private String manuFacturer;
    private double productPrice;
    private String otherDescription;

    public Product(int productId, String productName, String manufacturer, double productPrice, String otherDescription) {
        this.productId = productId;
        this.productName = productName;
        this.manuFacturer = manufacturer;
        this.productPrice = productPrice;
        this.otherDescription = otherDescription;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManuFacturer() {
        return manuFacturer;
    }

    public void setManuFacturer(String manuFacturer) {
        this.manuFacturer = manuFacturer;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", manuFacturer='" + manuFacturer + '\'' +
                ", productPrice=" + productPrice +
                ", descriptionsOther='" + otherDescription + '\'' +
                '}';
    }
}
