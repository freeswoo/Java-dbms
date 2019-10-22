package com.biz.addr.persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.addr.config.DBContract;
import com.biz.addr.persistence.AddrDTO;

public class AddrDaoImp extends AddrDao {

	@Override
	public List<AddrDTO> selectAll() {
		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDR;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rst = pStr.executeQuery();
			
			List<AddrDTO> addrList = new ArrayList<AddrDTO>();
			
			while(rst.next()) {
				
				AddrDTO dto = this.rst_2_DTO(rst);
				
				addrList.add(dto);
			}
			rst.close();
			pStr.close();
			return addrList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private AddrDTO rst_2_DTO(ResultSet rst) throws SQLException {
		AddrDTO dto
		= AddrDTO.builder()
				.id(rst.getLong("ID"))
				.name(rst.getString("NAME"))
				.tel(rst.getString("TEL"))
				.chain(rst.getString("CHAIN"))
				.build();
		return dto;
		
		
	}

	@Override
	public AddrDTO findById(long id) {
		
		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDR;
		sql += " WHERE id = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, id);
			ResultSet rst = pStr.executeQuery();
			
			AddrDTO addrDTO = null;
			if(rst.next()) {
				addrDTO = this.rst_2_DTO(rst);
			}
			rst.close();
			pStr.close();
			return addrDTO;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AddrDTO> findByName(String name) {
		
		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDR;
		sql += " WHERE NAME = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, name);
			
			ResultSet rst = pStr.executeQuery();
			List<AddrDTO> addrList = new ArrayList<AddrDTO>();
			while(rst.next()) {
				addrList.add(this.rst_2_DTO(rst));
			}
			rst.close();
			pStr.close();
			return addrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<AddrDTO> findByTel(String tel) {
		
		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDR;
		sql += " WHERE TEL = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, tel);
			
			ResultSet rst = pStr.executeQuery();
			List<AddrDTO> addrList = new ArrayList<AddrDTO>();
			while(rst.next()) {
				addrList.add(this.rst_2_DTO(rst));
			}
			rst.close();
			pStr.close();
			return addrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<AddrDTO> findByChain(String chain) {
		// TODO Auto-generated method stub
		return null;
	}

}
