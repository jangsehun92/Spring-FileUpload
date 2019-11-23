# String-FileUpload
Spring 파일업로드 

## 관련 dependency
     
    <!-- common fileupload -->
    <dependency>
      <groupId>commons-fileupload</groupId>
      <artifactId>commons-fileupload</artifactId>
      <version>1.3.1</version>
    </dependency>
	
    <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
      <version>2.4</version>
    </dependency>

## 관련 bean 설정(servlet-context.xml)
    <!-- 멀티파트 리졸버 -->
    <beans:bean id="multipartResolver"  class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
    <!-- 최대업로드 가능한 바이트크기 -->
      <beans:property name="maxUploadSize" value="52428800" />
      <!-- 디스크에 임시 파일을 생성하기 전에 메모리에 보관할수있는 최대 바이트 크기 -->
      <!-- property name="maxInMemorySize" value="52428800" / -->
      <!-- defaultEncoding -->
      <beans:property name="defaultEncoding" value="utf-8" />
    </beans:bean>
