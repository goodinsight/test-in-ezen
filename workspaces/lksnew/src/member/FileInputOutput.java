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
		// ���Ͽ��� �л� ���� �ҷ��ͼ� �ʱ� �����ϱ�
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
		// ���Ͽ� �ִ� ������ �о� ����Ʈ
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
		// �߰��� �л� ������ �߰��л��������Ͽ� �����ϱ�
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(addFileName, true));
			bw.write("���� �л��� �߰��Ͽ����ϴ�.");
			bw.write("�л� �̸� : " + s.getName() + ", ");
			bw.write("�л� ���� : " + s.getAge() + ", ");
			bw.write("�л� �й� : " + s.getStudentNum() + ", ");
			bw.write("�л� ���� : " + s.getMajor());
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
		// ������ �л� ������ ���Ͽ� �����ϱ�
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
		// ���� �л�����(�ν��Ͻ�)�� ���Ͽ� �����ϱ�
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
		// �л� ������ ���Ͽ� �����ϱ�
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
		// �л� ������ ���Ͽ��� �����
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
