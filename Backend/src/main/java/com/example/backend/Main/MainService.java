package com.example.backend.Main;

import com.example.backend.Order.OrderPojo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MainService {

    public String frontendAddress = "localhost";

    public String frontendPort = "4200";

    @Getter
    @Setter
    HashMap<Integer,OrderPojo> orders = new HashMap<Integer,OrderPojo>();

    public void addNewOrder(Integer tableId, OrderPojo orderPojo){
        orders.put(tableId,orderPojo);
    }
    public void removeOrderById(Integer tableId){
        if(orders.containsKey(tableId))
            orders.remove(tableId);
    }

    public OrderPojo getOrdersById(Integer tableId) {
       return orders.get(tableId);
    }

    public String generateQrCode(String Text) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix qrCode = qrCodeWriter.encode("http://"+frontendAddress+":"+frontendPort+"/table/" + Text,BarcodeFormat.QR_CODE, 256, 256);
            File file = new File(Text);

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            MatrixToImageWriter.writeToStream(qrCode,"png",fileOutputStream);
            return file.getPath();
        }catch (WriterException e){
            System.out.println("Bład podczas generowania kodu QR: "+e.getMessage());
            return "Błąd poczas generowania kodu QR!";
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
