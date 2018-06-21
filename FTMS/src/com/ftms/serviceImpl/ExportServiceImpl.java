package com.ftms.serviceImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.struts2.ServletActionContext;

import com.ftms.service.ExportService;

public class ExportServiceImpl implements ExportService {

	@Override
	public String export(List export) throws Exception {
		// TODO Auto-generated method stub
		String[] tableHeader = { "账号", "密码", "姓名", "性别", "身份证号", "生日", "电话",
				"学历", "专业1级分类", "专业2级分类", "等级", "发证日期", "省", "市", "县", "地址",
				"证书编号", "笔试成绩", "面试成绩", "总成绩" };
		short cellNumber = (short) tableHeader.length;// 表的列数
		HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel
		HSSFCell cell = null; // Excel的列
		HSSFRow row = null; // Excel的行
		HSSFCellStyle style = workbook.createCellStyle(); // 设置表头的类型
		style.setAlignment(CellStyle.ALIGN_CENTER);
		HSSFCellStyle style1 = workbook.createCellStyle(); // 设置数据类型
		style1.setAlignment(CellStyle.ALIGN_CENTER);
		HSSFFont font = workbook.createFont(); // 设置字体
		HSSFSheet sheet = workbook.createSheet("sheet1"); // 创建一个sheet
		HSSFHeader header = sheet.getHeader();// 设置sheet的头

		try {
			/**
			 * 根据是否取出数据，设置header信息
			 * 
			 */
			if (export.size() < 1) {
				header.setCenter("查无资料");
			} else {
				header.setCenter("结果");
				row = sheet.createRow(0);
				row.setHeight((short) 400);
				for (int k = 0; k < cellNumber; k++) {
					cell = row.createCell(k);// 创建第0行第k列
					cell.setCellValue(tableHeader[k]);// 设置第0行第k列的值
					sheet.setColumnWidth(k, 8000);// 设置列的宽度
					font.setColor(Font.COLOR_NORMAL); // 设置单元格字体的颜色.
					font.setFontHeight((short) 350); // 设置单元字体高度
					style1.setFont(font);// 设置字体风格
					cell.setCellStyle(style1);
				}
				/*
				 * // 给excel填充数据这里需要编写
				 */
				Iterator iter = export.iterator();
				int i=0;
				while(iter.hasNext()){
					Object[] data = (Object[]) iter.next();
					row = sheet.createRow((short) (i + 1));// 创建第i+1行
					row.setHeight((short) 400);// 设置行高
					if (data[0] != null) {
						cell = row.createCell(0);// 创建第i+1行第0列
						cell.setCellValue((String) data[0]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[4] != null) {
						cell = row.createCell(1);// 创建第i+1行第0列
						cell.setCellValue((String)data[4]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[1] != null) {
						cell = row.createCell(2);// 创建第i+1行第0列
						cell.setCellValue((String) data[1]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[2] != null) {
						cell = row.createCell(3);// 创建第i+1行第0列
						cell.setCellValue((String) data[2]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[7] != null) {
						cell = row.createCell(4);// 创建第i+1行第0列
						cell.setCellValue((String) data[7]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[3] != null) {
						cell = row.createCell(5);// 创建第i+1行第0列
						cell.setCellValue(data[3].toString());// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[5] != null) {
						cell = row.createCell(6);// 创建第i+1行第0列
						cell.setCellValue((String) data[5]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[6] != null) {
						cell = row.createCell(7);// 创建第i+1行第0列
						cell.setCellValue((String) data[6]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[8] != null) {
						cell = row.createCell(8);// 创建第i+1行第0列
						cell.setCellValue((String) data[8]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[9] != null) {
						cell = row.createCell(9);// 创建第i+1行第0列
						cell.setCellValue((String) data[9]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					
					if (data[15] != null) {
						cell = row.createCell(10);// 创建第i+1行第0列
						cell.setCellValue((String) data[15]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[14] != null) {
						cell = row.createCell(11);// 创建第i+1行第0列
						cell.setCellValue(data[14].toString());// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[10] != null) {
						cell = row.createCell(12);// 创建第i+1行第0列
						cell.setCellValue((String) data[10]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[11] != null) {
						cell = row.createCell(13);// 创建第i+1行第0列
						cell.setCellValue((String) data[11]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[12]!= null) {
						cell = row.createCell(14);// 创建第i+1行第0列
						cell.setCellValue((String) data[12]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[13] != null) {
						cell = row.createCell(15);// 创建第i+1行第0列
						cell.setCellValue((String) data[13]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[19] != null) {
						cell = row.createCell(16);// 创建第i+1行第0列
						cell.setCellValue((String) data[19]);// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (data[16] != null) {
						cell = row.createCell(17);// 创建第i+1行第0列
						cell.setCellValue(data[16].toString());// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}if (data[17] != null) {
						cell = row.createCell(18);// 创建第i+1行第0列
						cell.setCellValue(data[17].toString());// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}if (data[18] != null) {
						cell = row.createCell(19);// 创建第i+1行第0列
						cell.setCellValue(data[18].toString());// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					i++;
				}
//				for (int i = 0; i < export.size(); i++) {
//					Results result1 = (Results) export.get(i);
//					row = sheet.createRow((short) (i + 1));// 创建第i+1行
//					row.setHeight((short) 400);// 设置行高
//					if (result1.getUser().getUsername() != null) {
//						cell = row.createCell(0);// 创建第i+1行第0列
//						cell.setCellValue(result1.getUser().getUsername());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getUser().getPassword() != null) {
//						cell = row.createCell(1);// 创建第i+1行第0列
//						cell.setCellValue(result1.getUser().getPassword());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getUser().getName() != null) {
//						cell = row.createCell(2);// 创建第i+1行第0列
//						cell.setCellValue(result1.getUser().getName());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getUser().getGender() != null) {
//						cell = row.createCell(3);// 创建第i+1行第0列
//						cell.setCellValue(result1.getUser().getGender());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getUser().getIdnumber() != null) {
//						cell = row.createCell(4);// 创建第i+1行第0列
//						cell.setCellValue(result1.getUser().getIdnumber());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getUser().getBirthday() != null) {
//						cell = row.createCell(5);// 创建第i+1行第0列
//						cell.setCellValue(result1.getUser().getBirthday().toString());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getUser().getPhone() != null) {
//						cell = row.createCell(6);// 创建第i+1行第0列
//						cell.setCellValue(result1.getUser().getPhone());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getUser().getEducation() != null) {
//						cell = row.createCell(7);// 创建第i+1行第0列
//						cell.setCellValue(result1.getUser().getEducation());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if(result1.getUser().getProf2()!= null){
//						if (result1.getUser().getProf2().getProf1() != null) {
//							cell = row.createCell(8);// 创建第i+1行第0列
//							cell.setCellValue(result1.getUser().getProf2().getProf1().getName());// 设置第i+1行第0列的值
//							cell.setCellStyle(style);// 设置风格
//						}
//							cell = row.createCell(9);// 创建第i+1行第0列
//							cell.setCellValue(result1.getUser().getProf2().getName());// 设置第i+1行第0列的值
//							cell.setCellStyle(style);// 设置风格
//					}
//					
//					if (result1.getLevel() != null) {
//						cell = row.createCell(10);// 创建第i+1行第0列
//						cell.setCellValue(result1.getLevel());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getFazhengtime() != null) {
//						cell = row.createCell(11);// 创建第i+1行第0列
//						cell.setCellValue(result1.getFazhengtime().toString());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getUser().getJPositionProvice() != null) {
//						cell = row.createCell(12);// 创建第i+1行第0列
//						cell.setCellValue(result1.getUser().getJPositionProvice().getProviceName());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getUser().getJPositionCity() != null) {
//						cell = row.createCell(13);// 创建第i+1行第0列
//						cell.setCellValue(result1.getUser().getJPositionCity().getCityName());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getUser().getJPositionCounty() != null) {
//						cell = row.createCell(14);// 创建第i+1行第0列
//						cell.setCellValue(result1.getUser().getJPositionCounty().getCountyName());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getUser().getJPositionTown() != null) {
//						cell = row.createCell(15);// 创建第i+1行第0列
//						cell.setCellValue(result1.getUser().getJPositionTown().getTownName());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getNumber() != null) {
//						cell = row.createCell(16);// 创建第i+1行第0列
//						cell.setCellValue(result1.getNumber());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//					if (result1.getWritescore() != null) {
//						cell = row.createCell(17);// 创建第i+1行第0列
//						cell.setCellValue(result1.getWritescore());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}if (result1.getInterviewscore() != null) {
//						cell = row.createCell(18);// 创建第i+1行第0列
//						cell.setCellValue(result1.getInterviewscore());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}if (result1.getTotalscore() != null) {
//						cell = row.createCell(19);// 创建第i+1行第0列
//						cell.setCellValue(result1.getTotalscore());// 设置第i+1行第0列的值
//						cell.setCellStyle(style);// 设置风格
//					}
//				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpServletResponse response = null;//创建一个HttpServletResponse对象 
		OutputStream out = null;//创建一个输出流对象 
		try { 
		response = ServletActionContext.getResponse();//初始化HttpServletResponse对象 
		out = response.getOutputStream();// 
		        response.setHeader("Content-disposition","attachment; filename="+"result.xls");//filename是下载的xls的名，建议最好用英文 
		        response.setContentType("application/msexcel;charset=UTF-8");//设置类型 
		        response.setHeader("Pragma","No-cache");//设置头 
		        response.setHeader("Cache-Control","no-cache");//设置头 
		        response.setDateHeader("Expires", 0);//设置日期头 
		        workbook.write(out); 
		        out.flush(); 
		workbook.write(out); 
		} catch (IOException e) { 
		e.printStackTrace(); 
		}finally{ 
		try{ 

		if(out!=null){ 
		out.close(); 
		} 

		}catch(IOException e){ 
		e.printStackTrace(); 
		} 

		} 
		return null;
	}

}
