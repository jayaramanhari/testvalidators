package com.mysamples.spark;

import static spark.Spark.*;

public class HelloWorld {

	public static void main(String ar[]){
		get("/hello",(req,res) -> "Hello World From Spark Rest Service Example " + req.queryParams("name"));
	}
}
