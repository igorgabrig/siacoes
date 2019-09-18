package br.edu.utfpr.dv.siacoes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.utfpr.dv.siacoes.log.UpdateEvent;
import br.edu.utfpr.dv.siacoes.model.SigacConfig;

public class SigacConfigDAO extends SigConfigDAO{

	@Override
	protected String getStringSQLSave(){

		return "SELECT * FROM sigacconfig WHERE idDepartment = ?";

	}

	@Override
	protected String getStringSQLFindDepartament(){
		return "INSERT INTO sigacconfig(minimumScore, maxfilesize, idDepartment) VALUES(?, ?, ?)"
	}
	
	private SigacConfig loadObject(ResultSet rs) throws SQLException{
		SigacConfig config = new SigacConfig();
		
		config.getDepartment().setIdDepartment(rs.getInt("idDepartment"));
		config.setMinimumScore(rs.getDouble("minimumScore"));
		config.setMaxFileSize(rs.getInt("maxfilesize"));
		
		return config;
	}

}
