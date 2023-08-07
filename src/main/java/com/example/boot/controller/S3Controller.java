package com.example.boot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@RestController
@RequestMapping("/api/s3")
public class S3Controller {

    @Autowired
    private S3Client s3Client;

    private final String BUCKET_NAME = "crw-axis-uat-axisbucket"; // 修改为你的 S3 存储桶名

    @GetMapping("/upload")
    public String uploadFile() throws IOException, URISyntaxException {
        String keyName = "images/photos/file.txt";

        File fileToUpload = new File("/Users/shuai/1.txt"); // 修改为你的文件路径

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(BUCKET_NAME)
                .key(keyName) // 设置 S3 中的文件名
                .build();

        s3Client.putObject(request, fileToUpload.toPath());
        return "File uploaded: " + keyName;
    }
    /*
    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) {
        byte[] content = s3Client.getObjectAsBytes(BUCKET_NAME, fileName).asByteArray();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(content);
    }

     */
}
