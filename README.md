# Spring-FileUpload
Spring 파일업로드 

구현 기능 : 연월일시분 기준 폴더 생성 및 저장

* view

![파일 업로드](https://user-images.githubusercontent.com/55639153/69906766-d17c4700-140b-11ea-902b-3ca7324cd374.jpeg)

* 저장 결과

![폴더 별 저장](https://user-images.githubusercontent.com/55639153/69906791-4b143500-140c-11ea-88b2-41b645be99d1.jpeg)


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

## form( post | multipart/form-data 로 보낸다)
    <form method="post" action="upload" enctype="multipart/form-data">
    	<label>파일 : </label> 
    	<input type="file" name="file">
    	<input type="submit" value="upload">
    </form>
