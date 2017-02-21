package com.caysever.spark.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.caysever.spark.model.Product;

public class ProductService implements IProductService {
    private static Map<Integer, Product> products = Collections.synchronizedMap(new HashMap<Integer, Product>());

    /* (non-Javadoc)
     * @see com.caysever.spark.service.IProductService#addProduct(com.caysever.spark.model.Product)
     */
    @Override
    public boolean addProduct(Product product) {
	
	product.setId(products.size() + 1);
	products.put(product.getId(), product);
	
	return true;
    }

    /* (non-Javadoc)
     * @see com.caysever.spark.service.IProductService#deleteProduct(java.lang.Integer)
     */
    @Override
    public boolean deleteProduct(Integer productID) {
	
	if(products.containsKey(productID)){
	    products.remove(productID);
	    return true;
	}
	
	return false;
    }

    /* (non-Javadoc)
     * @see com.caysever.spark.service.IProductService#getProduct(java.lang.Integer)
     */
    @Override
    public Product getProduct(Integer productID) {
	return products.get(productID);
    }

    /* (non-Javadoc)
     * @see com.caysever.spark.service.IProductService#getProducts()
     */
    /* (non-Javadoc)
     * @see com.caysever.spark.service.IProductService#getProducts()
     */
    @Override
    public List<Product> getProducts() {
	List<Product> productList = new LinkedList<Product>();

	products.values().forEach(item -> productList.add(item));

	return productList;
    }
    
    /* (non-Javadoc)
     * @see com.caysever.spark.service.IProductService#updateProduct(com.caysever.spark.model.Product)
     */
    @Override
    public boolean updateProduct(Product product){
	
	if(products.containsKey(product.getId())){
	    products.replace(product.getId(), product);
	    return true;
	}
	return false;
    }
}
