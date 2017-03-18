package com.mysamples.ref.optym.vameork.validators.files;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileValidator {

	private String givenFileName;
	private InputStream inputStreamForGivenFile;
	private Workbook workbook;
	private Sheet firstSheet;
	Iterator<Row> xlsxLoadedIterator;
	private boolean isLoadedXlsxFileIsEmpty;
	private List<String> headerErrorsList = new ArrayList<>();
	
	
	public FileValidator(String fileNameTobeValidated) {
		this.givenFileName = fileNameTobeValidated;
		inputStreamForGivenFile = ClassLoader.getSystemResourceAsStream(givenFileName);
		loadXlsxFile();
	}

	private void loadXlsxFile() {
		if (inputStreamForGivenFile != null) {
			try {
				workbook = new XSSFWorkbook(inputStreamForGivenFile);
				firstSheet = workbook.getSheetAt(0);
				xlsxLoadedIterator = firstSheet.iterator();
				// set the file empty/nonempty flag
				isLoadedXlsxFileIsEmpty = !(xlsxLoadedIterator.hasNext());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void closeFile(){
		if(inputStreamForGivenFile != null){
			try {
				inputStreamForGivenFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean isFileExists() {
		return (inputStreamForGivenFile != null);
	}

	public boolean isFileEmpty() {
		return isLoadedXlsxFileIsEmpty;
	}

	public boolean isFileHavingOnlyHeader() {
		return (firstSheet.getPhysicalNumberOfRows() < 2);
	}

	public boolean isHeaderValid() {
		List<String> headerRowList = getOnlyFirstRowOfGivenFile();
		FileHeaderValidator fileHeaderValidator = new FileHeaderValidator(headerRowList);
		boolean isHeaderValid = fileHeaderValidator.validateHeader();
		if(! isHeaderValid){
			headerErrorsList.addAll(fileHeaderValidator.errorsList);
			System.out.println("Errors > "+ headerErrorsList.toString());
		}
		return isHeaderValid;
	}
		
	private List<String> getOnlyFirstRowOfGivenFile(){
		List<String> results = new ArrayList<>();
		String data;
		if(xlsxLoadedIterator.hasNext()) {
            Iterator<Cell> cellIter = ((Row)xlsxLoadedIterator.next()).cellIterator();
            while(cellIter.hasNext()) {
                Cell cell = (Cell)cellIter.next();
                DataFormatter df = new DataFormatter();
                data = df.formatCellValue(cell);
                results.add(data);
            }
        }   
		return results;
	}
	
}
