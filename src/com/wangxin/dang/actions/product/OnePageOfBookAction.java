package com.wangxin.dang.actions.product;

import java.util.List;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.pojos.Book;
import com.wangxin.dang.pojos.Category;
import com.wangxin.dang.services.ProductService;
import com.wangxin.dang.services.impl.ProductServiceImpl;

public class OnePageOfBookAction extends BaseAction{
	
	//Ҫ����ҳ����鱾����Ϣ
	private List<Book> onePageOfBook;
	//ÿҳ��ʾ�鱾����
	private int pageSize;
	//��ǰ�ڵڼ�ҳ
	private int pageNumber=0;
	//�������͵��鹲�ж���
	private int totalPage;
	//Ҫ���ҵ��Ķ�Ӧ���͵�id
	private int categoryId;
	//����
	private int childCategoryId;
	//Ҫ���ݵĶ�Ӧ������͵�������
	private List<Category> childCategoryList;
	
	
	private ProductService service=new ProductServiceImpl(); 
	
	//��һҳ
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
			//�жϵ�ǰ��Ҫ��ҳ����������������Χ��
			//��Ҫ��ҳ������ܵ�ҳ����
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
	
	//��һҳ
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
	
	//��ʼ��
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
