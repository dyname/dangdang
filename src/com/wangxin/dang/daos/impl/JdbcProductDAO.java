package com.wangxin.dang.daos.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wangxin.dang.daos.ProductDAO;
import com.wangxin.dang.pojos.Book;
import com.wangxin.dang.pojos.Category;
import com.wangxin.dang.pojos.Product;
import com.wangxin.dang.utils.DbUtil;

public class JdbcProductDAO implements ProductDAO {

	//查找最新上架
	private static final String findNewProduct=
			"select * from d_product  where has_deleted=0 order by add_time limit ?";
	
	//查找热卖产品
	private static final String findHotProduct=
			"select * from d_product ";
	
	//找到所有的分类
	private static final String findAllChildCategoryById=
			"select * from d_category where parent_id=?";
	
	//找到某个类型id对应的一个页面书籍的信息
	private static final String findOnePageOfBook=
			"select * from(" +
			"select d_product.id ,d_product.product_name," +
			"d_product.fixed_price,d_product.dang_price ,d_product.product_pic , " +
			"d_book.author,d_book.publishing," +
			"d_book.publish_time,d_book.catalogue " +
			"from d_product join  d_book  where d_product.id=d_book.id) M " +
			"where id in (" +
			"select product_id from d_category_product where cat_id = ?)" +
			" limit ?,?";
	
	private static final String findTotalPageOfBook=
			"select count(*) from(" +
			"select d_product.id "+
			"from d_product join  d_book  where d_product.id=d_book.id) M " +
			"where id in (" +
			"select product_id from d_category_product where cat_id = ?)";
	
	private static final String findOnePageOfBookChild=
			"select * from(" +
			"select d_product.id ,d_product.product_name," +
			"d_product.fixed_price,d_product.dang_price ,d_product.product_pic , " +
			"d_book.author,d_book.publishing," +
			"d_book.publish_time,d_book.catalogue " +
			"from d_product join  d_book  where d_product.id=d_book.id) M " +
			"where id in (" +
			"select product_id from d_category_product where cat_id = ?)" +
			" limit ?,?";
	
	private static final String findTotalPageOfBookChild=
			"select count(*) from(" +
			"select d_product.id "+
			"from d_product join  d_book  where d_product.id=d_book.id) M " +
			"where id in (" +
			"select product_id from d_category_product where cat_id = ?)";
	
	private static final String findChildCategoryList=
			"SELECT id,en_name,name,description,product_id,count(*) as total "+
			"FROM (SELECT d_category.id,d_category.en_name,d_category.name,d_category.description,"+
			"d_category_product.product_id from d_category JOIN d_category_product "+ 
			"WHERE d_category.id=d_category_product.cat_id) M"+
			"GROUP BY id ";
	
	private static final String find1="select * from d_category where parent_id=?";
	
	private static final String find2="select count(*) as total from d_category_product where cat_id=?";
	
	private static final String find3="select parent_id from d_category where id=?";
	
	public List<Product> findNewProduct(int topSize) throws Exception {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(findNewProduct);
		stmt.setInt(1,topSize);
		ResultSet rs=stmt.executeQuery();
		List<Product> productList=new ArrayList<Product>();
		while(rs.next()){
			productList.add(parseProduce(rs));
		}
		return productList;
		
	}
	
	public Product parseProduce(ResultSet rs) throws Exception{
		Product product=new Product();
		product.setId(Integer.parseInt(rs.getString("id")));
		product.setAddTime(rs.getLong("add_time"));
		product.setDangPrice(rs.getDouble("dang_price"));
		product.setDescription(rs.getString("description"));
		product.setFixedPrice(rs.getDouble("fixed_price"));
		product.setHasDeleted(0);
		product.setKeyWords(rs.getString("keywords"));
		product.setProductName(rs.getString("product_name"));
		product.setProductPic(rs.getString("product_pic"));
		return product;
	}


	public List<Product> findHotProduct(int hotSize) throws Exception {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(findNewProduct);
		stmt.setInt(1,hotSize);
		ResultSet rs=stmt.executeQuery();
		List<Product> productList=new ArrayList<Product>();
		while(rs.next()){
			productList.add(parseProduce(rs));
		}
		return productList;
	}
	
	public static void main(String[] args) throws Exception {
		JdbcProductDAO dao=new JdbcProductDAO();
		System.out.println(dao.findAllChildCategoryById(1).toString());
	}

	public List<Category> findAllChildCategoryById(int categoryId)
			throws Exception {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(findAllChildCategoryById);
		stmt.setInt(1,categoryId);
		ResultSet rs=stmt.executeQuery();
		List<Category> categoryList=new ArrayList<Category>();
		while(rs.next()){
			categoryList.add(parseCategory(rs));
		}
		return categoryList;
	}

	private Category parseCategory(ResultSet rs) throws Exception {
		Category category=new Category();
		category.setEnName(rs.getString("en_name"));
		category.setId(rs.getInt("id"));
		category.setName(rs.getString("name"));
		category.setParentId(rs.getInt("parent_id"));
		category.setDescription(rs.getString("description"));
		return category;
	}

	public List<Book> findOnePageOfBook(int categoryId, int startNumber,
			int pageSize) throws Exception {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(findOnePageOfBook);
		stmt.setInt(1,categoryId);
		stmt.setInt(2,startNumber);
		stmt.setInt(3,pageSize);
		ResultSet rs=stmt.executeQuery();
		List<Book> onePageOfBookList=new ArrayList<Book>();
		while(rs.next()){
			onePageOfBookList.add(parseBook(rs));
		}
		return onePageOfBookList;
	}

	private Book parseBook(ResultSet rs) throws Exception {
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		Book book=new Book();
		book.setId(rs.getInt("id"));
		book.setBookName(rs.getString("product_name"));
		book.setProductName(rs.getString("product_name"));
		book.setFixedPrice(rs.getDouble("fixed_price"));
		book.setDangPrice(rs.getDouble("dang_price"));
		book.setAuthor(rs.getString("author"));
		book.setPublishing(rs.getString("publishing"));
		date.setTime(rs.getLong("publish_time"));
		book.setPublishingDate(format.format(date));
		book.setDescription(rs.getString("catalogue"));
		book.setProductPic(rs.getString("product_pic"));
		book.setCha(book.getFixedPrice()-book.getDangPrice());
		return book;
	}

	public int findTotalPageOfBook(int categoryId) throws Exception {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(findTotalPageOfBook);
		stmt.setInt(1,categoryId);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}
	
	public List<Book> findOnePageOfBookChild(int categoryId, int startNumber,
			int pageSize) throws Exception {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(findOnePageOfBookChild);
		stmt.setInt(1,categoryId);
		stmt.setInt(2,startNumber);
		stmt.setInt(3,pageSize);
		ResultSet rs=stmt.executeQuery();
		List<Book> onePageOfBookList=new ArrayList<Book>();
		while(rs.next()){
			onePageOfBookList.add(parseBook(rs));
		}
		return onePageOfBookList;
	}
	
	public int findTotalPageOfBookChild(int categoryId) throws Exception {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(findTotalPageOfBookChild);
		stmt.setInt(1,categoryId);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}
	
	public int findTotal(int categoryId) throws Exception{
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(find2);
		stmt.setInt(1,categoryId);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
		
	}

	public int findParentId(int categoryId) throws Exception{
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(find3);
		stmt.setInt(1,categoryId);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
		
	}
	
	public List<Category> findChildCategoryList(int categoryId) throws Exception {
		PreparedStatement stmt=DbUtil.getConnection().prepareStatement(find1);
		stmt.setInt(1, categoryId);
		ResultSet rs=stmt.executeQuery();
		List<Category> childCateList=new ArrayList<Category>();
		while(rs.next()){
			childCateList.add(parseCategory(rs));
		}
		for(int i=0;i<childCateList.size();i++){
			int id=childCateList.get(i).getId();
			int total=findTotal(id);
			childCateList.get(i).setTotal(total);
		}
		return childCateList;
	}

	public List<Category> findParentCategoryList(int categoryId)
			throws Exception {
		//先找到该子类的父类，在通过父类找到他的子类
		categoryId=findParentId(categoryId);
		return findChildCategoryList(categoryId);
	}
}
