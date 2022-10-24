package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModelMvc {
public final CountGameDao countGameDao;


    public CountGame save(CountGame countGame) {
        if (countGame.getId() != null) {
            Optional<CountGame> countGameFromDBOptional = countGameDao.findById(countGame.getId());
            if (countGameFromDBOptional.isPresent()) {
                CountGame countGameFromDB = countGameFromDBOptional.get();
                System.out.println(countGame.getSet());
                countGameFromDB.setSet(countGame.getSet());
                countGameFromDB.setRating(countGame.getRating());
                countGameFromDB.setDelta(countGame.getDelta());
                countGameFromDB.setPlace(countGame.getPlace());
                return countGameDao.save(countGameFromDB);
            }
        }
        return countGameDao.save(countGame);
    }

}
