package com.example.SpringSemin4Thymeleaf.repositories;

import com.example.SpringSemin4Thymeleaf.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * выборка всех продуктов
     * @return список продуктов
     */
    public List<Product> findAll(){
        String sql = "SELECT * FROM products";
        RowMapper<Product> productRowMapper= (r,i)->{
            Product rowProduct = new Product();
            rowProduct.setId(r.getInt("id"));
            rowProduct.setName(r.getString("name"));
            rowProduct.setDescription(r.getString("description"));
            rowProduct.setCount_prod(r.getInt("count_prod"));
            return rowProduct;
        };
        return jdbcTemplate.query(sql,productRowMapper);
    }

    /**
     * Добавление продукта
     * @param product продукт для добавления
     * @return сохраненный продукт
     */
    public Product save(Product product){
        String sql = "INSERT INTO products name, description, count_prod" +
                " VALUES (?,?,?)";
        jdbcTemplate.update(sql,product.getName(),product.getDescription(),product.getCount_prod());
        return product;
    }

    /**
     * Удаление продукта из таблицы
     * @param id id продукта
     */
    public void deleteById(int id){
        String sql = "DELETE FROM products WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    /**
     * изменение продукта
     * @param product продукт для изменения
     * @return продукт
     */
    public Product update(Product product){
        String sql = "UPDATE products SET name=?, description=?, count_prod=? WHERE id=?";
        jdbcTemplate.update(sql,product.getName(),product.getDescription(),product.getCount_prod(),product.getId());
        return product;
    }
}
