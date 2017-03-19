package com.mysamples.ref.optym.vameork.validators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mysamples.ref.optym.vameork.validators.files.FileValidator;

public class Validators implements RulesValidator{

	@Override
	public HashMap<String,List<String>> isFileValid(String fileNametobeChecked) {
		FileValidator fileValidator = new FileValidator(fileNametobeChecked);
		HashMap<String,List<String>> resultantHashMap = new HashMap<String,List<String>>();
		List<String> results = new ArrayList<String>();
		if(
				fileValidator.isFileExists() 
				&& !(fileValidator.isFileEmpty()) 
				&& !(fileValidator.isFileHavingOnlyHeader())
				&& fileValidator.isHeaderValid() ){
			results.add("SUCCESS");results.add("Input File is Valid");results.add("Input File is having valid Header and Some Contents");
			
			
		}else{
			results.add("ERROR");results.addAll(fileValidator.getHeaderErrorsList());
		}
		resultantHashMap.put("STATUS", results);
		return resultantHashMap;
	}

}
