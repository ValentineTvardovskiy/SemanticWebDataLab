package com.example.demo.controller;

import com.example.demo.domain.dto.BindingDTO;
import com.example.demo.domain.dto.ItemDTO;
import com.example.demo.domain.dto.ItemLabelDTO;
import com.example.demo.domain.dto.WikiDataDTO;
import com.example.demo.domain.internal.Item;
import com.example.demo.domain.internal.ItemLabel;
import com.example.demo.repository.ItemLabelRepository;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@RestController
public class WikiDataController {

    final ItemRepository itemRepository;
    final ItemLabelRepository itemLabelRepository;

    public WikiDataController(ItemRepository itemRepository, ItemLabelRepository itemLabelRepository) {
        this.itemRepository = itemRepository;
        this.itemLabelRepository = itemLabelRepository;
    }

    @GetMapping("/wiki/data")
    public String receiveData() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://query.wikidata.org/sparql")
                // query param already decoded here
                .queryParam("query", "SELECT ?item ?itemLabel WHERE {  ?item wdt:P31 wd:Q146.   SERVICE wikibase:label { bd:serviceParam wikibase:language \"[AUTO_LANGUAGE],en\". }}")
                .queryParam("format", "json");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.ALL));
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<WikiDataDTO> response = new RestTemplate().exchange(builder.build().encode().toUri(), HttpMethod.GET, httpEntity, WikiDataDTO.class);

        List<BindingDTO> bindings = response.getBody().getResults().getBindings();
        for (BindingDTO binding : bindings) {
            ItemDTO itemDTO = binding.getItem();
            ItemLabelDTO itemLabelDTO = binding.getItemLabel();

            Item item = new Item();
            item.setType(itemDTO.getType());
            item.setValue(itemDTO.getValue());
            Item savedItem = itemRepository.save(item);

            ItemLabel itemLabel = new ItemLabel();
            itemLabel.setItemId(savedItem.getId());
            itemLabel.setLang(itemLabelDTO.getLang());
            itemLabel.setType(itemLabelDTO.getType());
            itemLabel.setValue(itemLabelDTO.getValue());
            itemLabelRepository.save(itemLabel);
        }
        return response.getBody().toString();
    }
}
