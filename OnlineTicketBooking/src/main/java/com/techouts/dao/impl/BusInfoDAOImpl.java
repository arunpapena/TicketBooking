package com.techouts.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.techouts.ticketbooking.dao.BusInfoDAO;
import com.techouts.ticketbooking.models.BusInfo;

@Repository
public class BusInfoDAOImpl implements BusInfoDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<BusInfo> getAllBusInfo(String sourceStn,String destinationStn) {
			return jdbcTemplate.query("select * from businfo where SOURCESTN='"+sourceStn+"' and DESTINATIONSTN='"+destinationStn+"'", new ResultSetExtractor<List<BusInfo>>() {
				public List<BusInfo> extractData(ResultSet rs) throws SQLException {

					List<BusInfo> list = new ArrayList<BusInfo>();
					while (rs.next()) {
						BusInfo busInfo = new BusInfo();
						busInfo.setBusNo(rs.getInt(1));
						busInfo.setBusName(rs.getString(2));
						busInfo.setSourceStn(rs.getString(3));
						busInfo.setArrivalTime(rs.getString(4));
						busInfo.setDestinationStn(rs.getString(5));
						busInfo.setDepartureTime(rs.getString(6));
						busInfo.setPrice(rs.getInt(7));
						list.add(busInfo);
					}
					return list;
				}
			});
		}
	public List<BusInfo> getSelectedBusInfo(int busInfo) {
		return jdbcTemplate.query("select * from businfo where BUSNO="+busInfo, new ResultSetExtractor<List<BusInfo>>() {
			public List<BusInfo> extractData(ResultSet rs) throws SQLException {

				List<BusInfo> list = new ArrayList<BusInfo>();
				while (rs.next()) {
					BusInfo selectedBus = new BusInfo();
					selectedBus.setBusNo(rs.getInt(1));
					selectedBus.setBusName(rs.getString(2));
					selectedBus.setSourceStn(rs.getString(3));
					selectedBus.setArrivalTime(rs.getString(4));
					selectedBus.setDestinationStn(rs.getString(5));
					selectedBus.setDepartureTime(rs.getString(6));
					selectedBus.setPrice(rs.getInt(7));
					list.add(selectedBus);
				}
				return list;
			}
		});
	}
}
