package com.group.libraryapp.practice;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {

    private final JdbcTemplate jdbcTemplate;

    public FruitController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        String sql = "INSERT INTO fruit (name, warehousingDate, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice()
        );
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitCreateRequest request) {

        String readSql = "SELECT * FROM fruit WHERE id = ?";
        boolean isFruitNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isFruitNotExist) {
            throw new IllegalStateException();
        }

        String sql = "UPDATE fruit SET status = 'SOLD' WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
    }
    @GetMapping("/api/v1/fruit/stat")
    public FruitTotalPriceResponse getAmountInfo(@RequestParam String name) {
        String sqlForSold = "SELECT SUM(price) FROM fruit WHERE name = ? AND status = 'SOLD'";
        String sqlForNotSold = "SELECT SUM(price) FROM fruit WHERE name = ? AND status = 'NOT_SOLD'";

        int salesAmount = jdbcTemplate.queryForObject(sqlForSold, Integer.class, name);
        int notSalesAmount = jdbcTemplate.queryForObject(sqlForNotSold, Integer.class, name);

        return new FruitTotalPriceResponse(salesAmount, notSalesAmount);
    }
}

