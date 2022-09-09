package homework.day03;

import java.io.*;
import java.util.Scanner;

/**
 * 改错
 * 
 * 程序实现的是简易记事本工具。程序启动后向pw.txt文件写内容
 * 用户输入的每一行字符串都写入到文件中，单独输入exit时
 * 程序退出。
 * 
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("pw.txt");//创建一个文件输出流,并输入文件路径
		OutputStreamWriter osw = new OutputStreamWriter(fos);//创建一个转换输出流,将内容转换成字节
		BufferedWriter bw = new BufferedWriter(osw);//创建一个缓冲字符输出流
		PrintWriter pw = new PrintWriter(bw);//创建字符输出流,按行写出字符串

		Scanner scanner = new Scanner(System.in);//创建一个扫描仪
		System.out.println("请开始输入内容");
		while(true) {
			String str = scanner.nextLine();//将用户输入的内容转化成字符串
			if("exit".equals(str)) { //如果输入exit则退出while循环
				break;
			}
			pw.println(str);//若内容非exit,则写入文件
		}
		pw.close();//关闭输出流,注意关流的位置
	}
}
