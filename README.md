# Belajar Spring Web Services

----------------
## TAHAP AWAL ##
----------------


 1. Membuat File 
	
```java
	     
        GroupId     : com.paytech.siup
        Artifact    : Aplikasi-Siup
        description : ini adalah aplikasi siup


```

## Penjelasan

* GroupId 	-> Menyatakan Software House Yang membuat aplikasi
* Artifact	-> Menyatakan Nama Aplikasi Yang dibuat
* Description	-> Menyatakan Keterangan Aplikasi Yang dibuat


 2. Depedency  Awal 

```java
		Spring-web

```

## Penjelasan

* Spring-web	-> Package/library Awal yang dibutuhkan Untuk Spring Web

 3. Membuat Controller

```java

@Controller
public class WaktuController {

  @GetMapping("/waktu")
  @ResponseBody
	public String sekarang(){
	SimpleDateFormat formatwaktu = new SimpleDateFormat("EEEE, dd MMMM yyyy",new Locale("id","ID"));
	return formatwaktu.format(new Date());

	}
		

```

## Penjelasan

* @Controller			-> Class yang menyatakan Bahwa File ini sebagai Controller Proses
* public class WaktuController	-> Menyatakan Nama File Dari Class yang digunakan
* @GetMapping("/waktu")		-> Menghandle Url
* @ResponseBody			-> Langsung menampilkan output tanpa membutuhkan file lain (HTML template)
* return 			-> Mengembalikan nilai yang dituju

```java
	public String sekarang(){
	   SimpleDateFormat formatwaktu = new SimpleDateFormat("EEEE, dd MMMM yyyy",new Locale("id","ID"));
		return formatwaktu.format(new Date());

		}

```
* Membuat Object sekarang dengan Menggunakan library SimpleDateFormat(library tanggal ) Untuk Menampilkan waktu 
  Jam, hari, bulan, dan tahun 

 4. Membuat Controller Untuk Json 

```java

		 
    @GetMapping("/appinfo")
    @ResponseBody
    public Map<String, String> info(@RequestParam String nama){
        Map<String, String> data = new LinkedHashMap<>();
        
        data.put("application.name", "Aplikasi SIUP");
        data.put("application.version","1.0.0");
        data.put("last.update", "2020-05-10");
        data.put("author", nama);       
        return data;
    }
}

```
*Panggil Json Lewat URl

```
	http://localhost:8080/appinfo?nama=DeniGunawan
```

*Agar Supaya Rapih gunakan perintah  Dibawah dan letakan pada application.properties

```
spring.jackson.serialization.indent_output=true

```
## Penjelasan

* public class WaktuController	-> Menyatakan Nama File Dari Class yang digunakan
* @GetMapping("/appinfo")	-> Menghandle url
* @ResponseBody			-> Langsung menampilkan output tanpa membutuhkan file lain (HTML template)
* Map				-> assosiative array yang ada di java yang memiliki key dan value
* @RequestParam			-> Menghandle inputan dari External
* data.put			-> Meletakan/ menempelkan Nilai yang ingin kita tampilkan
* LinkedHashMap 		-> Salah satu agar Json Terurut Sesuai Dengan TREE yang ada di put.
* nama				-> mengembalikan nilai nama yang diinput dan menampilkan di author
* return 			-> Mengembalikan nilai yang dituju
* http://localhost:8080/appinfo?nama=DeniGunawan  -> Input Json dengan cara manual 
* spring.jackson.serialization.indent_output=tru  -> agar Json Lebih rapih  ( Letakan di application.properties)

-----------------
## TAHAP KEDUA ##
-----------------

## WEB SERVICE KONFIGURASI

 1. Buat File Yang Dibutuhkan	


```
<kelurahan>
      <id>123</id>
      <kode>JKT001</kode>
      <nama>DUREN SAWIT</nama>
      <kodepos>14000</kodepos>
  </kelurahan>

      <kelurahan id='123' kode='JKT001' nama="DUREN SAWIT"> </kelurahan>


      <daftarKelurahanRequest>
        <pencarian>
          <nama>Cili</nama>
        </pencarian>
      </daftarKelurahanRequest>

    <daftarKelurahanResponse> 
        <daftarKelurahan>
            <kelurahan>
                <id>123</id>
                <kode>JKT001</kode>
                <nama>Duren Sawit</nama>
                <kodepos>124896</kodepos>
            </kelurahan>
            <kelurahan>
                <id>124</id>
                <kode>JKT002</kode>
                <nama>Duren Sawit</nama>
                <kodepos>124896</kodepos>
            </kelurahan>
            <kelurahan>
                <id>124</id>
                <kode>JKT003</kode>
                <nama>Duren Sawit</nama>
                <kodepos>124896</kodepos>
            </kelurahan>
        </daftarKelurahan>
    </daftarKelurahanResponse>

    private kelurahan {
        private String id;
        private String kode;
        private String nama;
        private String kodepos;

    }	

```
## Penjelasan

```
	<daftarKelurahanResponse> 
        <daftarKelurahan>
            <kelurahan>
                <id>123</id>
                <kode>JKT001</kode>
                <nama>Duren Sawit</nama>
                <kodepos>124896</kodepos>
            </kelurahan>
            <kelurahan>
                <id>124</id>
                <kode>JKT002</kode>
                <nama>Duren Sawit</nama>
                <kodepos>124896</kodepos>
            </kelurahan>
            <kelurahan>
                <id>124</id>
                <kode>JKT003</kode>
                <nama>Duren Sawit</nama>
                <kodepos>124896</kodepos>
            </kelurahan>
        </daftarKelurahan>
    </daftarKelurahanResponse>

```
Query Ambil data kelurahan (Response)

```
	<daftarKelurahanRequest>
          <pencarian>
         	 <nama>Cili</nama>
           </pencarian>
      	</daftarKelurahanRequest>

```
Query Cari data kelurahan (Request)



2. Genereate File ke  XSD to XML

  * Kunjungi web  https://www.freeformatter.com/xsd-generator.html
  * Gunakan XSD DESIGN model Salami Slice
  * Copy Request Pertama kali 

  SEBELUM 

  ```
   <daftarKelurahanRequest>
          <pencarian>
         	 <nama>Cili</nama>
           </pencarian>
      	</daftarKelurahanRequest>
 
  ```

  SESUDAH

   ```xml
  <xs:schema attributeFormDefault="unqualified" elementFormDefault="qualified" xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="nama" type="xs:string"/>
  <xs:element name="pencarian">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="nama"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="daftarKelurahanRequest">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="pencarian"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>

   ```

   * Copy Response
  
   SEBELUM

   ```
	<daftarKelurahanResponse> 
        <daftarKelurahan>
            <kelurahan>
                <id>123</id>
                <kode>JKT001</kode>
                <nama>Duren Sawit</nama>
                <kodepos>124896</kodepos>
            </kelurahan>
            <kelurahan>
                <id>124</id>
                <kode>JKT002</kode>
                <nama>Duren Sawit</nama>
                <kodepos>124896</kodepos>
            </kelurahan>
            <kelurahan>
                <id>124</id>
                <kode>JKT003</kode>
                <nama>Duren Sawit</nama>
                <kodepos>124896</kodepos>
            </kelurahan>
        </daftarKelurahan>
    </daftarKelurahanResponse>

   ```
   SESUDAH

   ```xml
	<xs:schema attributeFormDefault="unqualified" elementFormDefault="qualified" xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="id" type="xs:byte"/>
  <xs:element name="kode" type="xs:string"/>
  <xs:element name="nama" type="xs:string"/>
  <xs:element name="kodepos" type="xs:int"/>
  <xs:element name="kelurahan">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="id"/>
        <xs:element ref="kode"/>
        <xs:element ref="nama"/>
        <xs:element ref="kodepos"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="daftarKelurahan">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="kelurahan" maxOccurs="unbounded" minOccurs="0"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="daftarKelurahanResponse">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="daftarKelurahan"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>

   ```

  * Jadikan Satu

   ```xml
<xs:schema attributeFormDefault="unqualified" elementFormDefault="qualified" xmlns:xs="http://www.w3.org/2001/XMLSchema"
	>
  <xs:element name="id" type="xs:integer"/> // ubah dari Byte Ke Integer ( Tipe data yang digunakan )
  <xs:element name="kode" type="xs:string"/>
  <xs:element name="nama" type="xs:string"/>
  <xs:element name="kodepos" type="xs:integer"/>
  <xs:element name="pencarian">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="nama"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="daftarKelurahanRequest">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="pencarian"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="kelurahan">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="id"/>
        <xs:element ref="kode"/>
        <xs:element ref="nama"/>
        <xs:element ref="kodepos"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="daftarKelurahan">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="kelurahan" maxOccurs="unbounded" minOccurs="0"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="daftarKelurahanResponse">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="daftarKelurahan"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>



   ```

3. Tambahkan Library Baru

```java
	<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web-services</artifactId>
        </dependency>
        <dependency>
            <groupId>wsdl4j</groupId>
            <artifactId>wsdl4j</artifactId>
        </dependency>

```
Bagian Plugin

```java
<plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>jaxb2-maven-plugin</artifactId>
                <version>2.5.0</version>
                <executions>
                    <execution>
                        <id>xjc</id>
                        <goals>
                            <goal>xjc</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <sources>
                        <source>${project.basedir}/src/main/resources/siup.xsd</source>
                    </sources>
                </configuration>
           </plugin>
```

## Penjelasan

* wsdl dan web service Library yang dibutuhkan Memproses  XML
* jaxb akan mengenerate domain class . begitu terima request , file tersebut akan di generat otomatis. dari file 
  xsd yang kita bikin 

* Kemudian Build And Clean . 

* Akan ada  File generated, didalam itulah hasil generate file XSD ke Java.

* Bikin folder DTO ( Data Transfer Object )

* Bikin Folder Konfigurasi ( konfigurasi Soap ) 

* didalam folder buat file KonfigurasiSoap.java 


KonfigurasiSoap.java
```java
	@Configuration
        @EnableWs
         public class KonfigurasiSoap extends WsConfigurerAdapter{
            @Bean
	 public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}
        
        
	@Bean(name = "siup")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSiup) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("SiupPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://paytech.com/webservices/siup");
		wsdl11Definition.setSchema(xsdSiup);
		return wsdl11Definition;
	}
        @Bean
	public XsdSchema countriesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("siup.xsd"));
	}

       
}

```
## Penjelasan

```java
@Configuration
        @EnableWs
         public class KonfigurasiSoap extends WsConfigurerAdapter

```

* @EnableWs -> file konfigurasi berasal dari web service
* @Configuration -> annotation agar file ini  di proses
* extends WsConfigurerAdapter -> method method untuk konfigurasi web service

```java
@Bean
	 public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

```
* handler jika ada request ke ws , semua yang mengarah ke url ws akan dihandler oleh konfigurasi diatas. 


```java

@Bean(name = "siup")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSiup) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("SiupPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://paytech.com/webservices/siup");
		wsdl11Definition.setSchema(xsdSiup);
		return wsdl11Definition;
	}


```

* definisi / konfigurasi wisdl agar otomatis dibuatkan

```java
   @Bean
	public XsdSchema countriesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("siup.xsd"));
	}

```
* Untuk membuat wisdle kita  butuh xsd,  kita definisikan pada bagian terakhir 


## tambahkan sedikit konfigurasi dari file xsd yang kita buat 

```java

<xs:schema attributeFormDefault="unqualified" elementFormDefault="qualified" 
xmlns:xs="http://www.w3.org/2001/XMLSchema"
xmlns:tns="http://paytech.com/webservices/siup"
targetNamespace="http://paytech.com/webservices/siup">
  <xs:element name="id" type="xs:integer"/> // ubah dari Byte Ke Integer ( Tipe data yang digunakan )
  <xs:element name="kode" type="xs:string"/>
  <xs:element name="nama" type="xs:string"/>
  <xs:element name="kodepos" type="xs:integer"/>
  <xs:element name="pencarian">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="nama"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="daftarKelurahanRequest">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="pencarian"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="kelurahan">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="id"/>
        <xs:element ref="kode"/>
        <xs:element ref="nama"/>
        <xs:element ref="kodepos"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="daftarKelurahan">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="kelurahan" maxOccurs="unbounded" minOccurs="0"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="daftarKelurahanResponse">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="daftarKelurahan"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>


```

* Untuk melihat hasil akhir ketikan perintah berikut pada url 
```java
	https://localhost:8080/ws/siup.wsdl


```


# IMPLEMENT SOAP ENDPOINT ( HARDCORE ) -> TIDAK MENGGUNAKAN DATABASE

1. Buat FIle di DTO dengan nama KelurahanEndpoint.java

```java

public class KelurahanEndopoint{
	public List<Kelurahan> cari(String nama) {
	List<Kelurahan> hasil = new ArrayList<>();

	Kelurahan k1 = new Kelurahan();
	k1.setId(new BigInteger("1"));
	k1.setKode("k-001");
	k1.setNama(nama);
	k1.setKodepos(new BigInteger("12300"));
	hasil.add(k1);

	Kelurahan k2 = new Kelurahan();
	k2.setId(new BigInteger("2"));
	k2.setKode("k-002");
	k2.setNama(nama);
	k2.setKodepos(new BigInteger("12301"));
	hasil.add(k2);
	
	Kelurahan k3 = new Kelurahan();
	k3.setId(new BigInteger("3"));
	k3.setKode("k-003);
	k3.setNama(nama);
	k3.setKodepos(new BigInteger("12302"));
	hasil.add(k3);

	return hasil;
 }
	@PayloadRoot(localPart = "daftarKelurahanRequest", namespace = "http://paytech.com/webservices/siup")
    @ResponsePayload
    public DaftarKelurahanResponse cariKelurahan(@RequestPayload DaftarKelurahanRequest Request){
            String cariNama= Request.getPencarian().getNama();
            System.out.println("Mencari Kelurahan Dengan nama " + cariNama);
            
            DaftarKelurahanResponse resp = new DaftarKelurahanResponse();
            DaftarKelurahan soapBody = new DaftarKelurahan();
            soapBody.setKelurahan(cari(cariNama));
            resp.setDaftarKelurahan(soapBody);
            return resp;
    
    }
            
}

```

tambahkan perintah di KelurahanDaftar.java

```java
  public void setKelurahan(List<Kelurahan> data ){
	set.kelurahan = data;
	}
```

## Penjelasan

* @RequestPayload -> Request akan diparsing dan dimasukan objeknya
* @PayloadRoot(localPart = "daftarKelurahanRequest", namespace = "http://paytech.com/webservices/siup") -> root elemen 



2. Bungkus localpart dalam soapEnvelope

```java

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
		  xmlns:siup="http://paytech.com/webservices/siup">
    <soapenv:Header/>
    <soapenv:Body>
        <siup:daftarKelurahanRequest>
            <siup:pencarian>
                <siup:nama>Cili</siup:nama>
            </siup:pencarian>
        </siup:daftarKelurahanRequest>
    </soapenv:Body>
</soapenv:Envelope>


```

#PENJELASAN

* Kita test di Postman. Tipenya POST , body raw , Tipe text/XML
* jika sudah berjalan Simpan SoapEnlope
* Simpan di Folder test , Buat Folder Resources 
* Buat lagi Folder dengan nama SoapRequest
* buat Emptyfile "kelurahan-request.xml" simpan

Isi FIle Kelurahan-Request.xml

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
					xmlns:siup="http://paytech.com/webservices/siup">
    <soapenv:Header/>
    <soapenv:Body>
        <siup:daftarKelurahanRequest>
            <siup:pencarian>
                <siup:nama>Cilili</siup:nama>
            </siup:pencarian>
        </siup:daftarKelurahanRequest>
    </soapenv:Body>
</soapenv:Envelope>

```

* buat Emptyfile "kelurahan-response.xml" simpan


Isi FIle Kelurahan-Response.xml

```xml

<SOAP-ENV:Envelope xmlns:SOAP-ENV="https://schemas.xmlsoap.org/soap/enveloper/">
    <SOAP-ENV:Header />
    <SOAP-ENV:Body>
        <ns2:daftarKelurahanResponse xmlns:ns2="http://paytech.com/webservices/siup">
            <ns2:daftarKelurahan>
              <ns2:kelurahan>
	     	<ns2:id>1</ns2:id>
		<ns2:kode>K-001</ns2:kode>
		<ns2:nama>Cilili</ns2:nama>
             	<ns2:kodepos>12300</ns2:kodepos>
	      </ns2:kelurahan>
              <ns2:kelurahan>
	     	<ns2:id>2</ns2:id>
		<ns2:kode>K-002</ns2:kode>
		<ns2:nama>Cilili</ns2:nama>
             	<ns2:kodepos>12301</ns2:kodepos>
	      </ns2:kelurahan>
              <ns2:kelurahan>
	     	<ns2:id>3</ns2:id>
		<ns2:kode>K-003</ns2:kode>
		<ns2:nama>Cilili</ns2:nama>
             	<ns2:kodepos>12302</ns2:kodepos>
	      </ns2:kelurahan>
            </ns2:daftarKelurahan>
          </ns2:daftarKelurahanResponse>
         </SOAP-ENV:Body>
        </SOAP-ENV:Envelope>


```

# IMPLEMENT SOAP ENDPOINT (DESCRIPTION) -> Koneksi dengan database

jAXB berguna untuk mengenerate file XSD ke file java yang akan menghasilkan File java  (Clean and build) , JAXB akan mendeteksi tipe data sendiri . perintah (Clean) akan menghapus generate dari jaxb

1.  BUAT SOAP ENDPOINT TANPA GENERATE JAXB

  * buat folder DTO(Data Transfer Object) Kemudian buat FIle, 
	1. DaftarKelurahan.java
	2. DaftarKelurahanRequest.java
	3. DaftarKelurahanResponse.java
	4. Kelurahan.java
	5. Pencarian.java
	6. package-info.java

DaftarKelurahan.java

```java

@Data
public class DaftarKelurahan {
    private List<Kelurahan> kelurahan = new ArrayList<>();
}


```

DaftarKelurahanRequest.java

```java

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
        name = "daftarKelurahanRequest",
        namespace = "http://paytech.com/webservices/siup"
)
public class DaftarKelurahanRequest {
    private Pencarian pencarian;
    
}

```

DaftarKelurahanResponse.java

```java

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "daftarKelurahanResponse")
public class DaftarKelurahanResponse {
    private DaftarKelurahan daftarKelurahan;
}

```

Kelurahan.java

```java

import lombok.Data;

@Data
public class kelurahan {
	private String id;
	private String kode;
	private String nama;
	private String kodepos;
}


```

Pencarian.java
```java

	package com.paytech.SpringWebService.dto;

	import lombok.Data;

	@Data
	public class Pencarian {
	    private String nama;
	}


```

package-info.java
```java

@XmlSchema(
        namespace = "http://paytech.com/webservices/siup",
        elementFormDefault = XmlNsForm.QUALIFIED)

package com.paytech.SpringWebService.dto;

import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlNsForm;


```
