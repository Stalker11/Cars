package com.oleg.el.auto.save.data.controller

import com.oleg.el.auto.save.data.exceptions.CarNotFoundException
import com.oleg.el.auto.save.data.nwmodels.Car
import com.oleg.el.auto.save.data.services.CarsService
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.*

//https://www.youtube.com/watch?v=8fbfHu8isI4
//https://www.youtube.com/watch?v=BLH3s5eTL4Y
//https://www.youtube.com/watch?v=qjZrl-isH7U
@RestController
@RequestMapping("/cars")
class AutoController(private val carsService: CarsService) {
    @GetMapping("/all")
    fun getAllAvailableCars(): List<Car> = carsService.getAllAvailableCars()

    @PostMapping("/create")
    fun createCar(@RequestBody body: Car) {
        carsService.createCar(body)
    }

    @PutMapping("/{id}")
    fun updateCar(@PathVariable id: Long, @RequestBody body: Car) {
        carsService.updateCar(id, body)
    }
    @RequestMapping(value = ["/{carId}"], method = arrayOf(RequestMethod.GET))
    fun getCarById(@PathVariable @NotNull carId: Set<Long>):Car{
        val car = carsService.getCarById(carId.first())
       return car ?: throw CarNotFoundException("Car not found")
    }

}