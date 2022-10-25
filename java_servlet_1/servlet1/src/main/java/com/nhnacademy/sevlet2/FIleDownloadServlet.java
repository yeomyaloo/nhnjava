package com.nhnacademy.sevlet2;

import static java.nio.file.Files.newInputStream;

import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


@MultipartConfig(
    location = "C:\\Users\\yeomyalooo\\Desktop\\study\\tmp",
    //-1L -> 제한 없음
    maxFileSize = -1L,
    maxRequestSize = -1L,
    fileSizeThreshold = 1024
)
@Slf4j
public class FIleDownloadServlet extends HttpServlet {

    private static final String FILE_NAME = "abc.txt";
    private static final String DOWNLOAD_DIR = "C:\\Users\\yeomyalooo\\Desktop\\study\\fileupload";



    String
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {


        resp.setContentType("application/octet-stream");



        getOutpuStream(newInputStream(Paths.get(DOWNLOAD_DIR)));

    }
}
