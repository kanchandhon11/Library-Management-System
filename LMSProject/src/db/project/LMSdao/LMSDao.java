package db.project.LMSdao;
import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

import db.project.model.Book;
import db.project.util.DatabaseConnect;
public class LMSDao {
			Connection con = DatabaseConnect.connect();
			public List<Book> getAllRecords(){
				List<Book> Book = new ArrayList<>();
				try {
				Statement stat = con.createStatement();
				ResultSet rs = stat.executeQuery
						("select * from Book");
				
				while(rs.next()){
					Book s = new Book();
					s.setId(rs.getInt("ID"));
					s.setTITLE(rs.getString("TITLE"));
					s.setAUTHOR(rs.getString("AUTHOR"));
					s.setGENRE(rs.getString("GENRE"));
					Book.add(s);
					
				}
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
					return Book;
								
			}
			
			public Book searchById(int id) {
				Book s = null;			
			try {
				PreparedStatement ps =
						con.prepareStatement
						("Select * from Book where id = ?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				s= new Book();
				rs.next();
				s.setId(rs.getInt("Id"));
				s.setTITLE(rs.getString("TITLE"));
				s.setAUTHOR(rs.getString("AUTHOR"));
				s.setGENRE(rs.getString("GENRE"));			
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
				
				return s;
		}
			public boolean insertRecord(int ID,String TITLE,String AUTHOR, String GENRE)
			{
				String sql = "insert into Book values(?,?,?,?)";
				
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, ID);	
					ps.setString(2, TITLE);
					ps.setString(3, AUTHOR);
					ps.setString(4,GENRE);
					int i = ps.executeUpdate();
					if (i>0)
						return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return false;			
			}
			public boolean deleteRecord(int id) {
				String sql = "delete from book where ID=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					int i = ps.executeUpdate();
					if (i>0)
						return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
			public boolean updateRecord(Book b) {
				String sql= "update book set TITLE =?,AUTHOR=?,GENRE=? where ID=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1,b.getTITLE());
					ps.setString(2, b.getAUTHOR());
					ps.setString(3, b.getGENRE());
					ps.setInt(4, b.getId());
					int i= ps.executeUpdate();
					if(i>0)
						return true;				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
												
				return false;
				
			}
	}


