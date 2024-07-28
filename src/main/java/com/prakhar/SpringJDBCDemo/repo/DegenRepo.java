package com.prakhar.SpringJDBCDemo.repo;

import com.prakhar.SpringJDBCDemo.model.Degen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DegenRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Degen degen) {
        String sql = "insert into degen (id, name, tech) values (?,?,?)";
        int rows = template.update(
                sql,
                degen.getId(),
                degen.getName(),
                degen.getTech()
        );
        System.out.println(rows + "rows affected");
    }

    public List<Degen> findAll() {
        String sql = "select * from degen";

        List<Degen> degens = template.query(sql, (rs, row) -> {
            Degen d = new Degen();
            d.setId(rs.getInt(1));
            d.setName(rs.getString(2));
            d.setTech(rs.getString(3));
            return d;
        });

       return degens;
    }
}
