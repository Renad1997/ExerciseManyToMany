package com.example.exerciserelationi.Service;

import com.example.exerciserelationi.Api.ApiException;
import com.example.exerciserelationi.DTO.AddressDTO;
import com.example.exerciserelationi.Model.Address;
import com.example.exerciserelationi.Model.Teacher;
import com.example.exerciserelationi.Repository.AddressRepository;
import com.example.exerciserelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public void addAddressToTeacher(AddressDTO addressDTO) {
        Teacher teacher1=teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher1==null){
            throw new ApiException("Teacher not found");
        }

        Address address=new Address(addressDTO.getTeacher_id(),addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher1);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO) {
        Address address=addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(address==null){
            throw new ApiException("Address not found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);

    }

    public void deleteAddress(Integer id) {
    Address address=addressRepository.findAddressById(id);
    if(address==null){
        throw new ApiException("Address not found");
    }
    addressRepository.delete(address);
    }

}
