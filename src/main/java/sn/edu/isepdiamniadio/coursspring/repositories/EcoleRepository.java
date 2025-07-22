//package sn.edu.isepdiamniadio.coursspring.repositories;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
//import org.springframework.stereotype.Component;
//import sn.edu.isepdiamniadio.coursspring.domain.Ecole;
//
//@Component
//public class EcoleRepository {
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//    public Ecole findEcoleFromId(int id){
//
//
//
//        String sql = "Select * from Ecole WHERE id="+id;
//
//        Ecole ecole = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Ecole.class));
//        return ecole;
//    }
//}
