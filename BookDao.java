package com.book.practice;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.book.practice.DB;

public class BookDao {
public static int save(String SerialNo,String BookName,String TypeOfBooK,String DateOfCollection,String Price, String Category, int Priority){
	int status=0;
	try{
		Connection con=DB.getConnection();
//		id, SerialNo, BookName, TypeOfBook, DateOfCollection, Price, Category, Priority
		PreparedStatement ps=con.prepareStatement("insert into books (SerialNo,BookName,TypeOfBook,DateOfCollection,Price,Category,Priority) values(?,?,?,?,?,?,?)");
		ps.setString(1,SerialNo);
		ps.setString(2,BookName);
		ps.setString(3,TypeOfBooK);
		ps.setString(4,DateOfCollection);
		ps.setString(5,Price);
		ps.setString(6,Category);
		ps.setInt(7,Priority);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
