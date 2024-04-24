package com.example.backend.Main;

import com.example.backend.Dish.Dish;
import com.example.backend.Order.OrderPojo;
import lombok.AllArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("main")
@AllArgsConstructor
public class MainController {

    MainService service;

        @PostMapping("")
        public ResponseEntity<FileSystemResource> getQrCode(@RequestBody MainRequest Req){
            String path = service.generateQrCode(Req.getId());
            File file = new File(path);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(new FileSystemResource(file));
        }

        @PostMapping("order/{tableId}")
        public void createNewOrder(@PathVariable Integer tableId,@RequestBody List<Dish> orderList){
            OrderPojo pojo = new OrderPojo(orderList);
            service.addNewOrder(tableId,pojo);

        }

        @GetMapping("order/{tableId}")
        public OrderPojo getOrdersById(@PathVariable Integer tableId){
            return service.getOrdersById(tableId);
        }

        @DeleteMapping("order/{tableId}")
        public void createNewOrder(@PathVariable Integer tableId){
            service.removeOrderById(tableId);

        }
}
