package com.rrssys.service;

import com.rrssys.entity.Furniture;
import com.rrssys.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureServiceImpl implements IBaseService<Furniture>{
    @Autowired
    private FurnitureRepository furnitureRepository;
    @Override
    public Furniture add(Furniture furniture) {
        if (furniture != null) {
            return furnitureRepository.save(furniture);
        }
        return null;
    }

    @Override
    public Furniture update(Long id, Furniture furniture) {
        if (furniture != null) {
            Furniture furniture1 = furnitureRepository.findById(id).get();
            if (furniture1 != null) {
                furniture1.setName(furniture.getName());
                furniture1.setMaterial(furniture.getMaterial());
                furniture1.setWeigh(furniture.getWeigh());
                furniture1.setSeri(furniture.getSeri());
                furniture1.setRentalPrice(furniture.getRentalPrice());
                furniture1.setQuantity(furniture.getQuantity());

                return furnitureRepository.save(furniture1);
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (id >= 1) {
            Furniture furniture = furnitureRepository.findById(id).get();
            if (furniture != null) {
                furnitureRepository.deleteById(furniture.getId());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Furniture> getAll() {
        return (List<Furniture>) furnitureRepository.findAll();
    }

    @Override
    public Furniture getByID(Long id) {
        return furnitureRepository.findById(id).get();
    }

    @Override
    public Furniture getBySeri(Long seri) {
        return furnitureRepository.findBySeri(seri).get();
    }
}
