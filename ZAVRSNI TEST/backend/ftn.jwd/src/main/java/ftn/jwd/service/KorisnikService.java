package ftn.jwd.service;

import ftn.jwd.model.Korisnik;
import ftn.jwd.web.dto.KorisnikPromenaLozinkeDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {

    Optional<Korisnik> findOne(Long id);

    List<Korisnik> findAll();

    Page<Korisnik> findAll(int brojStranice);

    Korisnik save(Korisnik korisnik);

    void delete(Long id);

    Optional<Korisnik> findbyKorisnickoIme(String korisnickoIme);

    boolean changePassword(Long id, KorisnikPromenaLozinkeDto korisnikPromenaLozinkeDto);
}
