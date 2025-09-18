package br.com.carstore.service;

import br.com.carstore.model.CarDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService  {

    private List<CarDTO> cars;

    public CarServiceImpl(){
        cars = new ArrayList<>();
    }

    @Override
    public List<CarDTO> findAll() {
        return this.cars;
    }

    @Override
    public void save(CarDTO carDTO) {
        carDTO.setId(UUID.randomUUID().toString());
        cars.add(carDTO);
    }

    @Override
    public void deleteById(String id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

    @Override
    public void update(String id, CarDTO carDTO) {
        for (CarDTO c : cars) {
            if (c.getId().equals(id)) {
                c.setName(carDTO.
                        getName());
                c.setColor(carDTO.getColor());
                break;
            }
        }
    }
}
