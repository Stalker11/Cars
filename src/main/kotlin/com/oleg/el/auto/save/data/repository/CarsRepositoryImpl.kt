package com.oleg.el.auto.save.data.repository

import com.oleg.el.auto.save.data.nwmodels.Car
import com.oleg.el.auto.save.data.nwmodels.SupportCars
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class CarsRepositoryImpl(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : CarsRepository {
    override fun getAll(): List<Car> =
        jdbcTemplate.query(
            "select * from cars",
            ROW_MAPPER
        )

    override fun getById(id: Long): Car? =
        jdbcTemplate.query(
            "select * from cars where id = :id",
            mapOf("id" to id),
            ROW_MAPPER
        ).firstOrNull()

    override fun create(carDb: Car) {
        val keyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(
            "insert into cars (model, age, price) values (:model, :age, :price)",
            MapSqlParameterSource(
                mapOf(
                    "model" to carDb.model.name,
                    "age" to carDb.age,
                    "price" to carDb.price
                ),
            ),
            keyHolder,
            listOf("id").toTypedArray()
        )
    }

    override fun update(id: Long, data: Car) {
        jdbcTemplate.update(
            "update cars model = :model, age = :age, price = :price where id = :id",
            mapOf(
                "id" to id,
                "model" to data.model.name,
                "age" to data.age,
                "price" to data.price
            )
        )
    }

    override fun delete(id: Long) {

    }

    private fun ResultSet.getIntroOrNull(columnLabel: String): Int? {
        val value = this.getInt(columnLabel)
        return if (this.wasNull()) {
            null
        } else {
            value
        }
    }

    private companion object {
        val ROW_MAPPER = RowMapper<Car> { rs, _ ->
            Car(
                model = SupportCars.valueOf(rs.getString("model")),
                age = rs.getFloat("age"),
                price = rs.getFloat("price")
            )
        }
    }
}