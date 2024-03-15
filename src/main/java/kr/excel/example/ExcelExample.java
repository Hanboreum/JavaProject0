package kr.excel.example;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelExample {
    public static void main(String[] args) {
        try{//엑셀 파일을 파일 객체로 생성, 파일 인풋 스트림과 연결, 파일 이라는 객체로 파일 읽음
            FileInputStream file = new FileInputStream(new File("example.xlsx"));
            //메모리에 가상의 엑셀을 만들어야 함. 가상의 엑셀을 workbook 이라고 함
            Workbook workbook = WorkbookFactory.create(file);
           //workbook에서 sheet를 가져온다.
            Sheet sheet = workbook.getSheetAt(0);
            for(Row row : sheet){ //sheet에서 하나의 row를 가져오고
                for(Cell cell : row){ //row에서 cell을 가져온다
                    System.out.print(cell.toString()+ "\t");
                }
                System.out.println(); //cell출력 후 줄 바꿈.
            }
            file.close(); //stream close
            System.out.println(" 엑셀에서 데이터 읽어오기 성공");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
