# caysever-spark
simple spark web application

### how to use it?

you can access to api at the heroku. Api base url is [heroku](https://caysever-spark.herokuapp.com/api/products)

### model object

model object is the product. 

``` java

 private int id;
 private String name;
 private List<String> categories = new LinkedList<String>();
 private double price;
 private boolean available;

```

### api verbs
 - **/post** for the create new product
 - **/get/:id** for the get existing product
 - **/get** for the get all existing products
 - **/put** for the update existing product
 - **/delete/:id** for the delete existin product

### examples
1. new product
please use the http post method with below sample body;
    > {
      "id" : "1", 	
      "name":"ZTE AXON 7",
      "categories": [
    		"PHONE",
    		"ZTE"
    	],
      "price":"2299",
      "available":"true"
      }
2. get product(s)
please use the get method with sample url's
- https://caysever-spark.herokuapp.com/api/products
- https://caysever-spark.herokuapp.com/api/products/1

3. delete product
please use the http delete method with sample url
- https://caysever-spark.herokuapp.com/api/products/1

4. update product
please use the http put method with below sample body;
    > {
      "id" : "1", 	
      "name":"ZTE AXON 7",
      "categories": [
    		"PHONE",
    		"ZTE"
    	],
      "price":"2499",
      "available":"true"
      }

Products will be stored in memory.
