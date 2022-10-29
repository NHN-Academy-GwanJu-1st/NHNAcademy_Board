package com.nhnacademy.board.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Slf4j
public class ImageController implements Command {

    private static String IMAGE_PATH = System.getProperty("user.dir") + "/images";

    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        String fileName = req.getQueryString().split("=")[1];

        log.info("Image Controller " + fileName);
        res.setContentType("multipart/form-data");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        File file = new File(IMAGE_PATH + "/" + fileName);

        byte fileByteArray[] = new byte[(int)file.length()];

        try {
            if (file.isFile()) {
                BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream outs = new BufferedOutputStream(res.getOutputStream());
                int read = 0;
                while ((read=fin.read(fileByteArray))!=-1){
                    outs.write(fileByteArray,0,read);
                }
                outs.close();
                fin.close();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "";
    }
}
