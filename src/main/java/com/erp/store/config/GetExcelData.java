package com.erp.store.config;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class GetExcelData {

	
	public static Set<StoreExcelData> excelToUnit(InputStream io) {
		try {

			Workbook workbook = new XSSFWorkbook(io);
			Sheet sheet = workbook.getSheetAt(0);

			sheet.iterator();
			Iterator<Row> rows = sheet.iterator();


			Set<StoreExcelData> StoreExceldataList = new HashSet<>();

			int rownumber = 0;

			while (rows.hasNext()) {

				Row currentRow = rows.next();

				if (rownumber == 0) {

					rownumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				StoreExcelData storeExcelData = new StoreExcelData();
				int cellIdx = 0;

				while (cellsInRow.hasNext()) {

					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {

					case 0:
						storeExcelData.setUnitname(currentCell.getStringCellValue());
						break;
					case 1:
						storeExcelData.setStatus(currentCell.getBooleanCellValue());

						break;
					case 2:
						storeExcelData.setDiscription(currentCell.getStringCellValue());

						break;
					case 3:
						storeExcelData.setType(currentCell.getStringCellValue());

						break;
					case 4:
						storeExcelData.setConversionid((double)currentCell.getNumericCellValue());

						break;
					case 5:
						storeExcelData.setConversionValue(currentCell.getStringCellValue());
						break;

					default:
						break;
					}
					cellIdx++;
				}
				StoreExceldataList.add(storeExcelData);
			}
			workbook.close();
			return StoreExceldataList;
		} catch (Exception e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());		}
	}

}
