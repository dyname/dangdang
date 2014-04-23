package com.wangxin.dang.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.wangxin.dang.daos.ProductDAO;
import com.wangxin.dang.daos.impl.JdbcProductDAO;
import com.wangxin.dang.pojos.Book;
import com.wangxin.dang.pojos.Category;
import com.wangxin.dang.pojos.DoubleCategory;
import com.wangxin.dang.pojos.Product;
import com.wangxin.dang.services.ProductService;
import com.wangxin.dang.utils.Constant;

public class ProductServiceImpl implements ProductService{

	private ProductDAO productDao=new JdbcProductDAO();
	
	public List<Product> findNewProduct(int topSize) throws Exception {
		return productDao.findNewProduct(topSize);
	}

	public List<Product> findHotProduct(int hotSize) throws Exception {
		return productDao.findHotProduct(hotSize);
	}

	public List<DoubleCategory> findAllCategory() throws Exception {
		//先找到图书的这个类的所有的子类
		List<Category> parentCategory=productDao.findAllChildCategoryById(Constant.CATEGORY_BOOK);
		//对得到的父类中的每个元素进行迭代
		List<DoubleCategory> allCategories=new ArrayList<DoubleCategory>();
		for(int i=0;i<parentCategory.size();i++){
			//对于每一个父分类，找到每一个子分类
			DoubleCategory doubleCategory=new DoubleCategory();
			doubleCategory.setCategoryOwn(parentCategory.get(i));
			//得到当前这个父节点的id
			int parentId=parentCategory.get(i).getId();
			//将当前这个父节点的对象的所有子元素遍历出来
			doubleCategory.setCategoryList(productDao.findAllChildCategoryById(parentId));
			allCategories.add(doubleCategory);
		}
		return allCategories;
	}

	public List<Book> findOnePageOfBook(int categoryId,int pageNumber,int pageSize) throws Exception {
		//得到书籍的信息，需要通过书籍的类型id查找对应类型所对应的商品的id有哪些
		//在通过商品的id,查找整合d_book表和d_product表,得到对应的书的信息
		
		//先找到该书籍类型对应的商品id有哪些,结果只要在一个pageSize内
		//得到起止编号
		int startNumber=(pageNumber-1)*pageSize;
		//
		//System.out.println("service:");
		//System.out.println("category:"+categoryId);
		//System.out.println("startNumber:"+startNumber);
		//System.out.println("pagesize:"+pageSize);
		
		List<Book> onePageOfBookList=productDao.findOnePageOfBook(categoryId, startNumber, pageSize);
		
		return onePageOfBookList;
	}

	public int findTotalPageOfBook(int categoryId) throws Exception {
		return productDao.findTotalPageOfBook(categoryId);
	}
	
	public List<Book> findOnePageOfBookChild(int categoryId,int pageNumber,int pageSize) throws Exception {
		//得到书籍的信息，需要通过书籍的类型id查找对应类型所对应的商品的id有哪些
		//在通过商品的id,查找整合d_book表和d_product表,得到对应的书的信息
		//先找到该书籍类型对应的商品id有哪些,结果只要在一个pageSize内
		//得到起止编号
		int startNumber=(pageNumber-1)*pageSize;
		
		//System.out.println("child service:");
		//System.out.println("child category:"+categoryId);
		//System.out.println("child startNumber:"+startNumber);
		//System.out.println("child pagesize:"+pageSize);
		
		List<Book> onePageOfBookList=productDao.findOnePageOfBookChild(categoryId, startNumber, pageSize);
		
		return onePageOfBookList;
	}

	public int findTotalPageOfBookChild(int categoryId) throws Exception {
		return productDao.findTotalPageOfBookChild(categoryId);
	}

	public List<Category> findChildCategoryList(int categoryId) throws Exception {
		return productDao.findChildCategoryList(categoryId);
	}

	public List<Category> findParentCategoryList(int categoryId)
			throws Exception {
		
		return productDao.findParentCategoryList(categoryId);
	}
	
	public static void main(String[] args) throws Exception {
		ProductServiceImpl service=new ProductServiceImpl();
		ProductDAO dao=new JdbcProductDAO();
//		for(Book book:service.findOnePageOfBook(9,2,5)){
//			System.out.println(book.getId()+book.toString());
//		}
		//System.out.println("service total:"+service.findTotalPageOfBook(9));
		System.out.println(service.findParentCategoryList(9).toString());
	}
}
