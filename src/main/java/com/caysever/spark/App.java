package com.caysever.spark;

import static spark.Spark.exception;
import static spark.Spark.port;

import java.util.logging.Logger;

import com.caysever.spark.controller.ProductController;
import com.caysever.spark.service.ProductService;

public class App {
    private static Logger logger = Logger.getLogger(App.class.getCanonicalName());

    public static void main(String[] args) {
	int portNumber = getHerokuAssignedPort();
	port(portNumber);

	logger.info("Context started at " + portNumber + " port number.");

	exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print
									  // all
									  // exceptions

	new ProductController(new ProductService());

    }

    static int getHerokuAssignedPort() {
	ProcessBuilder processBuilder = new ProcessBuilder();
	if (processBuilder.environment().get("PORT") != null) {
	    return Integer.parseInt(processBuilder.environment().get("PORT"));
	}
	return 4567; // return default port if heroku-port isn't set (i.e. on
		     // localhost)
    }
}
