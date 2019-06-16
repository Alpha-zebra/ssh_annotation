package com.alpha.service.impl;

import com.alpha.dao.ProductDAO;
import com.alpha.pojo.Product;
import com.alpha.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;
    Product product;
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = "Exception")
    public List<Product> list() {
        List<Product> products=productDAO.list();
        if (products.isEmpty()){
            for (int i=0;i<5;i++){
//                //===========================
//                if (i==2) throw new RuntimeException();
//                //===========================
                Product p=new Product();
                p.setName("product "+i);
                productDAO.add(p);
                products.add(p);
            }
        }
        return products;
    }

    @Override
    public void delete(Product p) {

        productDAO.delete(p.getId());
    }
    public Product get(int id){

        Product p=productDAO.get(id);
        return p;
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public void add(Product product) {
        productDAO.add(product);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
}
