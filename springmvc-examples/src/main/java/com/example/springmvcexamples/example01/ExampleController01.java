package com.example.springmvcexamples.example01;

import com.example.springmvcexamples.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/example01/")
public class ExampleController01 {
    @GetMapping("index")
    public Map getIndex(){
        return Map.of("name","asd");
    }


    @GetMapping("addresses")
    public Map Addresses(){
        Address a1 = new Address(1,"qwe","aaa", LocalDateTime.now());
        Address a2 = new Address(2,"ert","fdg", LocalDateTime.now());
        Address a3 = new Address(3,"dfg","nnn", LocalDateTime.now());
        return Map.of("addresses",List.of(a1,a2,a3),"name","zxc");
    }

    @PostMapping("addresses")
    public Map postAddress(@RequestBody Address address){
        log.debug(address.getDetail());
        log.debug(address.getComment());


        return Map.of();

    }

    @PostMapping("addresses02")
    public Map postAddress02(@RequestBody Address address){
        log.debug(address.getDetail());
        log.debug(address.getComment());
        log.debug("{}",address.getUser().getId());

        return Map.of();

    }


    @GetMapping("addresses/{aid}")
    public Map getAddress(@PathVariable int aid){

        Address address =  ADDRESSES.stream()
                .filter(a->a.getId()==aid)
                .findFirst()
                .orElse(new Address());

        return Map.of("address",address);
    }



    private final List<Address> ADDRESSES = create();
    private List<Address> create(){
        Address a1 = new Address(1,"qwe","aaa", LocalDateTime.now());
        Address a2 = new Address(2,"ert","fdg", LocalDateTime.now());
        Address a3 = new Address(3,"dfg","nnn", LocalDateTime.now());


        return List.of(a1,a2,a3);
    }

}
