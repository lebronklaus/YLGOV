package cn.nwsuaf.gov.teacherManage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

//用来转换pdf到swf文件
public class TestPdfToSwf {
	public static int convertPDF2SWF(String sourcePath, String destPath,
			String fileName) throws IOException {
		// 目标路径不存在则建立目标路径
		File dest = new File(destPath);
		if (!dest.exists())
			dest.mkdirs();

		// 源文件不存在则返回
		File source = new File(sourcePath);
		if (!source.exists())
			return 0;

		// 调用pdf2swf命令进行转换
		String command = "C:\\Program Files (x86)\\SWFTools\\pdf2swf.exe"
				+ " "
				+"-b "
				+ sourcePath
				+ " -o "
				+ destPath
				+ fileName
				+ "   -s  languagedir=C:\\xpdf\\xpdf-chinese-simplified";
		Process pro = Runtime.getRuntime().exec(command);
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(pro.getInputStream()));
		while (bufferedReader.readLine() != null)
			;
		try {
			pro.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		 String command1 = "C:\\Program Files (x86)\\SWFTools\\swfcombine.exe \"C:/Program Files (x86)/SWFTools/swfs/rfxview.swf\" viewport="
		  +destPath + fileName +" -o "+destPath + fileName+"";
		 Process pro1 =Runtime.getRuntime().exec(command1);
		 BufferedReader bufferedReader1 =new BufferedReader( new InputStreamReader(pro1.getInputStream()));
		  while (bufferedReader1.readLine() != null); try { pro1.waitFor(); }
		  catch (InterruptedException e) { e.printStackTrace(); }
		  System.out.println(command1);
		  
		  String command2 = "C:\\Program Files (x86)\\SWFTools\\swfbbox.exe -h "+destPath+fileName;
		  Process pro2 = Runtime.getRuntime().exec(command2);
		  BufferedReader bufferedReader2 =new BufferedReader( new InputStreamReader(pro2.getInputStream()));
		  while (bufferedReader2.readLine() != null); try { pro2.waitFor(); }
		  catch (InterruptedException e) { e.printStackTrace(); }
		  System.out.println(command2);
		 return pro.exitValue();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sourcePath = "D:\\citationrecommendation.pdf"; // 源文件路径
		String destPath = "D:\\"; // 目标路径
		String fileName = "citationrecommendation.swf"; // 生成文件名
		try {
			TestPdfToSwf.convertPDF2SWF(sourcePath, destPath, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}