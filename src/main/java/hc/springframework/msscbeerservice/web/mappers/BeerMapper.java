package hc.springframework.msscbeerservice.web.mappers;

import hc.springframework.msscbeerservice.domain.Beer;
import hc.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto dto);
}
