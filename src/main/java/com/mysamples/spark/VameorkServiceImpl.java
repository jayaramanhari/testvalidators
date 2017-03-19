package com.mysamples.spark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mysamples.ref.optym.vameork.validators.Validators;

public class VameorkServiceImpl implements VameorkService {

	private List<String> resultantList;

	@Override
	public boolean isUploadedFileValidByQuickCheck(String fileId) {
		String fileName = getFileNametobeValidatedByGivenFileId(fileId);
		boolean status = false;
		HashMap<String, List<String>> resultsMap = new HashMap<>();
		if (fileName != null) {
			Validators validators = new Validators();
			resultsMap = validators.isFileValid(fileName);
			status = parseAndLoadResults(resultsMap);
		}
		else{
			resultantList = new ArrayList<String>();
			resultantList.add("ERROR");resultantList.add("No Valid File found. Please check your input");
		}

		return status;
	}

	private boolean parseAndLoadResults(HashMap<String, List<String>> resultsMap) {
		boolean isSuccess = false;
		resultantList = new ArrayList<>();
		resultantList.addAll(resultsMap.get("STATUS"));
		if(resultantList.get(0).equals("SUCCESS")){
			isSuccess = true;
		}
		return isSuccess;
	}

	// TODO resolve differently
	private String getFileNametobeValidatedByGivenFileId(String fileId) {
		String fname = null;
		switch (fileId) {
			case "1234": {
				fname = "sampleIncorrectHeaderCountAndValues.xlsx";
				break;
			}
			case "1235": {
				fname = "sampleExistentFile.xlsx";
				break;
			}
			case "1236": {
				fname = "sampleIncorrectHeaderRowFile.xlsx";
				break;
			}
		}
		return fname;
	}
	@Override
	public List<String> getResultantList() {
		return resultantList;
	}
}
