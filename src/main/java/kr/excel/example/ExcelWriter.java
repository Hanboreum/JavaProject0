package kr.excel.example;

import kr.excel.entity.MemberVO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcelWriter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MemberVO> members = new ArrayList<>();

        while(true){
            System.out.println("name");
            String name = sc.nextLine();
            if(name.equals("quit")){
               // System.exit(-1); //quit 를 입력하면 시스템이 바로 끝나게
                break;
            }
            System.out.println("age");
            int age = sc.nextInt();
            sc.nextLine(); //개행 문자 제거

            System.out.println("birthday");
            String birthday = sc.nextLine();

            System.out.println("Married true/false");
            boolean isMarried = sc.nextBoolean();
            sc.nextLine();

            MemberVO member = new MemberVO(name,age,birthday,isMarried);
            members.add(member);
        }
        sc.close();

        try{
            //엑셀과 관련된 라이브러리
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("회원 정보");

            //header
            Row headerrow = sheet.createRow(0);
            headerrow.createCell(0).setCellValue("name");
            headerrow.createCell(1).setCellValue("age");
            headerrow.createCell(2).setCellValue("birthday");
            headerrow.createCell(3).setCellValue("married");

            for(int i=0; i< members.size(); i++){
                MemberVO member = members.get(i);
                Row row = sheet.createRow(i +1);
                row.createCell(0).setCellValue(member.getName());
                row.createCell(1).setCellValue(member.getAge());
                row.createCell(2).setCellValue(member.getBirthday());
                Cell marriedCell = row.createCell(5);
                marriedCell.setCellValue(member.isMarried());
            }

            //엑셀 파일 저장
            String filename = "members.xlsx";
            FileOutputStream outputStream = new FileOutputStream(new File(filename));
            workbook.write(outputStream);
            workbook.close();
            System.out.println("엑셀 파일 저장 되었습니다." + filename);
        }catch (IOException e){
            System.out.println("엑셀 파일 저장 중 오류 발생");
            e.printStackTrace();
        }
    }
}
//더 이상 입력을 원하지 않으면 quit