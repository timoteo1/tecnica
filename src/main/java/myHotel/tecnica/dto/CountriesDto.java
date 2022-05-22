package myHotel.tecnica.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Data
public class CountriesDto {
    
    @JsonProperty("COUNTRY_ID")
    private String countryId;
    @JsonProperty("COUNTRY_NAME")
    private String countryName;
    @JsonProperty("REGION_ID")
    private BigDecimal regionId;

}
