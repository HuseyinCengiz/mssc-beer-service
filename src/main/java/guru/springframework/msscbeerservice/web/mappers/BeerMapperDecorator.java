package guru.springframework.msscbeerservice.web.mappers;

import guru.sfg.brewery.model.BeerDto;
import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.services.inventory.BeerInventoryService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerMapperDecorator implements BeerMapper {

    private BeerInventoryService beerInventoryService;
    private BeerMapper mapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setMapper(BeerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerDto BeerToBeerDto(Beer beer) {
        return mapper.BeerToBeerDto(beer);
    }

    @Override
    public BeerDto BeerToBeerDtoWithInventory(Beer beer){
        BeerDto dto = mapper.BeerToBeerDto(beer);
        dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));
        return dto;
    }

    @Override
    public Beer BeerDtoToBeer(BeerDto beerDto) {
        return mapper.BeerDtoToBeer(beerDto);
    }
}
