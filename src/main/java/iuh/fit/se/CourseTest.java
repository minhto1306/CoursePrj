/**
 * @description: OOP-Opject Oriented Programming
 * @author: Le Khai Minh
 * @version 1.0
 * @created Sep 3, 2025 12:28:53 AM
 */
package main.java.iuh.fit.se;

import java.util.Scanner;

public class CourseTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	        CourseList list = new CourseList(100);

	        while (true) {
	            System.out.println("\n===== MENU =====");
	            System.out.println("1. Thêm khóa học");
	            System.out.println("2. Xóa khóa học");
	            System.out.println("3. Tìm khóa học theo ID");
	            System.out.println("4. Tìm khóa học theo tên");
	            System.out.println("5. Tìm khóa học theo khoa");
	            System.out.println("6. Sắp xếp theo tên");
	            System.out.println("7. Khóa học có tín chỉ lớn nhất");
	            System.out.println("8. Khoa có nhiều khóa học nhất");
	            System.out.println("9. In danh sách tất cả khóa học");
	            System.out.println("0. Thoát");
	            System.out.print("Chọn: ");

	            int choice = sc.nextInt();
	            sc.nextLine(); // bỏ dòng thừa

	            switch (choice) {
	                case 1:
	                    System.out.print("ID: ");
	                    String id = sc.nextLine();
	                    System.out.print("Tên: ");
	                    String title = sc.nextLine();
	                    System.out.print("Số tín chỉ: ");
	                    int credit = sc.nextInt(); sc.nextLine();
	                    System.out.print("Khoa: ");
	                    String dep = sc.nextLine();
	                    try {
	                        Course c = new Course(id, title, credit, dep);
	                        list.addCourse(c);
	                    } catch (Exception e) {
	                        System.out.println(e.getMessage());
	                    }
	                    break;
	                case 2:
	                    System.out.print("Nhập ID cần xóa: ");
	                    String idDel = sc.nextLine();
	                    list.removeCourse(idDel);
	                    break;
	                case 3:
	                    System.out.print("Nhập ID: ");
	                    String idFind = sc.nextLine();
	                    Course c = list.searchCourseById(idFind);
	                    if (c != null) list.printCourses(new Course[]{c});
	                    else System.out.println("Không tìm thấy");
	                    break;
	                case 4:
	                    System.out.print("Nhập tên: ");
	                    String keyword = sc.nextLine();
	                    list.printCourses(list.searchCourse(keyword));
	                    break;
	                case 5:
	                    System.out.print("Nhập khoa: ");
	                    String d = sc.nextLine();
	                    list.printCourses(list.searchCourseByDepartment(d));
	                    break;
	                case 6:
	                    list.printCourses(list.sortCourses());
	                    break;
	                case 7:
	                    list.printCourses(list.findMaxCreditCourses());
	                    break;
	                case 8:
	                    System.out.println("Khoa nhiều khóa học nhất: " + list.findDepartmentWithMostCourses());
	                    break;
	                case 9:
	                    list.printCourses(list.getCourses());
	                    break;
	                case 0:
	                    sc.close();
	                    return;
	                default:
	                    System.out.println("Lựa chọn không hợp lệ.");
	            }
	        }
	    }
	}


