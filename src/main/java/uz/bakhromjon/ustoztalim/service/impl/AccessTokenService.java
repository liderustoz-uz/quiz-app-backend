package uz.bakhromjon.ustoztalim.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.bakhromjon.ustoztalim.constant.ErrorMessages;
import uz.bakhromjon.ustoztalim.entity.AccessToken;
import uz.bakhromjon.ustoztalim.exception.user.InvalidDataException;
import uz.bakhromjon.ustoztalim.repository.AccessTokenRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccessTokenService {
    private final AccessTokenRepository repository;


    public AccessToken save(AccessToken accessToken) {
        return repository.save(accessToken);
    }

    public void delete(AccessToken accessToken) {
        repository.delete(accessToken);
    }

    public AccessToken getPersist(String token) throws InvalidDataException {
        Optional<AccessToken> accessTokenOptional = repository.findByToken(token);
        if (accessTokenOptional.isEmpty()) {
            InvalidDataException.throwException(ErrorMessages.WRONG_ACCESS_TOKEN, null);
        }

        return accessTokenOptional.get();
    }
}
