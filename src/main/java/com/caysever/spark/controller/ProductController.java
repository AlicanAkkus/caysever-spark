package com.caysever.spark.controller;

import static spark.Spark.*;


import java.util.logging.Logger;

import com.caysever.spark.model.Product;
import com.caysever.spark.service.IProductService;
import com.caysever.spark.utils.ResponseStatus;
import com.caysever.spark.utils.ResponseUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author alican {@link https://caysever-spark.herokuapp.com}
 * 
 * */

public class ProductController {
    
    private Logger logger = Logger.getLogger(ProductController.class.getCanonicalName());
    
    public ProductController(final IProductService productService) {
	
	path("/api", () -> {
	    before((q, a) -> logger.info("Received api call"));
	    // insert a product (using HTTP post method)
	    post("/products", (request, response) -> {
		try {
		    ObjectMapper mapper = new ObjectMapper();
		    Product product = mapper.readValue(request.body(), Product.class);
		    if (!product.isValid()) {
			response.status(ResponseStatus.HTTP_BAD_REQUEST);
			return "";
		    }
		    
		    productService.addProduct(product);
		    response.status(200);
		    response.type("application/json");
		    return product.getId();
		} catch (JsonParseException jpe) {
		    response.status(ResponseStatus.HTTP_BAD_REQUEST);
		    return "Could\'t parsed request body!";
		}
	    });
	    
	    // get all product (using HTTP get method)
	    get("/products", (request, response) -> {
		response.status(200);
		response.type("application/json");
		return ResponseUtil.dataToJson(productService.getProducts());
	    });
	    
	    // delete product (using HTTP delete method)
	    delete("/products/:id", (request, response) -> {
		Integer productID = Integer.valueOf(request.params(":id"));
		productService.deleteProduct(productID);
		response.status(200);
		response.type("application/json");
		return ResponseUtil.dataToJson(productService.getProducts());
	    });
	    
	    put("/products", (request, response) -> {
		try {
		    ObjectMapper mapper = new ObjectMapper();
		    Product product = mapper.readValue(request.body(), Product.class);
		    if (!product.isValid()) {
			response.status(ResponseStatus.HTTP_BAD_REQUEST);
			return "";
		    }
		    
		    if(productService.updateProduct(product)){
			response.status(200);
			response.type("application/json");

			return product.getId();
		    }
		    return "Could\'t update product!";
		} catch (JsonParseException jpe) {
		    response.status(ResponseStatus.HTTP_BAD_REQUEST);
		    return "Could\'t parsed request body!";
		}
	    });
	});


    }
}
