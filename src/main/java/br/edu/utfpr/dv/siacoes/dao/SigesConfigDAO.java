package br.edu.utfpr.dv.siacoes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.utfpr.dv.siacoes.log.UpdateEvent;
import br.edu.utfpr.dv.siacoes.model.SigesConfig;
import br.edu.utfpr.dv.siacoes.model.SigetConfig.SupervisorFilter;


public class SigesConfigDAO extends SigConfigDAO {

	@Override
	protected String getStringSQLSave(){

		return "SELECT * FROM sigesconfig WHERE idDepartment = ?";

	}

	@Override
	protected String getStringSQLFindDepartament(){
		return "INSERT INTO sigesconfig(minimumScore, supervisorPonderosity, companySupervisorPonderosity, showgradestostudent, supervisorfilter, supervisorFillJuryForm, maxfilesize, jurytime, idDepartment) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"
	}

	private SigesConfig loadObject(ResultSet rs) throws SQLException{
		SigesConfig config = new SigesConfig();
		
		config.getDepartment().setIdDepartment(rs.getInt("idDepartment"));
		config.setMinimumScore(rs.getDouble("minimumScore"));
		config.setSupervisorPonderosity(rs.getDouble("supervisorPonderosity"));
		config.setCompanySupervisorPonderosity(rs.getDouble("companySupervisorPonderosity"));
		config.setShowGradesToStudent(rs.getInt("showgradestostudent") == 1);
		config.setSupervisorFilter(SupervisorFilter.valueOf(rs.getInt("supervisorfilter")));
		config.setSupervisorFillJuryForm(rs.getInt("supervisorFillJuryForm") == 1);
		config.setMaxFileSize(rs.getInt("maxfilesize"));
		config.setJuryTime(rs.getInt("jurytime"));
		
		return config;
	}
	
}
