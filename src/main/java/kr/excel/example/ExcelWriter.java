package kr.excel.example;

import kr.excel.entity.MemberVO;

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
                break;
            }
            System.out.println("age");
            int age = sc.nextInt();
            sc.nextLine(); //개행 문자 제거

            System.out.println("birthday");
            String birthday = sc.nextLine();

            System.out.println("Married Y/N");
            boolean isMarried = sc.nextBoolean();
            sc.nextLine();

            MemberVO member = new MemberVO(name,age,birthday,isMarried);
            members.add(member);
        }
        sc.close();

    }
}
