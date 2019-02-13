package com.talent.controller;

import com.talent.model.FileInfo;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author guobing
 * @Title: FileController
 * @ProjectName spring-security
 * @Description: 文件上传下载
 * @date 2019/1/29下午2:37
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private String floder = "/Users/work/idea-workspace/myself/spring-security/imooc-security-demo/src/main/java/com/talent/controller";

    /**
     * 注意： 这里的MultipartFile类型的参数名称必须和前端传递的参数名称一致(这里是指测试用例中的file名称)
     * @param file
     * @return
     */
    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        logger.info("新文件名 【{}】", file.getName());
        logger.info("原始文件名 【{}】", file.getOriginalFilename());
        logger.info("文件大小 【{}】", file.getSize());

        File localFile = new File(floder, System.currentTimeMillis() + ".txt");
        // 将上传的文件写到本地文件中
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    /**
     * 文件下载
     */
    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            // 获取输入流
            inputStream = new FileInputStream(new File(floder, id + ".txt"));
            // 获取输出流
            outputStream = response.getOutputStream();
            // 设置Content-Type
            response.setContentType("application/x-download");
            // 定义下载时的文件名
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");
            // 下载
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
