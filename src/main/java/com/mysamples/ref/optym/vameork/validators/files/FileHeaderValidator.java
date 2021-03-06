package com.mysamples.ref.optym.vameork.validators.files;

import java.util.ArrayList;
import java.util.List;

import com.mysamples.ref.optym.vameork.domain.ShipmentInputHeaderColumnNumberAndValuesEnum;

public class FileHeaderValidator {
	static boolean isHeaderValuesValid = false;
	public List<String> errorsList = new ArrayList<>();
	public List<String> headerRowValuesAsList = new ArrayList<String>();

	public FileHeaderValidator(List<String> headerRowList) {
		this.headerRowValuesAsList = headerRowList;
	}

	public boolean validateHeader() {
		return (validateHeaderCount() && validateHeaderValues());
	}

	private boolean validateHeaderCount() {
		boolean isHeaderColumnCountValid = (headerRowValuesAsList
				.size() == ShipmentInputHeaderColumnNumberAndValuesEnum.values().length);
		if (!isHeaderColumnCountValid) {
			errorsList.add(
					"Errors > Header Count Mismatch : found '" + headerRowValuesAsList.size() + 
					"' in given file but expected header count is : '" + 
					ShipmentInputHeaderColumnNumberAndValuesEnum.values().length+"'");
		}
		return isHeaderColumnCountValid;
	}

	private boolean validateHeaderValues() {
		if (validateHeaderCount()) {
			String[] headerValuesFromEnum = ShipmentInputHeaderColumnNumberAndValuesEnum.names();
			for (int count = 0; count < headerRowValuesAsList.size(); count++) {
				String headerVal = headerRowValuesAsList.get(count);
				String valFromEnum = headerValuesFromEnum[count];
				if (!(valFromEnum.equals(headerVal))) {
					errorsList.add("Errors > Given header name '" + headerVal + "' at column '" + (count + 1)
							+ "' is not matching with expected header name '" + valFromEnum + "'");
				}
			}
		}
		return errorsList.isEmpty();
	}
}
