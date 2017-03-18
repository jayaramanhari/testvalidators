package com.mysamples.ref.optym.vameork.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.mysamples.ref.optym.vameork.validators.files.FileValidator;

public class FileValidatorsTest {
	private static final String FILE_NAME_THAT_EXISTS = "sampleExistentFile.xlsx";
	private static final String FILE_NAME_THAT_NOT_EXISTS = "#$#$#iamnotexist@#@#.xlsx";
	private static final String FILE_NAME_OF_AN_EMPTY_FILE = "sampleEmptyFile.xlsx";
	private static final String FILE_NAME_THAT_HAS_ONLY_HEADER = "sampleHeaderOnlyFile.xlsx";
	private static final String FILE_NAME_THAT_HAS_MORE_THAN_HEADER = "sampleContentMoreThanHeaderRowsFile.xlsx";
	private static final String FILE_NAME_THAT_HAS_INCORRECT_HEADER_VALUES = "sampleIncorrectHeaderRowFile.xlsx";
	private static final String FILE_NAME_THAT_HAS_INCORRECT_HEADER_CNT_N_VALUES = "sampleIncorrectHeaderCountAndValues.xlsx";
	@Before
	public void setup() {
		
	}
	
	@Test
	public void testIsFileExists() {
		FileValidator fileValidator = new FileValidator(FILE_NAME_THAT_EXISTS);
		assertTrue(fileValidator.isFileExists());
		fileValidator.closeFile();
	}
	
	@Test
	public void testFileNotExistScenario(){
		FileValidator fileValidator = new FileValidator(FILE_NAME_THAT_NOT_EXISTS);
		assertFalse(fileValidator.isFileExists());
		fileValidator.closeFile();
	}
	
	@Test
	public void testIsFileEmpty(){
		FileValidator fileValidator = new FileValidator(FILE_NAME_OF_AN_EMPTY_FILE);
		assertTrue(fileValidator.isFileEmpty());
		fileValidator.closeFile();
	}

	@Test
	public void testFileIsNotEmpty(){
		FileValidator fileValidator = new FileValidator(FILE_NAME_THAT_EXISTS);
		assertFalse(fileValidator.isFileEmpty());
		fileValidator.closeFile();
	}
	
	@Test
	public void testFileIsHavingOnlyHeader(){
		FileValidator fileValidator = new FileValidator(FILE_NAME_THAT_HAS_ONLY_HEADER);
		assertTrue(fileValidator.isFileExists());
		assertFalse(fileValidator.isFileEmpty());
		assertTrue(fileValidator.isFileHavingOnlyHeader());
		fileValidator.closeFile();
	}	
	@Test
	public void testFileIsHavingOnlyHeaderNegateForMoreContentFile(){
		FileValidator fileValidator = new FileValidator(FILE_NAME_THAT_HAS_MORE_THAN_HEADER);
		assertTrue(fileValidator.isFileExists());
 		assertFalse(fileValidator.isFileEmpty());
		assertFalse(fileValidator.isFileHavingOnlyHeader());
		fileValidator.closeFile();
	}

	@Test
	public void testFileForCorrectHeaderColumnFormat(){
		FileValidator fileValidator = new FileValidator(FILE_NAME_THAT_HAS_MORE_THAN_HEADER);
		assertTrue(fileValidator.isFileExists());
		assertFalse(fileValidator.isFileEmpty());
		assertFalse(fileValidator.isFileHavingOnlyHeader());
		assertTrue(fileValidator.isHeaderValid());
		fileValidator.closeFile();
	}
	
	@Test
	public void testFileForIncorrectHeaderColumnFormat(){
		FileValidator fileValidator = new FileValidator(FILE_NAME_THAT_HAS_INCORRECT_HEADER_VALUES);
		assertTrue(fileValidator.isFileExists());
		assertFalse(fileValidator.isFileEmpty());
		assertFalse(fileValidator.isFileHavingOnlyHeader());
		assertFalse(fileValidator.isHeaderValid());
		fileValidator.closeFile();
	}
	@Test
	public void testFileForIncorrectHeaderCountAndIncorrectHeaderValues(){
		FileValidator fileValidator = new FileValidator(FILE_NAME_THAT_HAS_INCORRECT_HEADER_CNT_N_VALUES);
		assertTrue(fileValidator.isFileExists());
		assertFalse(fileValidator.isFileEmpty());
		assertFalse(fileValidator.isFileHavingOnlyHeader());
		assertFalse(fileValidator.isHeaderValid());
		fileValidator.closeFile();
	}
}
