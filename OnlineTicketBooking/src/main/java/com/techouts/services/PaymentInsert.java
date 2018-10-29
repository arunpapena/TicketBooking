package com.techouts.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.payment.dto.PaymentDTO;

public class PaymentInsert {
	static JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(PaymentDTO p) {
		String sql = "insert into payment values(?,?,?,?)";
		int result = 0;
		try {
			result = template.update(sql, p.getId(), p.getName(), p.getWallet(), p.getAmount());
		} catch (Exception e) {
			return 500;
		}
		return result;
	}

	public int update(PaymentDTO p) {
		String sql = "update payment set id=" + p.getId() + ",name='" + p.getName() + "',wallet=" + p.getWallet()
				+ ", amount=" + p.getAmount() + " where id=" + p.getId() + "";
		return template.update(sql);

	}

	public int delete(int id) {
		String sql = "delete from payment where id=" + id + "";
		return template.update(sql);
	}

	public PaymentDTO getPaymentDTOById(int id) {
		String sql = "select * from payment where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<PaymentDTO>());
	}

	public List<PaymentDTO> getPaymentDTO() {
		return template.query("select * from payment", new RowMapper<PaymentDTO>() {
			public PaymentDTO mapRow(ResultSet rs, int row) throws SQLException {
				PaymentDTO e = new PaymentDTO();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAmount(rs.getDouble(3));
				e.setWallet(rs.getDouble(4));
				return e;
			}

		});

	}
}