package br.edu.utfpr.dv.siacoes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.utfpr.dv.siacoes.log.UpdateEvent;
import br.edu.utfpr.dv.siacoes.model.SigetConfig;
import br.edu.utfpr.dv.siacoes.model.SigetConfig.AttendanceFrequency;
import br.edu.utfpr.dv.siacoes.model.SigetConfig.SupervisorFilter;

public class SigetConfigDAO extends SigConfigDAO{

	@Override
	protected String getStringSQLSave(){

		return "INSERT INTO sigetconfig(minimumScore, registerProposal, showgradestostudent, supervisorfilter, cosupervisorfilter, supervisorIndication, maxTutoredStage1, maxTutoredStage2, requestFinalDocumentStage1, repositoryLink, supervisorJuryRequest, supervisorAgreement, supervisorJuryAgreement, validateAttendances, attendanceFrequency, maxfilesize, minimumJuryMembers, minimumJurySubstitutes, jurytimestage1, jurytimestage2, supervisorAssignsGrades, idDepartment) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	}

	@Override
	protected String getStringSQLFindDepartament(){
		return "SELECT * FROM sigetconfig WHERE idDepartment = ?";
	}
		
	private SigetConfig loadObject(ResultSet rs) throws SQLException{
		SigetConfig config = new SigetConfig();
		
		config.getDepartment().setIdDepartment(rs.getInt("idDepartment"));
		config.setMinimumScore(rs.getDouble("minimumScore"));
		config.setRegisterProposal(rs.getInt("registerProposal") == 1);
		config.setShowGradesToStudent(rs.getInt("showgradestostudent") == 1);
		config.setSupervisorFilter(SupervisorFilter.valueOf(rs.getInt("supervisorFilter")));
		config.setCosupervisorFilter(SupervisorFilter.valueOf(rs.getInt("cosupervisorFilter")));
		config.setSupervisorIndication(rs.getInt("supervisorIndication"));
		config.setMaxTutoredStage1(rs.getInt("maxTutoredStage1"));
		config.setMaxTutoredStage2(rs.getInt("maxTutoredStage2"));
		config.setRequestFinalDocumentStage1(rs.getInt("requestFinalDocumentStage1") == 1);
		config.setRepositoryLink(rs.getString("repositoryLink"));
		config.setSupervisorJuryRequest(rs.getInt("supervisorJuryRequest") == 1);
		config.setSupervisorAgreement(rs.getInt("supervisorAgreement") == 1);
		config.setSupervisorJuryAgreement(rs.getInt("supervisorJuryAgreement") == 1);
		config.setValidateAttendances(rs.getInt("validateAttendances") == 1);
		config.setAttendanceFrequency(AttendanceFrequency.valueOf(rs.getInt("attendanceFrequency")));
		config.setMaxFileSize(rs.getInt("maxfilesize"));
		config.setMinimumJuryMembers(rs.getInt("minimumJuryMembers"));
		config.setMinimumJurySubstitutes(rs.getInt("minimumJurySubstitutes"));
		config.setJuryTimeStage1(rs.getInt("jurytimestage1"));
		config.setJuryTimeStage2(rs.getInt("jurytimestage2"));
		config.setSupervisorAssignsGrades(rs.getInt("supervisorAssignsGrades") == 1);
		
		return config;
	}
	
}
