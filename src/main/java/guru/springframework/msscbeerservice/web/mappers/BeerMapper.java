package guru.springframework.msscbeerservice.web.mappers;

import guru.sfg.brewery.model.BeerDto;
import guru.springframework.msscbeerservice.domain.Beer;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    BeerDto BeerToBeerDtoWithInventory(Beer beer);

    Beer BeerDtoToBeer(BeerDto dto);
}
