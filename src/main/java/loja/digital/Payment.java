package loja.digital;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Payment {
    private List<Product> productList;
    private LocalDateTime date;
    private Customer customer;

    public Payment(List<Product> productList, LocalDateTime date, Customer customer) {
        this.productList = Collections.unmodifiableList(productList);
        this.date = date;
        this.customer = customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "productList=" + productList +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }
}
