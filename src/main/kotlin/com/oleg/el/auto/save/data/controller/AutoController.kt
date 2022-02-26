package com.oleg.el.auto.save.data.controller

import com.oleg.el.auto.save.data.nwmodels.Car
import com.oleg.el.auto.save.data.services.CarsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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
}