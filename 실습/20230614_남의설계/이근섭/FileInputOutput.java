package member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputOutput {
	String FileName = "student.txt";
	String addFileName = "addstudent.txt";
	String removeFileName = "studentExpel.txt";

	public List<Student> init() {
		// 파일에서 학생 정보 불러와서 초기 세팅하기
		List<Student> list = new ArrayList<>();
		BufferedReader br;
		Student s;
		try {
			br = new BufferedReader(new FileReader(FileName));
			while (true) {
				String data = br.readLine();
				if (data == null)
					break;
				String[] tmp = data.split(",");
				s = new Student(tmp[0].trim(), tmp[1].trim(), tmp[2].trim(), tmp[3].trim());
				list.add(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public void readFile(String filename) {
		// 파일에 있는 내용을 읽어 프린트
		BufferedReader br = null;
		Student s = null;

		try {
			br = new BufferedReader(new FileReader(filename));
			while (true) {
				String data = br.readLine();
				if (data == null)
					break;
				String[] tmp = data.split(",");
				s = new Student(tmp[0].trim(), tmp[1].trim(), tmp[2].trim(), tmp[3].trim());
				System.out.println(s.toString());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void addStudentInfor(Student s) {
		// 추가된 학생 정보를 추가학생정보파일에 저장하기
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(addFileName, true));
			bw.write("다음 학생을 추가하였습니다.");
			bw.write("학생 이름 : " + s.getName() + ", ");
			bw.write("학생 나이 : " + s.getAge() + ", ");
			bw.write("학생 학번 : " + s.getStudentNum() + ", ");
			bw.write("학생 전공 : " + s.getMajor());
			bw.newLine();

			updateStudent(s);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeStudentInfor(Student s) {
		// 삭제한 학생 정보를 파일에 저장하기
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(removeFileName, true));
			bw.write(s.getName() + ",");
			bw.write(s.getAge() + ",");
			bw.write(s.getStudentNum() + ",");
			bw.write(s.getMajor());
			bw.newLine();
			
			removeStudent(s);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void saveStudentInfor(List<Student> list) {
		// 현재 학생정보(인스턴스)를 파일에 저장하기
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(FileName));
			for(Student s : list) {
				bw.write(s.getName() + ",");
				bw.write(s.getAge() + ",");
				bw.write(s.getStudentNum() + ",");
				bw.write(s.getMajor());
				bw.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateStudent(Student s) {
		// 학생 정보를 파일에 저장하기
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(FileName, true));
			bw.write(s.getName() + ",");
			bw.write(s.getAge() + ",");
			bw.write(s.getStudentNum() + ",");
			bw.write(s.getMajor());
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void removeStudent(Student student) {
		// 학생 정보를 파일에서 지우기
		BufferedReader br = null;
		BufferedWriter bw = null;
		Student s = null;
		List<Student> list = null;
		String check = student.getStudentNum();

		try {
			br = new BufferedReader(new FileReader(FileName));
			list = new ArrayList<Student>();
			while (true) {
				String data = br.readLine();
				if (data == null)
					break;
				String[] tmp = data.split(",");
				s = new Student(tmp[0].trim(), tmp[1].trim(), tmp[2].trim(), tmp[3].trim());
				if(!tmp[2].equals(check))
					list.add(s);
			}
			bw = new BufferedWriter(new FileWriter(FileName));
			for(Student str : list) {
				bw.write(str.getName() + ",");
				bw.write(str.getAge() + ",");
				bw.write(str.getStudentNum() + ",");
				bw.write(str.getMajor());
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
