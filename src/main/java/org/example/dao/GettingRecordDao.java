/**
 * Created By VijayKumar Mohite
 * Date : 8/19/2023
 * Time : 7:10 PM
 * Project : SpringJDBCWithGettingRecordFromDB
 **/

package org.example.dao;

import org.example.domain.GettingRecord;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GettingRecordDao {
  private JdbcTemplate jdbcTemplate;
  private final String SQL_NO_OF_RECORD =" SELECT * FROM JDBCINSERT";

  public GettingRecordDao(JdbcTemplate jdbcTemplate ){this.jdbcTemplate=jdbcTemplate;}
  public void getAllRecord()
  {
      List<GettingRecord> gettingRecordList = jdbcTemplate.queryForObject(SQL_NO_OF_RECORD,new ProjectRowMapper());
      for(GettingRecord gettingRecord:gettingRecordList)
      {
        System.out.println(gettingRecord);
      }
  }
  private final class ProjectRowMapper implements RowMapper<List<GettingRecord>>{

    @Override
    public List<GettingRecord> mapRow(ResultSet resultSet, int i) throws SQLException {

      List<GettingRecord> gettingRecordList = new ArrayList<GettingRecord>();
      while(resultSet.next())
      {
        GettingRecord gettingRecord =new GettingRecord();

        gettingRecord.setInsertId(resultSet.getInt(1));
        gettingRecord.setTitle(resultSet.getString(2));
        gettingRecord.setDescription(resultSet.getString(3));
        gettingRecord.setDuration(resultSet.getInt(4));
        gettingRecord.setStatus(resultSet.getString(5));
        gettingRecordList.add(gettingRecord);
      }
      return gettingRecordList;
    }
  }
}
