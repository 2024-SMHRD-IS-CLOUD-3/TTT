package com.smhrd.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class PoseService {

    private final RestTemplate restTemplate;

    public PoseService() {
        this.restTemplate = createRestTemplateWithTimeout();
    }

    public String processImage(MultipartFile file, String poseType) throws IOException {
        String colabUrl = "http://127.0.0.1:5000/process_image"; // Flask 서버의 실제 URL로 변경

        try {
            // 파일을 MultiValueMap으로 변환
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", convert(file));
            System.out.println();
            body.add("pose_type", poseType);
            System.err.println("여기는 서비스"+poseType);

            // 요청 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            // RestTemplate을 사용하여 Flask 서버에 요청 전송
            ResponseEntity<byte[]> response = restTemplate.exchange(colabUrl, HttpMethod.POST, requestEntity,
                    byte[].class);

            // 응답 상태와 헤더를 로그로 남김
            System.out.println("Response Status  : " + response.getStatusCode());
            System.out.println("Response Header  : " + response.getHeaders());

            // 결과 이미지를 저장
            if (response.getStatusCode().is2xxSuccessful()) {
                String filePath = "src/main/resources/static/uploads/result_" + System.currentTimeMillis() + ".jpg";
                try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
                    fos.write(response.getBody());
                }
                return filePath; // 저장될 이미지 경로 반환
            } else {
                throw new RuntimeException("Failed to process image");
            }
        } catch (Exception e) {
            // 상세한 로그 추가
            System.err.println("Error during image processing: " + e.getMessage());
            e.printStackTrace();
            throw e; // 다시 예외를 던져서 컨트롤러에서 처리하게 함
        }
    }

    private static HttpEntity<Resource> convert(MultipartFile file) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("image", file.getOriginalFilename());
        headers.setContentType(MediaType.parseMediaType(file.getContentType()));

        ByteArrayResource resource = new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }
        };

        return new HttpEntity<>(resource, headers);
    }

    // 타임아웃 설정이 포함된 RestTemplate을 생성하는 메서드
    private RestTemplate createRestTemplateWithTimeout() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(15000); // 연결 타임아웃 15초
        factory.setReadTimeout(25000); // 읽기 타임아웃 25초
        return new RestTemplate(factory);
    }
}
