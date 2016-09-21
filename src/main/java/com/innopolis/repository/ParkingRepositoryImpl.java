package com.innopolis.repository;

import com.innopolis.config.JpaConfig;
import com.innopolis.entity.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kevin Khanda on 21.09.2016.
 * Class that has method for adding parking into database
 */
@org.springframework.stereotype.Repository("parkingRepository")
public class ParkingRepositoryImpl implements ParkingRepository<Parking> {

    @Autowired
    protected JpaConfig jpaConfig = new JpaConfig();

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(jpaConfig.configureDataSource());

    @Override
    public void addParking(Parking parking) {
        Object[] params = new Object[] {parking.getCoordinates(),
        parking.getCapacity(), parking.getParkingName()};
        int[] types = new int[] {Types.VARCHAR, Types.INTEGER, Types.VARCHAR};
        jdbcTemplate.update("INSERT INTO parking (coordinates, capacity, parking_name) " +
                "VALUES (?, ?, ?);", params, types);
    }

    @Override
    public String showParkings() {
        String result = "";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT parking_name, capacity" +
                ", coordinates FROM parking");
        result += "[" + "\n";
        while (rowSet.next()) {
            result += "{\"parkingName\":\"" + rowSet.getString("parking_name") + "\",";
            result += "\"capacity\":\"" + rowSet.getString("capacity") + "\",";
            result += "\"coordinates\":\"" + rowSet.getString("coordinates") + "\"},\n";
        }
        result += "]";
        return result;
    }
}
