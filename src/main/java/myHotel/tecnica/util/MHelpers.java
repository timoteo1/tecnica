package myHotel.tecnica.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MHelpers {
    
    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
