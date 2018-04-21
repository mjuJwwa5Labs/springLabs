package priv.rdo.sdawwa5.homework.repo;

import org.junit.Test;
import priv.rdo.sdawwa5.homework.IntegrationTestBase;
import priv.rdo.sdawwa5.homework.model.Hotel;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HotelRepositoryTest extends IntegrationTestBase {

    @Test
    public void findWithMinPeopleCount() {
        //when
        List<Hotel> hotelWithRoomsThatHaveMin6people = hotelRepository.findWithMinPeopleCount(6);

        //then
        assertThat(hotelWithRoomsThatHaveMin6people).hasSize(2);
    }

    @Test
    public void findByNameContaining() {
        //when
        List<Hotel> hotelsThatContainWarszawa = hotelRepository.findByNameContaining("Warszawa");

        //then
        assertThat(hotelsThatContainWarszawa).hasSize(2);
    }
}
