package com.book.general;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
/**
 * ��ȡ����:��ȡ�����ƫ����,��¼Ϊ��ǩλ��,��ȡ���ȹ̶�
 * @author Administrator
 *
 */
public class LocalOperationService {

	public static String getMd5ByFile(File file) throws FileNotFoundException {
		String value = null;
		FileInputStream in = new FileInputStream(file);
		try {
			MappedByteBuffer byteBuffer = in.getChannel().map(
					FileChannel.MapMode.READ_ONLY, 0, file.length());
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(byteBuffer);
			BigInteger bi = new BigInteger(1, md5.digest());
			value = bi.toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	/**
	 * ����������ϲ�
	 * 
	 * @param args
	 */
	public static void ttt(String[] args) throws IOException {
		// д���ļ���·��
		String filePath = "D:\\456";
		// �з��ļ���·��
		String sqlitFilePath = "D:\\456\\123";
		// ���ݵĸ���
		int CountNumbers = 10000000;

		// ���ļ��ĸ���
		int CountFile = 10;

		// ����
		int countAccuracy = 30 * CountFile;

		long startNumber = System.currentTimeMillis();
		// д��������ļ�
		WriteData(filePath, CountNumbers);
		System.out.println("�洢���");

		// ���������ļ��зֵ������ʮ��С�ļ���
		sqlitFileDate(filePath, sqlitFilePath, CountFile);
		System.out.println("�ļ��и���ϣ�");
		// ��ÿ���ļ������ݽ�������
		singleFileDataSort(sqlitFilePath, CountFile);
		System.out.println("ÿ�����ļ�������ϣ�");

		// ���ȵ�����ʮ���ļ����ݽ��бȽ�����
		deathDataFile(filePath, sqlitFilePath, countAccuracy, CountFile);
		System.out.println("�������");
		long stopNumber = System.currentTimeMillis();
		System.out.println("��ʱ" + (stopNumber - startNumber) / 1000 + "����");
	}

	// д��������ļ�
	public static void WriteData(String path, int CountNumbers)
			throws IOException {
		path = path + "\\12114.txt";
		FileWriter fs = new FileWriter(path);
		BufferedWriter fw = new BufferedWriter(fs);
		for (int i = 0; i < CountNumbers; i++) {
			fw.write(new Random().nextInt(Integer.MAX_VALUE) + "\r\n");
		}
		fw.close();
		fs.close();

	}

	// ���������ļ��зֵ������ʮ��С�ļ���
	public static void sqlitFileDate(String filepath, String sqlitPath,
			int CountFile) throws IOException {
		FileWriter fs = null;
		BufferedWriter fw = null;
		FileReader fr = new FileReader(filepath + "\\12114.txt");
		BufferedReader br = new BufferedReader(fr); // ��ȡ��ȡ��������

		int i = 1;
		LinkedList WriterLists = new LinkedList(); // ��ʼ���ļ������󼯺�
		LinkedList fwLists = new LinkedList();
		for (int j = 1; j <= CountFile; j++) {

			// ��������
			fs = new FileWriter(sqlitPath + "\\12" + j + ".txt", false);
			fw = new BufferedWriter(fs);

			// ������װ�뼯��
			WriterLists.add(fs);
			fwLists.add(fw);
		}
		// �ж����ļ������Ƿ������ݷ���
		while (br.ready()) {

			int count = 1;// ��ʼ����һ�ļ���
			for (Iterator iterator = fwLists.iterator(); iterator.hasNext();) {
				BufferedWriter type = (BufferedWriter) iterator.next();
				if (i == count)// �ж��ֵ��ڼ����ļ���д��������
				{
					// д�����ݣ�������������һ���ļ�������һ�����ݵ�д��
					type.write(br.readLine() + "\r\n");
					break;
				}
				count++;
			}
			// �ж��Ƿ������һ���ļ�����
			if (i >= CountFile) {
				i = 1;
			} else
				i++;
		}
		br.close();
		fr.close();
		for (Iterator iterator = fwLists.iterator(); iterator.hasNext();) {
			BufferedWriter object = (BufferedWriter) iterator.next();
			object.close();
		}
		// �����ر��������ļ���
		for (Iterator iterator = WriterLists.iterator(); iterator.hasNext();) {
			FileWriter object = (FileWriter) iterator.next();
			object.close();
		}
	}

	// ��ÿ���ļ������ݽ�������
	public static void singleFileDataSort(String path1, int CountFile)
			throws IOException {
		LinkedList nums = null;
		for (int i = 1; i <= CountFile; i++) {
			nums = new LinkedList();
			String path = path1 + "\\12" + i + ".txt";
			try {
				FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr);
				while (br.ready()) {
					// ����ȡ�ĵ������ݼ��뵽��������
					nums.add(Integer.parseInt(br.readLine()));
				}
				// �Լ��Ͻ�������
				Collections.sort(nums);
				// ������õ�����д��Դ�ļ�
				numberSort(nums, path);
				br.close();
				fr.close();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// ��ÿ���ļ����ݽ���������д��Դ�ļ�
	public static void numberSort(LinkedList list, String path) {
		try {
			FileWriter fs = new FileWriter(path);
			BufferedWriter fw = new BufferedWriter(fs);
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				fw.write(object + "\r\n");
			}
			fw.close();
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// �ļ�������������(���ȵ���)
	@SuppressWarnings("unchecked")
	public static void deathDataFile(String filepath, String sqlitFilePath1,
			int countAccuracy, int CountFile) throws IOException {
		LinkedList nums = new LinkedList(); // ������ݣ���������
		Object temp = null; // ��¼ÿ������ʣ�µ����һ������
		boolean ispass = false;
		LinkedList ispasses = null; // ��¼�����ļ���״̬��Ϣ
		FileWriter fs = new FileWriter(filepath + "\\Sort.txt", false); // �����ļ������Ա����ϵ�����д��
		BufferedWriter bw = new BufferedWriter(fs);
		FileReader fr = null; // ������ȡ�ļ���
		BufferedReader br = null; // ����BufferedReader
		LinkedList WriterLists = new LinkedList(); // ��ʼ���ļ������󼯺�
		LinkedList WriterListFile = new LinkedList();
		for (int j = 1; j <= CountFile; j++) {
			// �������󣬿����������ļ��������������ļ�������
			fr = new FileReader(sqlitFilePath1 + "\\12" + j + ".txt");

			// ��������BufferedReader�������´ε����еĶ�ȡ
			br = new BufferedReader(fr);

			// ������ FileReader����װ�뼯��
			WriterListFile.add(fr);

			// ������ BufferedReader����װ�뼯��
			WriterLists.add(br);
		}
		for (;;) {
			// ��ʮ��Դ�ļ����Ƿ�������������뼯�ϣ��Է���������ж�
			ispasses = new LinkedList();

			// �ֱ��ȡʮ��Դ�ļ��ĵ�������
			for (Iterator iterator = WriterLists.iterator(); iterator.hasNext();) {
				BufferedReader object = (BufferedReader) iterator.next();
				Object obj = null;
				while (object.ready()) {
					// ��������ļ�����ÿ�ε�����
					nums.add(Integer.parseInt(object.readLine().toString()));
					break;
				}
				if (object.ready() == false)
					ispasses.add("true"); // �����ļ��е�����״̬���뼯����
			}

			// �����Ƿ��ǵ�һ�ν���
			if (nums.size() % countAccuracy == 0 && ispass == false) {
				// �Լ��Ͻ�������
				Collections.sort(nums);
				// �����������ݣ�����������д���������ļ�
				temp = numberSortData(nums, filepath, false, countAccuracy, bw);

				// ���³�ʼ������
				nums = new LinkedList();
				// �����һ��Ƚ�ʣ�µ�����
				nums.add(temp);
				ispass = true;
				// ��¼Դ�ļ��������������Ա��´εı���
				continue;
			}
			if (ispass) {
				if (nums.size() % countAccuracy == 1 && nums.size() > 1) {
					// �Լ��Ͻ�������
					Collections.sort(nums);
					// �����������ݣ�����������д���������ļ�
					temp = numberSortData(nums, filepath, true, countAccuracy,
							bw);
					nums = new LinkedList();
					nums.add(temp);
					continue;
				}
			}
			// ��¼��һ�����ݵ�λ��
			// �ж��ǲ���ʮ���ļ���û������
			if (ispasses.size() == CountFile) {
				Collections.sort(nums);
				temp = numberSortData(nums, filepath, true, countAccuracy, bw);
				nums = new LinkedList();
				break;
			}
		}
		bw.close();
		// �ر�д����
		fs.close();

		// �ر����е�BufferedReader
		for (Iterator iterator = WriterLists.iterator(); iterator.hasNext();) {
			BufferedReader object2 = (BufferedReader) iterator.next();
			object2.close();
		}

		// �ر����е�FileReader
		for (Iterator iterator = WriterListFile.iterator(); iterator.hasNext();) {
			FileReader object = (FileReader) iterator.next();
			object.close();
		}
	}

	// �����ݽ�������,д�������ļ���(���ȵ���)
	public static Object numberSortData(LinkedList list, String filePath,
			boolean ispass, int countAccuracy, BufferedWriter fs) {
		Object temp = 0; // ��¼���һ��ֵ
		int tempCount = 0; // ��¼д�������λ��
		try {
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				// �ж��Ƿ������һ����
				if (tempCount == list.size() - 1) {
					// �жϼ������治��һ�ق�����
					if (list.size() < countAccuracy + 1 && ispass) {
						temp = null;
					} else {
						temp = object;
						break;
					}
				}
				// д������Դ
				fs.write(object + "\r\n");
				// ��¼���ݵ��±�
				tempCount++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}

}
