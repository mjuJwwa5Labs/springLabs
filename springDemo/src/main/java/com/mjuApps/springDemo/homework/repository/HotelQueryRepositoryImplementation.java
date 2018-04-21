package com.mjuApps.springDemo.homework.repository;

import com.mjuApps.springDemo.homework.model.entity.HotelEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author marek_j on 2018-04-20
 */
@Repository
public class HotelQueryRepositoryImplementation implements HotelQueryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //@Query("select h from HotelEntity h join RoomEntity r on h = r.hotelEntity where (r.beds between :minBeds and :maxBeds) or (r.extraBeds between :minExtraBeds and :maxExtraBeds)")
    //https://stackoverflow.com/questions/30431035/spring-jpa-repository-dynamic-query
    //https://stackoverflow.com/questions/11138118/really-dynamic-jpa-criteriabuilder
    @Override
    public List<HotelEntity> findHotelByQuery(Integer minBeds, Integer maxBeds, Integer minExtraBeds, Integer maxExtraBeds) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HotelEntity> q = cb.createQuery(HotelEntity.class);
        Root<HotelEntity> hotel = q.from(HotelEntity.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        //todo
//        q.where(cb.gt(minBeds,));
//        Root<User> user = q.from(User.class);
//
//        Path<String> namePath = user.get("name");
//        Path<String> userTypeClassTypeDisplayName =
//                user.get("userType").get("classType").get("displayName");
//        Path<String> userTypeModel = user.get("userType").get("model");
//        List<Predicate> predicates = new ArrayList<>();
//        for(String word : words) {
//            Expression<String> wordLiteral = cb.literal(word);
//            predicates.add(
//                    cb.or(
//                            cb.like(cb.lower(namePath), cb.lower(wordLiteral)),
//                            cb.like(cb.lower(userTypeClassTypeDisplayName),
//                                    cb.lower(wordLiteral)),
//                            cb.like(cb.lower(userTypeModel), cb.lower(wordLiteral))
//                    )
//            );
//        }
//        q.select(doc).where(
//                cb.and(predicates.toArray(new Predicate[predicates.size()]))
//        );
//
//        return entityManager.createQuery(q).getResultList();

        return null;
    }
}
