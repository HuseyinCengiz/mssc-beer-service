package hc.springframework.msscbeerservice.services;

import hc.springframework.msscbeerservice.domain.Beer;
import hc.springframework.msscbeerservice.repositories.BeerRepository;
import hc.springframework.msscbeerservice.web.controller.NotFoundException;
import hc.springframework.msscbeerservice.web.mappers.BeerMapper;
import hc.springframework.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.BeerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.BeerToBeerDto(beerRepository.save(beerMapper.BeerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {

        Beer currentBeer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        currentBeer.setBeerName(beerDto.getBeerName());
        currentBeer.setBeerStyle(beerDto.getBeerStyle().name());
        currentBeer.setPrice(beerDto.getPrice());
        currentBeer.setUpc(beerDto.getUpc());

        return beerMapper.BeerToBeerDto(beerRepository.save(currentBeer));
    }
}
