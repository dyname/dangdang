package com.wangxin.dang.actions.product;

import java.util.List;

import com.wangxin.dang.actions.BaseAction;
import com.wangxin.dang.pojos.Book;
import com.wangxin.dang.pojos.Category;
import com.wangxin.dang.services.ProductService;
import com.wangxin.dang.services.impl.ProductServiceImpl;

public class OnePageOfBookChildAction extends BaseAction{
		
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
		//Ҫ���ݵĶ�Ӧ������͵�������
		private List<Category> childCategoryList;
		
		private ProductService service=new ProductServiceImpl(); 
		
		
		//��ʼ��
		public String execute(){
			System.out.println("categoryId:"+categoryId);
			try {
				int total=service.findTotalPageOfBookChild(categoryId);
				if(total%pageSize==0){
					totalPage=total/pageSize;
				}else{
					totalPage=total/pageSize+1;
				}
				pageNumber=1;
				onePageOfBook=service.findOnePageOfBookChild(categoryId, pageNumber, pageSize);
				childCategoryList=service.findParentCategoryList(categoryId);
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
		
}
