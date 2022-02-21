package com.oleg.el.auto.save.data.repository

import com.oleg.el.auto.save.data.nwmodels.Car

interface CarsRepository {
    fun getAll(): List<Car>
    fun getById(id: Long): Car?
    fun create(carDb: Car)
    fun update(id: Long, data: Car)
    fun delete(id: Long)
}