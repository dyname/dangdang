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
		//���ҵ�ͼ������������е�����
		List<Category> parentCategory=productDao.findAllChildCategoryById(Constant.CATEGORY_BOOK);
		//�Եõ��ĸ����е�ÿ��Ԫ�ؽ��е���
		List<DoubleCategory> allCategories=new ArrayList<DoubleCategory>();
		for(int i=0;i<parentCategory.size();i++){
			//����ÿһ�������࣬�ҵ�ÿһ���ӷ���
			DoubleCategory doubleCategory=new DoubleCategory();
			doubleCategory.setCategoryOwn(parentCategory.get(i));
			//�õ���ǰ������ڵ��id
			int parentId=parentCategory.get(i).getId();
			//����ǰ������ڵ�Ķ����������Ԫ�ر�������
			doubleCategory.setCategoryList(productDao.findAllChildCategoryById(parentId));
			allCategories.add(doubleCategory);
		}
		return allCategories;
	}

	public List<Book> findOnePageOfBook(int categoryId,int pageNumber,int pageSize) throws Exception {
		//�õ��鼮����Ϣ����Ҫͨ���鼮������id���Ҷ�Ӧ��������Ӧ����Ʒ��id����Щ
		//��ͨ����Ʒ��id,��������d_book���d_product��,�õ���Ӧ�������Ϣ
		
		//���ҵ����鼮���Ͷ�Ӧ����Ʒid����Щ,���ֻҪ��һ��pageSize��
		//�õ���ֹ���
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
		//�õ��鼮����Ϣ����Ҫͨ���鼮������id���Ҷ�Ӧ��������Ӧ����Ʒ��id����Щ
		//��ͨ����Ʒ��id,��������d_book���d_product��,�õ���Ӧ�������Ϣ
		//���ҵ����鼮���Ͷ�Ӧ����Ʒid����Щ,���ֻҪ��һ��pageSize��
		//�õ���ֹ���
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
