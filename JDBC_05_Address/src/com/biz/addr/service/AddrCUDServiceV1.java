package com.biz.addr.service;

import java.util.Scanner;

import com.biz.addr.persistence.AddrDTO;
import com.biz.addr.persistence.dao.AddrDao;
import com.biz.addr.persistence.dao.AddrDaoImp;

public class AddrCUDServiceV1 {

	private AddrServiceV1 as = null;
	private AddrDao addrDao = null;
	private Scanner scanner = null;
	
	public AddrCUDServiceV1() {
		as = new AddrServiceV1();
		scanner = new Scanner(System.in);
		addrDao = new AddrDaoImp();
	}
	
	public void inputAddr() {
		
		while(true) {
			
			System.out.println("==================");
			System.out.println("주소록 입력");
			System.out.println("==================");
			
			String strName = null;
			while(true) {
				System.out.print("1.이름(-Q:quit) >> ");
				strName = scanner.nextLine();
				if(strName.equals("-Q")) break;
				if(strName.isEmpty()) {
					System.out.println("이름은 반드시 입력하세요");
					continue;
				}
				break;
			}
			if(strName.equals("-Q")) break;
			
			System.out.print("2.전화번호(-Q:quit) >> ");
			String strTel = scanner.nextLine();
			if (strTel.equals("-Q")) break;

			System.out.print("3.주소(-Q:quit) >> ");
			String strAddr = scanner.nextLine();
			if (strAddr.equals("-Q")) break;
			
			System.out.print("4.관계(-Q:quit) >> ");
			String strChain = scanner.nextLine();
			if (strChain.equals("-Q")) break;
			
			
			AddrDTO addrDTO = AddrDTO.builder()
							.name(strName)
							.tel(strTel)
							.addr(strAddr)
							.chain(strChain)
							.build();
			
			int ret = addrDao.insert(addrDTO);
			if(ret > 0) {
				System.out.println("주소록 저장완료!!");
				as.viewAddrList();
			} else {
				System.out.println("주소록 저장실패!!");
				}
			}
		}
		
		public void deleteAddr() {
		

			while (true) {
				System.out.println("=====================");
				System.out.print("삭제할 ID(-Q :quit) >>");
				String strID = scanner.nextLine();

				if (strID.equals("-Q")) break;
				long ID = Long.valueOf(strID);

				AddrDTO addrDTO = addrDao.findById(ID);
				if (addrDTO == null) {
					System.out.println("ID가 없습니다");
					continue;
				}
				addrDao.delete(ID);
				System.out.println("주소록 삭제완료!!");
				as.viewAddrList();
		}
		
	}

		public void updateAddr() {
			
			System.out.println("==================");
			System.out.println("주소록 수정");
			System.out.println("==================");
			System.out.print("수정할 ID(-Q:quit) >> ");
			String strID = scanner.nextLine();
			
			if (strID.equals("-Q"));
			
			long ID = Long.valueOf(strID);
			AddrDTO addrDTO = addrDao.findById(ID);
			
			System.out.printf("변경할 이름(%s)",addrDTO.getName());
			String strName = scanner.nextLine();
			if(strName.trim().length() > 0) {
				addrDTO.setName(strName.trim());
			}
			
			System.out.printf("변경할 전화번호(%s)",addrDTO.getTel());
			String strTel = scanner.nextLine();
			if(strTel.trim().length() > 0) {
				addrDTO.setTel(strTel.trim());
			}
			
			System.out.printf("변경할 주소(%s)",addrDTO.getAddr());
			String strAddr = scanner.nextLine();
			if(strAddr.trim().length() > 0) {
				addrDTO.setAddr(strAddr.trim());
			}
			
			System.out.printf("변경할 관계(%s)",addrDTO.getChain());
			String strChain = scanner.nextLine();
			if(strChain.trim().length() > 0) {
				addrDTO.setChain(strChain.trim());
			}
			
			int ret = addrDao.update(addrDTO);
			if(ret > 0) {
				System.out.println("주소록 변경완료!!");
			} else {
				System.out.println("주소록 변경실패!!");
			}
			
			addrDao.update(addrDTO);
	}	

}

