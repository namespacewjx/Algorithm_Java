package io.github.packagewjx.algorithm.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/25.
 * https://www.nowcoder.com/pat/6/problem/4041
 */
public class DeCaiLun {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Student.L = in.nextInt();
		Student.H = in.nextInt();

		int count = 0;
		ArrayList<Student> students = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			int no = in.nextInt();
			int de = in.nextInt();
			int cai = in.nextInt();
			Student student = new Student(no, de, cai);
			if (student.Class == Student.SHI_BAI)
				continue;
			students.add(student);
			count++;
		}
		Collections.sort(students);

		System.out.println(count);
		for (Student student : students) {
			System.out.println(student.no + " " + student.de + " " + student.cai);
		}
	}
}

class Student implements Comparable<Student> {
	public static final int CAI_DE_QUAN_JIN = 1;
	public static final int DE_SHENG_CAI = 2;
	public static final int CAI_DE_JIAN_WANG_DE_SHENG_CAI = 3;
	public static final int JI_GE = 4;
	public static final int SHI_BAI = 5;

	public static int L;
	public static int H;

	int no;
	int de;
	int cai;
	int sum;
	int Class;

	public Student(int no, int de, int cai) {
		this.no = no;
		this.de = de;
		this.cai = cai;
		sum = de + cai;

		//判断这个考生的类别
		if (de >= H) {
			if (cai >= H)
				Class = CAI_DE_QUAN_JIN;
			else if (cai >= L)
				Class = DE_SHENG_CAI;
			else
				Class = SHI_BAI;
		} else {
			if (cai >= L){
				if (de >= cai)
					Class = CAI_DE_JIAN_WANG_DE_SHENG_CAI;
				else if (de >= L)
					Class = JI_GE;
				else
					Class = SHI_BAI;
			} else
				Class = SHI_BAI;
		}
	}

	@Override
	public int compareTo(Student o) {
		if (Class < o.Class)
			return -1;
		else if (Class > o.Class)
			return 1;
		else {
			if (sum == o.sum) {
				if (de == o.de) {
					return no - o.no;
				} else
					return o.de - de;
			}
			return o.sum - sum;
		}
	}
}
