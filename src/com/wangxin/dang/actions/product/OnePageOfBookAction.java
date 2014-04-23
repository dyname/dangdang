package com.wangxin.dang.actions.product;

import java.util.List;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.pojos.Book;
import com.wangxin.dang.pojos.Category;
import com.wangxin.dang.services.ProductService;
import com.wangxin.dang.services.impl.ProductServiceImpl;

public class OnePageOfBookAction extends BaseAction{
	
	//要传给页面的书本的信息
	private List<Book> onePageOfBook;
	//每页显示书本个数
	private int pageSize;
	//当前在第几页
	private int pageNumber=0;
	//这种类型的书共有多少
	private int totalPage;
	//要查找到的对应类型的id
	private int categoryId;
	//子类
	private int childCategoryId;
	//要传递的对应这个类型的子类型
	private List<Category> childCategoryList;
	
	
	private ProductService service=new ProductServiceImpl(); 
	
	//下一页
	public String next(){
		try {
			System.out.println("pageSize:"+pageSize);
			System.out.println("pageNumber:"+pageNumber);
			System.out.println("categoryId:"+categoryId);
			pageNumber++;
			int total=service.findTotalPageOfBook(categoryId);
			if(total%pageSize==0){
				totalPage=total/pageSize;
			}else{
				totalPage=total/pageSize+1;
			}
			//判断当前需要的页面是在数据正常范围内
			//需要的页面大于总的页面数
			if(pageNumber>totalPage){
				pageNumber--;
			}
			onePageOfBook=service.findOnePageOfBook(categoryId, pageNumber, pageSize);
			childCategoryList=service.findParentCategoryList(childCategoryId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	//上一页
	public String ahead(){
		System.out.println("categoryId:"+categoryId);
		try {
			pageNumber--;
			int total=service.findTotalPageOfBook(categoryId);
			if(total%pageSize==0){
				totalPage=total/pageSize;
			}else{
				totalPage=total/pageSize+1;
			}
			if((pageNumber-1)<=0){
				pageNumber=1;
			}
			onePageOfBook=service.findOnePageOfBook(categoryId, pageNumber, pageSize);
			childCategoryList=service.findParentCategoryList(childCategoryId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	//初始化
	public String execute(){
		System.out.println("categoryId:"+categoryId);
		try {
			int total=service.findTotalPageOfBook(categoryId);
			if(total%pageSize==0){
				totalPage=total/pageSize;
			}else{
				totalPage=total/pageSize+1;
			}
			pageNumber=1;
			onePageOfBook=service.findOnePageOfBook(categoryId, pageNumber, pageSize);
			childCategoryList=service.findChildCategoryList(categoryId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	public List<Book> getOnePageOfBook() {
		return onePageOfBook;
	}

	public void setOnePageOfBook(List<Book> onePageOfBook) {
		this.onePageOfBook = onePageOfBook;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Category> getChildCategoryList() {
		return childCategoryList;
	}

	public void setChildCategoryList(List<Category> childCategoryList) {
		this.childCategoryList = childCategoryList;
	}

	public int getChildCategoryId() {
		return childCategoryId;
	}

	public void setChildCategoryId(int childCategoryId) {
		this.childCategoryId = childCategoryId;
	}	
	
}
