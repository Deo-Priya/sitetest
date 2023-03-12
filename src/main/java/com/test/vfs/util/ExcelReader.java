package com.test.vfs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.vfs.dto.Applicant;

public class ExcelReader {

	private final Logger log;

	public ExcelReader() {
		System.setProperty("log.name", this.getClass().getSimpleName() + "_" + Constants.BROWSER);
		log = LoggerFactory.getLogger(this.getClass().getSimpleName() + "_" + Constants.BROWSER);
	}

	public List<Applicant> readExcel() {
		log.debug("Reading Excel File: {}", Constants.EXCEL_FILE_PATH);
		//Path path = Paths.get(Constants.EXCEL_FILE_PATH);
		//URL fileUrl = this.getClass().getClassLoader().getResource(Constants.EXCEL_FILE_PATH);
		try (FileInputStream is = new FileInputStream(new File(Constants.EXCEL_FILE_PATH));) {
			try (Workbook wb = new XSSFWorkbook(is);) {
				return readWorkbook(wb);
			}
		} catch (IOException e) {
			log.error("Error while reading applicants data from excel {}:", Constants.EXCEL_FILE_PATH, e);
		}
		return null;
	}

	private List<Applicant> readWorkbook(Workbook wb) {
		Sheet sheet = wb.getSheetAt(0);
		List<Applicant> applicants = new ArrayList<>();
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			String name = getCellValue(row.getCell(1));
			String passportNo = getCellValue(row.getCell(2));
			String dob = getCellValue(row.getCell(3));
			String issueDate = getCellValue(row.getCell(4));
			String expireDate = getCellValue(row.getCell(5));
			Applicant applicant = new Applicant(name, passportNo, dob, issueDate, expireDate, false);
			applicants.add(applicant);
		}
		log.info("Total {} applicants loaded from excel file, detail: {}",applicants.size(), applicants);
		return applicants;
	}

	private String getCellValue(Cell cell) {
		if (cell != null) {
			return cell.toString();
		}
		return StringUtils.EMPTY;
	}

}