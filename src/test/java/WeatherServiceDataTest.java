import com.weather_info_for_pincode.Weather_Info_For_Pincode.client.WeatherDataClient;
import com.weather_info_for_pincode.Weather_Info_For_Pincode.dto.WeatherRequestDTO;
import com.weather_info_for_pincode.Weather_Info_For_Pincode.entity.WeatherData;
import com.weather_info_for_pincode.Weather_Info_For_Pincode.repository.WeatherDataRepository;
import com.weather_info_for_pincode.Weather_Info_For_Pincode.service.PinCodeLocationService;
import com.weather_info_for_pincode.Weather_Info_For_Pincode.service.WeatherDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceDataTest {

    @Mock
    private WeatherDataRepository weatherDataRepo;

    @Mock
    private WeatherDataClient client;

    @Mock
    private PinCodeLocationService pinService;

    @InjectMocks
    private WeatherDataService weatherDataService;

    @Test
    public void shouldReturnDataFromDbIfExisting() {

        String pin = "583277";
        WeatherRequestDTO dto = new WeatherRequestDTO();
        dto.setPinCode(pin);

        WeatherData existingData = new WeatherData();
        existingData.setPinCode(pin);
        existingData.setTemp(296.71);


        // when(weatherDataRepo.existsByPinCode(pin)).thenReturn(true);
        // when(weatherDataRepo.findByPinCode(pin)).thenReturn(existingData);
        

       when(weatherDataRepo.existsByPinCodeAndForDate(eq(pin), any()))
        .thenReturn(true);

      when(weatherDataRepo.findByPinCodeAndForDate(eq(pin), any()))
        .thenReturn(existingData);
        


        WeatherData result = weatherDataService.getWeatherData(dto);


        assertEquals(296.71, result.getTemp());

        verifyNoInteractions(client);
        verifyNoInteractions(pinService);
    }
}
