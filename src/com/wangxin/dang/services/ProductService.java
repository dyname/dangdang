package com.wangxin.dang.services;

import java.util.List;

import com.wangxin.dang.pojos.Book;
import com.wangxin.dang.pojos.Category;
import com.wangxin.dang.pojos.DoubleCategory;
import com.wangxin.dang.pojos.Product;

public interface ProductService {
	public List<Product> findNewProduct(int topSize) throws Exception;
	
	public List<Product> findHotProduct(int hotSize) throws Exception;
	
	public List<DoubleCategory> findAllCategory() throws Exception;
	
	public List<Book> findOnePageOfBook(int categoryId,int pageNumber,int pageSize) throws Exception;

	public  int findTotalPageOfBook(int categoryId) throws Exception;
	
	public List<Book> findOnePageOfBookChild(int categoryId,int pageNumber,int pageSize) throws Exception;

	public  int findTotalPageOfBookChild(int categoryId) throws Exception;
	
	public List<Category> findChildCategoryList(int categoryId) throws Exception; 
	
	public List<Category> findParentCategoryList(int categoryId) throws Exception; 
	
}
