package com.ravindra.springbootiptracing.service;

import com.ravindra.springbootiptracing.entity.IPLocation;
import com.ravindra.springbootiptracing.repo.IPLocationRepo;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IPLocationService {

    @Value("${app.ipUrl}")
    private String ipUrl;

    @Value("${app.ipToken}")
    private String token;

    @Autowired
    private IPLocationRepo ipLocationRepo;

    // Get API Response third party URL
    public IPLocation getIpInfo(String ip){
        String apiUrl = uriBuilder(ipUrl, ip, token);
        String jsonResponse = apiResponse(apiUrl);
        // covert json response into java object
        IPLocation ipLocation = new IPLocation();
        JSONObject mainJsonObj = new JSONObject(jsonResponse);
       // IPProvider ipProvider = new IPProvider();
        ipLocation.setCity(mainJsonObj.getString("city"));
        ipLocation.setCountry(mainJsonObj.getString("country"));
        ipLocation.setIp(mainJsonObj.getString("ip"));
        ipLocation.setRegion(mainJsonObj.getString("region"));
        ipLocation.setLoc(mainJsonObj.getString("loc"));
        ipLocation.setOrg(mainJsonObj.getString("org"));
        ipLocation.setPostal(mainJsonObj.getString("postal"));
        ipLocation.setTimezone(mainJsonObj.getString("timezone"));
// Bizim internet sağlayıcımızda tek obje döndüğünden hata veriyor.
       /* JSONObject companyObj = mainJsonObj.getJSONObject("company");
        ipProvider.setLoc(companyObj.getString("loc"));
        ipProvider.setOrg(companyObj.getString("org"));
        ipProvider.setPostal(companyObj.getString("postal"));
        ipProvider.setTimeZone(companyObj.getString("timeZone"));
        */
        return ipLocation;
    }
    public  String uriBuilder(String ipUrl, String ip, String token){
       return UriComponentsBuilder.fromHttpUrl(ipUrl).path(ip).queryParam("token", token).build().toUriString();
       //http://ipinfo.io/148.252.133.137?token=a15ef167286cfc
    }
    public String apiResponse(String ipUrl){
        OkHttpClient client = new OkHttpClient();
        Request request =new Request.Builder().url(ipUrl).build();
        Response response;
        String apiResponse ="";
        try {
            response = client.newCall(request).execute();
            apiResponse = response.body().string();
        }catch (IOException e){
            e.printStackTrace();
        }
        return apiResponse;
    }

   public IPLocation saveIpInfo(String ip, boolean isSave) {
       IPLocation ipLocation = getIpInfo(ip);
       if (isSave) {
           ipLocationRepo.save(ipLocation);
       }
       return ipLocation;
   }

    public List<IPLocation> getIpDetails() {
        Iterable<IPLocation> ipItr = ipLocationRepo.findAll();
        List<IPLocation> list = StreamSupport.stream(ipItr.spliterator(), false)
                .collect(Collectors.toList());
        return list;
    }


}
