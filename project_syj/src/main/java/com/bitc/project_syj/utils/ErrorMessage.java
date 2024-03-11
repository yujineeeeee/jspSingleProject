package com.bitc.project_syj.utils;

public class ErrorMessage {

    public static void printErrorMessage(String userMsg, String errMSg) {
        System.out.println("\n*****************************************\n");
        System.out.println("데이터 베이스 " + userMsg + " 중 오류가 발생했습니다.");
        System.out.println("오류 내용 : " + errMSg);
        System.out.println("\n*****************************************\n");
    }
}
