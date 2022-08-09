package com.xyxy.gmall.thirdparty;


import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class GmallThirdPartyApplicationTests {

    @Autowired
    private OSSClient ossClient;

    @Test
    public void saveFile() throws FileNotFoundException {
        /// 填写Bucket名称，例如examplebucket。
        String bucketName = "gmall-jackyzou";
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "ipad1.png";
        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        String filePath= "C:\\Users\\22516\\Pictures\\iPad air4 (1).png";

        InputStream inputStream = new FileInputStream(filePath);
        // 创建PutObject请求。
        ossClient.putObject(bucketName, objectName, inputStream);
        System.out.println("上传成功");
    }
}
