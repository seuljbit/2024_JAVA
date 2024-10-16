package jdbc;

import java.util.List;

public class ProductServiceImpl implements Service {
	/* service <-> DAO
	 * 생성자로 DAO 객체와 연결 */
	
	private DAO dao; // interface
	
	public ProductServiceImpl() {
		dao = new ProductDAOImpl();
	}

	@Override
	public int insert(Product p) {
		// 실제 구현 영역
		System.out.println("상품 등록 serviceImpl 성공!");
		
		// DAO에게 DB 저장을 요청
		// 일반적으로 DAO 요청 시 메서드명은 SQL 구문과 비슷하게 작성함
		
		return dao.insert(p);
	}

	@Override
	public List<Product> getList() {
		System.out.println("list serviceImpl 성공!");
		return dao.selectList();
	}

	@Override
	public Product getProduct(int pno) {
		System.out.println("성공!");
		return dao.selectProduct(pno);
	}

	@Override
	public int update(Product p) {
		System.out.println("update serviceImpl 성공!");
		return dao.update(p);
	}

	@Override
	public int delete(int pno) {
	    return dao.delete(pno);
	}
}
