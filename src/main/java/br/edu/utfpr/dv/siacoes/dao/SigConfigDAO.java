package br.edu.utfpr.dv.siacoes.dao;

import br.edu.utfpr.dv.siacoes.log.UpdateEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract class SigConfigDAO<T> {

    protected abstract String getStringSQLSave();

    protected abstract String getStringSQLFindDepartament();


    public final T findByDepartment(int idDepartment) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = ConnectionDAO.getInstance().getConnection();

            String sql = getStringSQLFindDepartament();


            if(rs.next()){
                return this.loadObject(rs);
            }else{
                return null;
            }
        }finally{
            if((rs != null) && !rs.isClosed())
                rs.close();
            if((stmt != null) && !stmt.isClosed())
                stmt.close();
            if((conn != null) && !conn.isClosed())
                conn.close();
        }
    }

    public final int save(int idUser, T config) throws SQLException {
        boolean insert = (this.findByDepartment(config.getDepartment().getIdDepartment()) == null);
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = ConnectionDAO.getInstance().getConnection();

            if(insert){
                stmt = conn.prepareStatement("INSERT INTO"+ T +(minimumScore, supervisorPonderosity, companySupervisorPonderosity, showgradestostudent, supervisorfilter, supervisorFillJuryForm, maxfilesize, jurytime, idDepartment) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            }else{
                String sql = getStringSQLSave();

            }

            stmt.setDouble(1, config.getMinimumScore());
            stmt.setDouble(2, config.getSupervisorPonderosity());
            stmt.setDouble(3, config.getCompanySupervisorPonderosity());
            stmt.setInt(4, config.isShowGradesToStudent() ? 1 : 0);
            stmt.setInt(5, config.getSupervisorFilter().getValue());
            stmt.setInt(6, config.isSupervisorFillJuryForm() ? 1 : 0);
            stmt.setInt(7, config.getMaxFileSize());
            stmt.setInt(8, config.getJuryTime());
            stmt.setInt(9, config.getDepartment().getIdDepartment());

            stmt.execute();

            new UpdateEvent(conn).registerUpdate(idUser, config);

            return config.getDepartment().getIdDepartment();
        }finally{
            if((stmt != null) && !stmt.isClosed())
                stmt.close();
            if((conn != null) && !conn.isClosed())
                conn.close();
        }
    }



}
