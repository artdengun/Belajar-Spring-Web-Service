# Belajar Spring Web Services

----------------
## TAHAP AWAL ##
----------------


 1. Membuat File 
	
```
	     
        GroupId     : com.paytech.siup
        Artifact    : Aplikasi-Siup
        description : ini adalah aplikasi siup


```

 2. Depedency  Awal 

```
		Spring-web

```

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
