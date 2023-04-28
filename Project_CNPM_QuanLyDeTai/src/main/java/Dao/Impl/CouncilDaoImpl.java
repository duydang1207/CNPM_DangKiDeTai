package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import Dao.ICouncilDao;
import Models.CouncilModel;

public class CouncilDaoImpl extends DBConnection implements ICouncilDao{
	@Override
	public void insert(CouncilModel council) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO council(topicId,AverageScore) VALUES (?,-1)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);		
			ps.setInt(1, council.getTopicId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void edit(CouncilModel council) {
		String sql = "UPDATE  council SET councilName=?, gender=?, birth=? email=?, phone=? WHERE councilId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, council.getcouncilName());
//			ps.setBoolean(2, council.getGender());
//			ps.setDate(3, council.getBirth());
//			ps.setInt(6, council.getcouncilId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM council WHERE councilId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public CouncilModel get(int id) {
		String sql = "SELECT * FROM council WHERE username = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CouncilModel counciler = new CouncilModel();
//				counciler.setcouncilId(rs.getInt("councilId"));
//				counciler.setcouncilName(rs.getString(id));
//				counciler.setcouncilId(rs.getInt("councilId"));
//				counciler.setCreatedAt(rs.getDate("createdAt"));
//				counciler.setPrice(rs.getBigDecimal("price"));
		
				return counciler;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CouncilModel> getAll() {
		List<CouncilModel> councilers= new ArrayList<CouncilModel>();
		String sql = "SELECT * FROM council";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CouncilModel counciler = new CouncilModel();
				
//				counciler.setcouncilId(rs.getInt("councilId"));
//				counciler.setcouncilName(rs.getString(id));
//				counciler.setcouncilId(rs.getInt("councilId"));
//				counciler.setCreatedAt(rs.getDate("createdAt"));
//				counciler.setPrice(rs.getBigDecimal("price"));
				
				councilers.add(counciler);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return councilers;
	}

	@Override
	public CouncilModel findById(int id) {
		String sql = "SELECT * FROM council WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CouncilModel counciler = new CouncilModel();

//				counciler.setcouncilId(rs.getInt("councilId"));
//				counciler.setcouncilName(rs.getString(id));
//				counciler.setcouncilId(rs.getInt("councilId"));
//				counciler.setCreatedAt(rs.getDate("createdAt"));
//				counciler.setPrice(rs.getBigDecimal("price"));
				
				return counciler;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String checkTopicId(int topicId) {
		String sql = "select topicId from Council where topicId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, topicId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);	
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public CouncilModel getById(int id) {
		String sql = "SELECT * FROM council WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CouncilModel counciler = new CouncilModel();

				counciler.setId(rs.getInt("id"));
				counciler.setTopicId(rs.getInt("topicId"));
				counciler.setAverageScore(rs.getFloat("AverageScore"));
				return counciler;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public CouncilModel getByTopicId(int topicId) {
		String sql = "select * from Council where topicId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, topicId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CouncilModel counciler = new CouncilModel();

				counciler.setId(rs.getInt("id"));
				counciler.setTopicId(rs.getInt("topicId"));
				counciler.setAverageScore(rs.getFloat("averageScore"));
				return counciler;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
