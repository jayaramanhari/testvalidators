package com.mysamples.spark;
import static spark.Spark.get;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class RestApp {
    public static void main(String[] args) {
        final VameorkService service = new VameorkServiceImpl();
        
        get("/vameork/quickfilevalidate/:id", (request, response) -> {
        	
            response.type("application/json");
            boolean results = service.isUploadedFileValidByQuickCheck(request.params(":id"));
            JsonElement resultantJson = new Gson().toJsonTree(service.getResultantList());
            
            if(results){
            	return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, resultantJson));
            }
            else{
            	return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, resultantJson));
            }
            
        });

    }
}
