/**
 * @description: OOP-Opject Oriented Programming
 * @author: Le Khai Minh
 * @version 1.0
 * @created Sep 3, 2025 12:28:30 AM
 */
package main.java.iuh.fit.se;

import java.util.*;				//Khai báo thư viện java.util để làm việc với danh sách mảng

public class CourseList {
//--Attribute--
	private int count = 0;		//Số lượng khóa học hiện có
	private Course[] courses; 	//Khai báo mảng chứa các khóa học
//--Constructor--
	public CourseList (int capacity) { //Cấp phát sức chứa cho mảng nếu bé hơn không thì nhập lại
		if (capacity < 0) {
			throw new IllegalArgumentException("Không đủ sức chứa cho mảng (Sức chứa phải > 0");
		}
		else {
			courses = new Course[capacity]; //Nếu điều kiện đúng thì tạo 1 mảng với kích thước capacity
		}
	}
//--Property Get--
	public Course[] getCourses () {
		return Arrays.copyOf(courses, count);
	}
//--Method--
//--Thêm khóa học
	public boolean addCourse (Course c) {
		if (c == null) return false; //Nếu môn học được nhập vào bằng null thì sai
		if (exists(c)) { //Nếu môn 
			System.out.println("Khóa học này đã tồn tại: " + c.getId());
			return false;
		}
		if (count == courses.length) {
			System.out.println("Danh sách khóa học đã đầy");
			return false;
		}
		else {
			courses[count++] = c;
			return true;
		}
	}
//--Kiểm tra khóa học có tồn tại hay chưa
	private boolean exists(Course c) {
		for (int i=0; i<count; i++) {
			if (courses[i].getId().equalsIgnoreCase(c.getId())) { //So sánh xem có ID nào bị trùng hay không
				return true; //.equalsIgnoreCase: So sánh không phân biệt chữ thường hay chữ hoa
			}
		}
		return false;
	}
//--Tìm khoa nào có nhiều khóa học nhất
	// Xóa khóa học theo id
    public boolean removeCourse(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                // dịch trái các phần tử
                for (int j = i; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[--count] = null;
                return true;
            }
        }
        System.out.println("❌ Không tìm thấy khóa học để xóa: " + id);
        return false;
    }

    // Tìm khóa học theo id
    public Course searchCourseById(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                return courses[i];
            }
        }
        return null;
    }

    // Tìm kiếm theo tên (tương đối)
    public Course[] searchCourse(String keyword) {
        ArrayList<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(courses[i]);
            }
        }
        return result.isEmpty() ? null : result.toArray(new Course[0]);
    }

    // Tìm kiếm theo khoa
    public Course[] searchCourseByDepartment(String dep) {
        ArrayList<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(dep)) {
                result.add(courses[i]);
            }
        }
        return result.isEmpty() ? null : result.toArray(new Course[0]);
    }

    // Sắp xếp theo tên (không ảnh hưởng danh sách gốc)
    public Course[] sortCourses() {
        Course[] sorted = Arrays.copyOf(courses, count);
        Arrays.sort(sorted, Comparator.comparing(Course::getTitle));
        return sorted;
    }

    // Tìm khóa học có số tín chỉ lớn nhất
    public Course[] findMaxCreditCourses() {
        if (count == 0) return null;
        int maxCredit = courses[0].getCredit();
        for (int i = 1; i < count; i++) {
            if (courses[i].getCredit() > maxCredit) {
                maxCredit = courses[i].getCredit();
            }
        }
        ArrayList<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == maxCredit) {
                result.add(courses[i]);
            }
        }
        return result.toArray(new Course[0]);
    }

    // Tìm khoa có nhiều khóa học nhất
    public String findDepartmentWithMostCourses() {
        if (count == 0) return null;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            map.put(courses[i].getDepartment(), map.getOrDefault(courses[i].getDepartment(), 0) + 1);
        }
        String depMax = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                depMax = entry.getKey();
            }
        }
        return depMax;
    }

    // In danh sách dạng bảng
    public void printCourses(Course[] list) {
        if (list == null || list.length == 0) {
            System.out.println("❌ Không có khóa học nào.");
            return;
        }
        System.out.printf("%-10s %-20s %-10s %-15s%n", "ID", "Title", "Credit", "Department");
        for (Course c : list) {
            System.out.printf("%-10s %-20s %-10d %-15s%n", c.getId(), c.getTitle(), c.getCredit(), c.getDepartment());
        }
    }

	
}
