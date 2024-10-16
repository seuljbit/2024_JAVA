package jdbc;

import java.sql.*;
import java.util.*;

public class ProductDAOImpl implements DAO {
	// DAO <-> DB

	private Connection conn; // DB 연결 객체
	private PreparedStatement pst; // SQL 구문을 실행시키는 기능을 가진 객체
	private String query = ""; // 쿼리문 저장 스트링

	public ProductDAOImpl() {
		// DBConnection Class 생성(싱글톤) 연결
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}

	@Override // SQL 처리
	public int insert(Product p) {
		// product 객체를 등록하고 isOk를 리턴
		System.out.println("insert DAOImpl 성공!");
		
		query = "insert into product(pname, price, madeby) values(?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			// ? : 반드시 순서대로 처리(자료형을 기재) 1부터 시작
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			
			// INSERT, UPDATE, DELETE -> // 처리만.. (1 row(s) affected)
			// 결과의 행(low) 수만 리턴 -> executeUpdate(); ---> int 리턴  
			// select -> 목록 -> executeQuery(); ---> 표를 ResultSet 로 리턴
			
			return pst.executeUpdate();
		} catch (SQLException e) { // insert error
			System.out.println("insert error!");
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List<Product> selectList() {
		// DB에서 리스트 가져와서 리턴
		System.out.println("list DAOImpl 성공!");
		query = "select * from product order by pno desc";
		List<Product> list = new ArrayList<>();
		
		try {  
			pst = conn.prepareStatement(query); 
			ResultSet rs = pst.executeQuery(); // select -> 목록 -> executeQuery(); ---> 표를 ResultSet 로 리턴
			
			while(rs.next()) { // ResultSet -> List 변환(pno, pname, price)
				list.add(new Product(rs.getInt("pno"), rs.getString("pname"),
						rs.getInt("price"), rs.getString("regdate"),
						rs.getString("madeby")));
			}
			return list;
			
		} catch (SQLException e) {
			System.out.println("list error!");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public Product selectProduct(int pno) {
		System.out.println("product DAOImpl 성공!");
		query = "select * from product where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Product p = new Product(
						rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby")
				);
				return p;
			}
		} catch (SQLException e) {
			System.out.println("product error!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(Product p) {
		System.out.println("update DAOImpl 성공!");
		query = "update product set pname = ?, "
				+ "price = ?, madeby = ?, regdate = now() where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			pst.setInt(4, p.getPno());
			
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update error!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int pno) {
	    String query = "delete from product where pno = ?";
	    try {
	        pst = conn.prepareStatement(query);
	        pst.setInt(1, pno);
	        
	        return pst.executeUpdate(); 
	    } catch (SQLException e) {
	        System.out.println("delete error!");
	        e.printStackTrace();
	    }
	    return 0;
	}
}