package com.caysever.spark.service;

import java.util.List;

import com.caysever.spark.model.Product;

public interface IProductService {

    /* (non-Javadoc)
     * @see com.caysever.spark.service.IProductService#addProduct(com.caysever.spark.model.Product)
     */
    public abstract boolean addProduct(Product product);

    /* (non-Javadoc)
     * @see com.caysever.spark.service.IProductService#deleteProduct(java.lang.Integer)
     */
    public abstract boolean deleteProduct(Integer productID);

    /* (non-Javadoc)
     * @see com.caysever.spark.service.IProductService#getProduct(java.lang.Integer)
     */
    public abstract Product getProduct(Integer productID);

    /* (non-Javadoc)
     * @see com.caysever.spark.service.IProductService#getProducts()
     */
    public abstract List<Product> getProducts();

    public abstract boolean updateProduct(Product product);

}