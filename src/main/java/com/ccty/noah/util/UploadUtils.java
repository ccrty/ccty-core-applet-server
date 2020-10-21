package com.ccty.noah.util;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import com.ccty.noah.aop.exception.NoahException;
import com.ccty.noah.domain.constance.ExceptionEnum;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 缄默
 * @date   2020/10/15
 */
@Component
@Slf4j
public class UploadUtils {

    @Value("${tengxun.accessKey}")
    private String accessKey;
    @Value("${tengxun.secretKey}")
    private String secretKey;
    @Value("${tengxun.bucket}")
    private String bucket;
    @Value("${tengxun.bucketName}")
    private String bucketName;
    @Value("${tengxun.path}")
    private String path;

    public String uploadFile(MultipartFile file,String suffix,String fileName){
        // 1 初始化用户身份信息API密钥(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(bucket));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // 存储桶bucket名需包含appid
        // 指定要上传到 COS 上对象键
        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String key = StringUtils.isBlank(fileName)?System.currentTimeMillis()+suffix:fileName;
        File localFile = null;
        try {
            localFile = File.createTempFile("temp",null);
            file.transferTo(localFile);
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
            putObjectRequest.setStorageClass(StorageClass.Standard_IA);
            cosclient.putObject(putObjectRequest);
            return path+key;
        } catch (CosServiceException e) {
            log.error("上传文件错误：{}",e);
        } catch (IOException e) {
            log.error("上传文件错误：{}",e);
        }finally {
            // 关闭客户端
            cosclient.shutdown();
        }
        throw new NoahException(ExceptionEnum.FILE_UPLOAD_ERROR.getCode(),ExceptionEnum.FILE_UPLOAD_ERROR.getName());
    }

    public static void main(String[] args) {
        // 1 初始化用户身份信息API密钥(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials("AKIDnZeWAdjci5GDuMtVGm34qN1OURia3bja", "vmQowsXv50lFVWUBK5dvxjJZrzrUYP2U");
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-nanjing"));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // 存储桶bucket名需包含appid
        String bucketName = "test-1300839768";
        // 指定要上传到 COS 上对象键
        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String key = "2.png";
        File localFile = new File("G:/中建三局门户/zjsy_menhu(1)/zjsy_menhu/img/2011.jpg");
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);
        try {
            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);

            Date expiration = new Date(System.currentTimeMillis() + 5 * 60 * 10000);
            URL url = cosclient.generatePresignedUrl(bucketName, key, expiration);
            System.out.println("图片在COS服务器上的url:"+url);
            // putobjectResult会返回文件的etag
            String etag = putObjectResult.getETag();

        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }

        // 关闭客户端
        cosclient.shutdown();

    }

}
