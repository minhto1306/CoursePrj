/**
 * @description: OOP-Opject Oriented Programming
 * @author: Le Khai Minh
 * @version 1.0
 * @created Sep 3, 2025 12:28:43 AM
 */
package main.java.iuh.fit.se;

public class Course {
//--Attribute--
	private String id;			//Chỉ chứa kí tự chữ hoặc số và có ít nhất 3 kí tự (id<=3)
	private String title;		//Không được để trống
	private int credit;			//Số tín chỉ phải lớn hơn 0 (credit>0)
	private String department;	//Khoa phụ trách số tín chỉ và không được để trống
//--Method--
//--Constructor--
	public Course (String id, String title, int credit, String department) {
	}
//--Property getters and setters-- 
//Lấy giá trị và gán giá trị thuộc tính
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if (id != null && id.matches("[A-Za-z0-9]{3,}")) { //id.matches: Kiểm tra có đủ điều kiện không
			this.id = id;
		}
		else {
			throw new IllegalArgumentException("Mã khóa học phải chứa ít nhất 3 ký tự chữ hoặc số");
		}
	}
//--
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if (title != null && !title.trim().isEmpty()) { //Nếu tên môn học khác NULL và Chuỗi tên môn học không để trống thì điều kiện đúng
			this.title = title;
		}
		else {
			throw new IllegalArgumentException("Tên môn học không được để trống");
		}
	}
//--
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		if (credit>0) {
			this.credit = credit;
		}
		else {
			throw new IllegalArgumentException("Số tín chỉ phải lớn hơn 0");
		}
	}
//--
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		if (department != null && !department.trim().isEmpty()) {
			this.department = department;
		}
		else {
			throw new IllegalArgumentException("Tên khoa không được để trống");
		}
	}
	
}
