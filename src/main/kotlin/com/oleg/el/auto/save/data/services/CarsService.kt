package com.oleg.el.auto.save.data.services

import com.oleg.el.auto.save.data.nwmodels.Car

interface CarsService {
    fun getAllAvailableCars():List<Car>
    fun createCar(car: Car)
    fun updateCar(id: Long, car: Car)
}