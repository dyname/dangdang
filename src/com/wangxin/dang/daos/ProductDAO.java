package com.wangxin.dang.daos;

import java.util.List;

import com.wangxin.dang.pojos.Book;
import com.wangxin.dang.pojos.Category;
import com.wangxin.dang.pojos.Product;

public interface ProductDAO {
	
	/**
	 * 查询最新上架信息
	 * @return 最新上架产品集合
	 * @throws Exception
	 */
	public List<Product> findNewProduct(int topSize) throws Exception; 
	
	public List<Product> findHotProduct(int hotSize) throws Exception;
	
	public List<Category> findAllChildCategoryById(int categoryId) throws Exception;
	
	public List<Book> findOnePageOfBook(int categoryId,int startNumber,int pageSize) throws Exception;

	public int findTotalPageOfBook(int category) throws Exception;
	
	public List<Book> findOnePageOfBookChild(int categoryId,int startNumber,int pageSize) throws Exception;

	public int findTotalPageOfBookChild(int category) throws Exception;
	
	public List<Category> findChildCategoryList(int categoryId) throws Exception;

	public List<Category> findParentCategoryList(int categoryId) throws Exception;
	
}
