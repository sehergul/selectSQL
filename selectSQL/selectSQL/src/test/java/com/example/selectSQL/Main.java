package com.example.selectSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.dbHelper.DbHelper;

public class Main {

	public static void main(String[] args) {
		
		Connection connection = null;
		DbHelper dbHelper = new DbHelper();
		Statement statement = null;
		ResultSet resultSet;
		
		try {
			connection = dbHelper.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select id,ad,soyad,sehir,meslek,bakiye from musteri");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("ad"));
			}
		
		}catch(SQLException sqlException) {
			dbHelper.showErrorMessage(sqlException);
		}finally {
			try {
				connection.close(); //eger dosya bulunamadiysa kapanmaz
				//o yuzden try- catch blogu icine alinir ya da throws SQLException
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
