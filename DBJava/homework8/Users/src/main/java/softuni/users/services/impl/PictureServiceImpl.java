package softuni.users.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.users.entities.Picture;
import softuni.users.repositories.PictureRepository;
import softuni.users.services.api.PictureService;


@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public void persist(Picture picture) {
        this.pictureRepository.save(picture);
    }
}
