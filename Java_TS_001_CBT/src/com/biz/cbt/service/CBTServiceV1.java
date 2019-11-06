package com.biz.cbt.service;

import java.util.Scanner;

import com.biz.cbt.config.DBConnection;
import com.biz.cbt.dao.CBTDao;

public class CBTServiceV1 {

	protected CBTDao dao;
	protected Scanner scan;
	
	public CBTServiceV1() {
		dao = DBConnection
				.getSqlSessionFactory()
				.openSession(true)
				.getMapper(CBTDao.class);
		scan = new Scanner(System.in);
	}
	
	public void Menu() {
		System.out.println("=========================");
		System.out.println("1.문제입력  2.문제풀이  0.종료");
		System.out.println("=========================");
		System.out.print("선택 >> ");
		String strMenu = scan.nextLine();
		int intMenu = Integer.valueOf(strMenu);
		
	}
}
