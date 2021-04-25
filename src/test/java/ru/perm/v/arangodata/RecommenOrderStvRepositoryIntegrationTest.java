package ru.perm.v.arangodata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecommenOrderStvRepositoryIntegrationTest {

    RecommenOrderStvRepository repository;

    @BeforeEach
    void setUp() throws Exception {
        ArangoConfig config = new ArangoConfig("127.0.0.1", "spdev", "root");
        repository = new RecommenOrderStvRepository(config);
    }

    @Test
    void findById() {
        RecommendOrderStv entity = repository.findById("482055").get();
        assertEquals("482055", entity.getKey());
    }

    @Test
    void existsById() {
        assertTrue(repository.existsById("482055"));
    }

    @Test
    void count() {
        assertEquals(4, repository.count());
    }

    @Test
    void saveAndDelete() {
        RecommendOrderStv entity = new RecommendOrderStv();
        entity.setAgreement("AGREEMENT");
        RecommendOrderStv saved = repository.save(entity);
        assertEquals(5, repository.count());
        assertEquals("AGREEMENT", saved.getAgreement());

        repository.delete(saved);
        assertEquals(4, repository.count());
    }

    @Test
    void countByExample() {
        RecommendOrderStv example = new RecommendOrderStv();
        example.setAgreement("D200091874-25");
        assertEquals(2, repository.count(Example.of(example)));
    }

    @Test
    void findByExample() {
        RecommendOrderStv example = new RecommendOrderStv();
        example.setAgreement("D200091874-25");
        ArrayList<RecommendOrderStv> found = new ArrayList();
        repository.findAll(Example.of(example)).iterator().forEachRemaining(found::add);
        assertEquals(2, found.size());
    }

    @Test
    void findByExampleAndSort() {
        RecommendOrderStv example = new RecommendOrderStv();
        example.setCount("2");
        Sort sort = Sort.by(Sort.Direction.ASC, "group");
//                .and(Sort.by(Sort.Direction.DESC));

        ArrayList<RecommendOrderStv> found = new ArrayList();
        repository.findAll(Example.of(example), sort).iterator().forEachRemaining(found::add);

        assertEquals("A", found.get(0).getGroup());
        assertEquals("A", found.get(1).getGroup());
        assertEquals("B", found.get(2).getGroup());
        assertEquals("B", found.get(3).getGroup());
    }
}