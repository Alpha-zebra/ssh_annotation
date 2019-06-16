package com.alpha.dao.impl;

import com.alpha.dao.ProductDAO;
import com.alpha.pojo.Product;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository("productDAO")
public class ProductDAOImpl extends HibernateTemplate implements ProductDAO {
    @Override
    public List<Product> list() {
        return find("from Product");
    }

    @Override
    public void add(Product p) {
        save(p);
    }

    @Override
    public void delete(int id) {
        Product p= get(Product.class,id);
        delete(p);
    }

    @Override
    @Resource(name = "sf")
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public Product get(int id) {
        return get(Product.class,id);
    }

    @Override
    public void updateProduct(Product product) {
        update(product);
    }

//
//    @Override
//    public void update(int id) {
//        update(id);
//    }
}
