package ru.perm.v.arangodata;

import com.arangodb.springframework.repository.ArangoRepository;
import com.arangodb.springframework.repository.SimpleArangoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecommenOrderStvRepository extends SimpleArangoRepository<RecommendOrderStv, String>
        implements ArangoRepository<RecommendOrderStv, String> {

    public RecommenOrderStvRepository(ArangoConfig arangoConfig) throws Exception {
        super(arangoConfig.arangoTemplate(), RecommendOrderStv.class);
        log.info("{}", findById("482055").orElse(new RecommendOrderStv()).toString());
    }
}
