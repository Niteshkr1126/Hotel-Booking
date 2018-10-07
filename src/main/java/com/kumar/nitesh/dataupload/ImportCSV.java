package com.kumar.nitesh.dataupload;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ImportCSV {
	private static final String CSV_FILE_PATH = "./hotels.csv";

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		readCSV();
	}

	private static void readCSV() throws IOException, ClassNotFoundException, SQLException {
		int i=0;
		try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
				CSVParser csvParser = new CSVParser(reader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			Connection connection = DBConnection.getConnection();
			String insertQuery = "INSERT INTO Hotels (id, address, categories, city, country, latitude, longitude, name, postalcode, province, reviews_rating, reviews_text, reviews_title, reviews_username) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(insertQuery);
			for (CSVRecord csvRecord : csvParser) {
				pstmt.setString(1,csvRecord.get("id"));
				pstmt.setString(2,csvRecord.get("address"));
				pstmt.setString(3,csvRecord.get("categories"));
				pstmt.setString(4,csvRecord.get("city"));
				pstmt.setString(5,csvRecord.get("country"));
				pstmt.setString(6,csvRecord.get("latitude"));
				pstmt.setString(7,csvRecord.get("longitude"));
				pstmt.setString(8,csvRecord.get("name"));
				pstmt.setString(9,csvRecord.get("postalCode"));
				pstmt.setString(10,csvRecord.get("province"));
				pstmt.setString(11,csvRecord.get("reviews.rating"));
				pstmt.setString(12,csvRecord.get("reviews.text"));
				pstmt.setString(13,csvRecord.get("reviews.title"));
				pstmt.setString(14,csvRecord.get("reviews.username"));
				System.out.println(pstmt);
				pstmt.addBatch();
				i++;
				if(i%25==0) {
					pstmt.executeBatch();
				}
			}
			pstmt.executeBatch();
		}
	}
}
