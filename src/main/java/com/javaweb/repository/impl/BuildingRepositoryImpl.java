package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/qltn";
	static final String USER = "root";
	static final String PASS = "Duchakb123.";
	
	@Override
	public List<BuildingEntity> findAll(String name, Integer districtId) {
		
		StringBuilder sql = new StringBuilder("select * from building b where 1 = 1 ");
		if(name != null && !name.equals("")) {
			sql.append(" AND b.name like '%" + name + "%' ");
		}
		if (districtId != null) {
			sql.append(" AND b.districtId = " + districtId + " ");
		}
			
		List<BuildingEntity> result = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());
			){
			
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				
				building.setNameBuilding(rs.getString("name"));
				building.setNumberOfBasement(rs.getInt("numberOfBaseMent"));
				building.setStreet(rs.getString("road"));
				building.setWard(rs.getString("ward"));
				
				result.add(building);	
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
