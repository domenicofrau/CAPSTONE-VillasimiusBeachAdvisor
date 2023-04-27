package com.VillasimiusBeachAdvisor.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VillasimiusBeachAdvisor.auth.entity.User;
import com.VillasimiusBeachAdvisor.auth.repository.UserRepository;
import com.VillasimiusBeachAdvisor.auth.security.JwtTokenProvider;
import com.VillasimiusBeachAdvisor.auth.service.AuthService;
import com.VillasimiusBeachAdvisor.main.entity.Spiaggia;
import com.VillasimiusBeachAdvisor.main.repository.SpiaggiaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PreferitiController {
	@Autowired
	private AuthService authService;

	@Autowired
	JwtTokenProvider jwtProv;
	@Autowired
	UserRepository userRepo;
	@Autowired
	SpiaggiaRepository spiaggiaRepo;

	@PostMapping("/preferiti/{id}")
	public ResponseEntity<User> aggiungiPreferito(@PathVariable Long id,
			@RequestHeader(name = "Authorization", required = false) String jwt) {

		String email = jwtProv.getEmailWithoutBearer(jwt);
		User mom = userRepo.findByEmail(email);
		Spiaggia spiaggia = spiaggiaRepo.findById(id).get();
		List<Spiaggia> spiagge = mom.getSpiagge();
		Boolean controllo = true;
		for (int i = 0; i < spiagge.size(); i++) {
			if (spiaggia.getId() == spiagge.get(i).getId()) {
				System.out.println("Spiaggia già presente nei preferiti!");
				controllo = false;
			}
		}
		if (controllo == true) {
			spiagge.add(spiaggia);
			mom.setSpiagge(spiagge);
		}

		return new ResponseEntity<User>(userRepo.save(mom), HttpStatus.OK);

	}

	@DeleteMapping("/preferiti/{id}")
	public ResponseEntity<User> rimuoviPreferito(@PathVariable Long id,
			@RequestHeader(name = "Authorization", required = false) String jwt) {
		String email = jwtProv.getEmailWithoutBearer(jwt);
		User mom = userRepo.findByEmail(email);

		List<Spiaggia> spiagge = mom.getSpiagge();
		int indice = 0;

		for (int i = 0; i < spiagge.size(); i++) {
			if (id == spiagge.get(i).getId()) {
				System.out.println("Spiaggia trovata ed eliminata!");
				indice = i;
			}
		}
		spiagge.remove(indice);
		mom.setSpiagge(spiagge);
		return new ResponseEntity<User>(userRepo.save(mom), HttpStatus.OK);

	}

	@GetMapping("/preferiti/all")
	public ResponseEntity<List<Spiaggia>> tuttiPreferiti(
			@RequestHeader(name = "Authorization", required = false) String jwt) {
		String email = jwtProv.getEmailWithoutBearer(jwt);
		User mom = userRepo.findByEmail(email);

		List<Spiaggia> spiagge = mom.getSpiagge();

		return new ResponseEntity<List<Spiaggia>>(spiagge, HttpStatus.OK);

	}

}
